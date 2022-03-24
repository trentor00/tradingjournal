package es.antoniogo.tradingjournal.trades_summary.domain;

import es.antoniogo.tradingjournal.shared.domain.UuidMother;

public final class TradesSummaryIdMother {
    public static TradesSummaryId create(String value) {
        return new TradesSummaryId(value);
    }

    public static TradesSummaryId random() {
        return create(UuidMother.random());
    }
}
