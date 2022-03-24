package es.antoniogo.tradingjournal.trades_summary.application.find;

import es.antoniogo.tradingjournal.shared.domain.IntegerMother;
import es.antoniogo.tradingjournal.trades_summary.application.find.TradesSummaryResponse;

final class TradesSummaryResponseMother {
    public static TradesSummaryResponse create(Integer value) {
        return new TradesSummaryResponse(value);
    }

    public static TradesSummaryResponse random() {
        return create(IntegerMother.random());
    }
}
