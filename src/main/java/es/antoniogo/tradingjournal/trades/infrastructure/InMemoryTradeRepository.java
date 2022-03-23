package es.antoniogo.tradingjournal.trades.infrastructure;

import es.antoniogo.tradingjournal.trades.domain.Trade;
import es.antoniogo.tradingjournal.trades.domain.TradeId;
import es.antoniogo.tradingjournal.trades.domain.TradeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class InMemoryTradeRepository implements TradeRepository {

    private HashMap<TradeId, Trade> trades = new HashMap<>();

    @Override
    public void save(Trade trade) {
        this.trades.put(trade.getId(), trade);
    }

    @Override
    public Optional<Trade> search(TradeId id) {
        return Optional.ofNullable(trades.get(id));
    }
}
