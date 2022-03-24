package es.antoniogo.tradingjournal.trades_summary.application.find;

import java.util.Objects;

public final class TradesSummaryResponse {
    private Integer total;

    public TradesSummaryResponse(Integer total) {
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesSummaryResponse that = (TradesSummaryResponse) o;
        return Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
