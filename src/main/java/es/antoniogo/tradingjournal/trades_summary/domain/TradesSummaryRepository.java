package es.antoniogo.tradingjournal.trades_summary.domain;

import java.util.Optional;

public interface TradesSummaryRepository {
    void save(TradesSummary tradesSummary);
    Optional<TradesSummary> search();
}
