package es.antoniogo.tradingjournal.shared.infrastructure.bus.event.mysql;

import es.antoniogo.tradingjournal.shared.domain.Utils;
import es.antoniogo.tradingjournal.shared.domain.bus.event.DomainEvent;
import es.antoniogo.tradingjournal.shared.domain.bus.event.EventBus;
import es.antoniogo.tradingjournal.shared.infrastructure.bus.event.persistence.jpa.DomainEventJPA;
import es.antoniogo.tradingjournal.shared.infrastructure.bus.event.persistence.jpa.DomainEventRepositoryJPA;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Primary
@Repository("mySqlEventBus")
public class MySqlEventBus implements EventBus {

    private DomainEventRepositoryJPA repository;

    public MySqlEventBus(DomainEventRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void publish(List<DomainEvent<?>> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        DomainEventJPA domainEventJPA = new DomainEventJPA(
                domainEvent.getEventId(),
                domainEvent.getAggregateId(),
                domainEvent.eventName(),
                domainEvent.toPrimitives(),
                Utils.stringToDate(domainEvent.getOccurredOn())
        );
        repository.save(domainEventJPA);
    }
}
