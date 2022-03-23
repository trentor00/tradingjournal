package es.antoniogo.tradingjournal.trades.application.create;

import es.antoniogo.tradingjournal.trades.domain.Trade;
import es.antoniogo.tradingjournal.trades.domain.TradeRepository;
import org.springframework.stereotype.Service;

@Service
public final class TradeCreator {
    private TradeRepository repository;

    public TradeCreator(TradeRepository repository) {
        this.repository = repository;
    }

    public void create(CreateTradeRequest request) {
        Trade trade = new Trade(request.getId(), request.getSymbol(), request.getSide());

        repository.save(trade);
    }
}
