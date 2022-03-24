package es.antoniogo.tradingjournal.trades_summary.domain;

import es.antoniogo.tradingjournal.trades.domain.TradeId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class TradesSummary {
    private TradesSummaryId id;
    private TradesSummaryTotal total;
    private List<TradeId> existingTrades;

    public TradesSummary(TradesSummaryId id, TradesSummaryTotal total, List<TradeId> existingTrades) {
        this.id = id;
        this.total = total;
        this.existingTrades = existingTrades;
    }

    public TradesSummaryId getId() {
        return id;
    }

    public TradesSummaryTotal getTotal() {
        return total;
    }

    public List<TradeId> getExistingTrades() {
        return existingTrades;
    }

    public static TradesSummary initialize(String id) {
        return new TradesSummary(new TradesSummaryId(id), TradesSummaryTotal.initialize(), new ArrayList<>());
    }

    public boolean hasIncremented(TradeId id) {
        return existingTrades.contains(id);
    }

    public void increment(TradeId id) {
        total = total.increment();
        existingTrades.add(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesSummary that = (TradesSummary) o;
        return Objects.equals(id, that.id) && Objects.equals(total, that.total) && Objects.equals(existingTrades, that.existingTrades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, existingTrades);
    }
}
