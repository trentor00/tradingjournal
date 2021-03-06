package es.antoniogo.tradingjournal.shared.domain.bus.event;

import es.antoniogo.tradingjournal.shared.domain.Utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public abstract class DomainEvent<T extends DomainEvent<?>> {
    private String aggregateId;
    private String eventId;
    private String occurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = Utils.dateToString(LocalDateTime.now());
    }

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId     = eventId;
        this.occurredOn  = occurredOn;
    }

    protected DomainEvent() {

    }

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitives();

    public abstract T fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    );

    public String getAggregateId() {
        return aggregateId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getOccurredOn() {
        return occurredOn;
    }
}
