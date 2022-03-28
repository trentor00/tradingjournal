package es.antoniogo.tradingjournal.shared.infrastructure.bus.event.mysql;

import es.antoniogo.tradingjournal.shared.infrastructure.InfrastructureTestCase;
import es.antoniogo.tradingjournal.trades.domain.TradeCreatedDomainEvent;
import es.antoniogo.tradingjournal.trades.domain.TradeCreatedDomainEventMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Collections;

@Transactional
class MySqlEventBusTest extends InfrastructureTestCase {
    @Autowired
    private MySqlEventBus eventBus;

    @Autowired
    private MySqlDomainEventsConsumer consumer;

    @Test
    void publish_and_consume_domain_events_from_mysql() throws InterruptedException {
        TradeCreatedDomainEvent domainEvent = TradeCreatedDomainEventMother.random();
        eventBus.publish(Collections.singletonList(domainEvent));

        Thread consumerProcess = new Thread(() -> consumer.consume());
        consumerProcess.start();

        Thread.sleep(1000);

        consumer.stop();
    }
}
