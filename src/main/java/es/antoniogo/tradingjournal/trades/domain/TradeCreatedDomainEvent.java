package es.antoniogo.tradingjournal.trades.domain;

import es.antoniogo.tradingjournal.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class TradeCreatedDomainEvent extends DomainEvent<TradeCreatedDomainEvent> {
    private String symbol;
    private String side;

    public TradeCreatedDomainEvent(String aggregateId, String symbol, String side) {
        super(aggregateId);

        this.symbol = symbol;
        this.side = side;
    }

    public TradeCreatedDomainEvent(
            String aggregateId,
            String eventId,
            String occurredOn,
            String symbol,
            String side
    ) {
        super(aggregateId, eventId, occurredOn);

        this.symbol = symbol;
        this.side = side;
    }

    public TradeCreatedDomainEvent() {
        super(null);

        this.symbol     = null;
        this.side = null;
    }

    @Override
    public String eventName() {
        return "trade.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("symbol", symbol);
            put("side", side);
        }};
    }

    @Override
    public TradeCreatedDomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    ) {
        return new TradeCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("symbol"),
                (String) body.get("side")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeCreatedDomainEvent that = (TradeCreatedDomainEvent) o;
        return symbol.equals(that.symbol) &&
                side.equals(that.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, side);
    }


}
