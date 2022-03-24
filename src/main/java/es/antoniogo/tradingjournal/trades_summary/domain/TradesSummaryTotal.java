package es.antoniogo.tradingjournal.trades_summary.domain;

import es.antoniogo.tradingjournal.shared.domain.IntValueObject;

public final class TradesSummaryTotal extends IntValueObject {
    public TradesSummaryTotal(Integer value) {
        super(value);
    }

    public static TradesSummaryTotal initialize() {
        return new TradesSummaryTotal(0);
    }

    public TradesSummaryTotal increment() {
        return new TradesSummaryTotal(getValue() + 1);
    }
}
