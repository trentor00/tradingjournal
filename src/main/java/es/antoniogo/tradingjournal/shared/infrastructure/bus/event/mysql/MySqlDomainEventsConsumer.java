package es.antoniogo.tradingjournal.shared.infrastructure.bus.event.mysql;

import es.antoniogo.tradingjournal.shared.domain.Utils;
import es.antoniogo.tradingjournal.shared.domain.bus.event.DomainEvent;
import es.antoniogo.tradingjournal.shared.infrastructure.bus.event.DomainEventsInformation;
import es.antoniogo.tradingjournal.shared.infrastructure.bus.event.persistence.jpa.DomainEventJPA;
import es.antoniogo.tradingjournal.shared.infrastructure.bus.event.persistence.jpa.DomainEventRepositoryJPA;
import es.antoniogo.tradingjournal.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class MySqlDomainEventsConsumer {
    private DomainEventRepositoryJPA repository;
    private final SpringApplicationEventBus bus;
    private final DomainEventsInformation domainEventsInformation;

    private Boolean shouldStop = false;

    public MySqlDomainEventsConsumer(DomainEventRepositoryJPA repository,
                                     DomainEventsInformation domainEventsInformation,
                                     SpringApplicationEventBus bus
                                     ) {
        this.repository = repository;
        this.domainEventsInformation = domainEventsInformation;
        this.bus = bus;
    }

    @Transactional
    public void consume() {
        while (!shouldStop) {
            try{
                List<DomainEventJPA> events = repository.findTop100ByOrderByOccurredOnAsc();
                try{
                    for (DomainEventJPA event : events) {
                        executeSubscribers(
                                event.getId(),
                                event.getAggregateId(),
                                event.getName(),
                                event.getBody(),
                                event.getOccurredOn()
                        );
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    public void stop() {
        shouldStop = true;
    }

    private void executeSubscribers(
            String id, String aggregateId, String eventName, Map<String, Serializable> body, LocalDateTime occurredOn
    ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<? extends DomainEvent> domainEventClass = domainEventsInformation.forName(eventName);

        DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();

        Method fromPrimitivesMethod = domainEventClass.getMethod(
                "fromPrimitives",
                String.class,
                HashMap.class,
                String.class,
                String.class
        );

        Object domainEvent = fromPrimitivesMethod.invoke(
                nullInstance,
                aggregateId,
                body,
                id,
                Utils.dateToString(occurredOn)
        );

        bus.publish(Collections.singletonList((DomainEvent) domainEvent));
    }
}
