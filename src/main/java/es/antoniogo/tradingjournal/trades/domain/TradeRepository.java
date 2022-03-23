package es.antoniogo.tradingjournal.trades.domain;

import java.util.Optional;

public interface TradeRepository {
    void save(Trade trade);

    Optional<Trade> search(TradeId id);
}
