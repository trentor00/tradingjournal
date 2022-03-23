package es.antoniogo.tradingjournal.trades.application.create;

import es.antoniogo.tradingjournal.trades.domain.*;
import org.springframework.stereotype.Service;

@Service
public final class TradeCreator {
    private TradeRepository repository;

    public TradeCreator(TradeRepository repository) {
        this.repository = repository;
    }

    public void create(CreateTradeRequest request) {
        Trade trade = new Trade(
                new TradeId(request.getId()),
                new TradeSymbol(request.getSymbol()),
                new TradeSide(request.getSide())
        );

        repository.save(trade);
    }
}
