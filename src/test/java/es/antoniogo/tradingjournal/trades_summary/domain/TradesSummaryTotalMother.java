package es.antoniogo.tradingjournal.trades_summary.domain;

import es.antoniogo.tradingjournal.shared.domain.IntegerMother;

public final class TradesSummaryTotalMother {
    public static TradesSummaryTotal create(Integer value) {
        return new TradesSummaryTotal(value);
    }

    public static TradesSummaryTotal random() {
        return create(IntegerMother.random());
    }

    public static TradesSummaryTotal one() {
        return create(1);
    }
}
