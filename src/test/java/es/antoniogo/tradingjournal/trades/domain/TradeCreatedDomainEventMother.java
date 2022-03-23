package es.antoniogo.tradingjournal.trades.domain;

public final class TradeCreatedDomainEventMother {
    public static TradeCreatedDomainEvent create(TradeId id, TradeSymbol symbol, TradeSide side) {
        return new TradeCreatedDomainEvent(id.getValue(), symbol.getValue(), side.getValue());
    }

    public static TradeCreatedDomainEvent fromTrade(Trade trade) {
        return create(trade.getId(), trade.getSymbol(), trade.getSide());
    }

    public static TradeCreatedDomainEvent random() {
        return create(TradeIdMother.random(), TradeSymbolMother.random(), TradeSideMother.random());
    }
}