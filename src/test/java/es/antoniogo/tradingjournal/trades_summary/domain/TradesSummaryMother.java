package es.antoniogo.tradingjournal.trades_summary.domain;

import es.antoniogo.tradingjournal.shared.domain.ListMother;
import es.antoniogo.tradingjournal.trades.domain.TradeId;
import es.antoniogo.tradingjournal.trades.domain.TradeIdMother;

import java.util.ArrayList;
import java.util.List;

public final class TradesSummaryMother {
    public static TradesSummary create(
            TradesSummaryId id,
            TradesSummaryTotal total,
            List<TradeId> existingTrades
    ) {
        return new TradesSummary(id, total, existingTrades);
    }

    public static TradesSummary withOne(TradeId tradeId) {
        return create(TradesSummaryIdMother.random(), TradesSummaryTotalMother.one(), ListMother.one(tradeId));
    }

    public static TradesSummary random() {
        List<TradeId> existingTrades = ListMother.random(TradeIdMother::random);

        return create(
                TradesSummaryIdMother.random(),
                TradesSummaryTotalMother.create(existingTrades.size()),
                existingTrades
        );
    }

    public static TradesSummary incrementing(TradesSummary existingSummary, TradeId tradeId) {
        List<TradeId> existingTrades = new ArrayList<>(existingSummary.getExistingTrades());
        existingTrades.add(tradeId);

        return create(
                existingSummary.getId(),
                TradesSummaryTotalMother.create(existingSummary.getTotal().getValue() + 1),
                existingTrades
        );
    }
}
