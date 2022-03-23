package es.antoniogo.tradingjournal.trades.domain;

import es.antoniogo.tradingjournal.trades.application.create.CreateTradeRequest;

public final class CreateTradeRequestMother {
    public static CreateTradeRequest create(TradeId id, TradeSymbol symbol, TradeSide side) {
        return new CreateTradeRequest(id.getValue(), symbol.getValue(), side.getValue());
    }

    public static CreateTradeRequest random() {
        return create(TradeIdMother.random(), TradeSymbolMother.random(), TradeSideMother.random());
    }
}
