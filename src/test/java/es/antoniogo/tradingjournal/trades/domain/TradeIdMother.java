package es.antoniogo.tradingjournal.trades.domain;

import es.antoniogo.tradingjournal.shared.domain.UuidMother;

public final class TradeIdMother {
    public static TradeId create(String value) {
        return new TradeId(value);
    }

    public static TradeId random() {
        return create(UuidMother.random());
    }
}
