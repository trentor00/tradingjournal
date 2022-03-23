package es.antoniogo.tradingjournal.trades.domain;

import es.antoniogo.tradingjournal.trades.application.create.CreateTradeRequest;

public final class TradeMother {
    public static Trade create(TradeId id, TradeSymbol symbol, TradeSide side) {
        return new Trade(id, symbol, side);
    }

    public static Trade fromRequest(CreateTradeRequest request) {
        return create(
                TradeIdMother.create(request.getId()),
                TradeSymbolMother.create(request.getSymbol()),
                TradeSideMother.create(request.getSide() )
        );
    }

    public static Trade random() {
        return create(TradeIdMother.random(), TradeSymbolMother.random(), TradeSideMother.random());
    }
}
