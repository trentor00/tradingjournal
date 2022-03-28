package es.antoniogo.tradingjournal.trades.application.create;

import es.antoniogo.tradingjournal.shared.domain.bus.event.EventBus;
import es.antoniogo.tradingjournal.trades.domain.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TradeCreator {
    private TradeRepository repository;
    private final EventBus eventBus;

    public TradeCreator(@Qualifier("mySqlTradeRepository") TradeRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    @Transactional
    public void create(CreateTradeRequest request) {
        TradeId tradeId = new TradeId(request.getId());
        TradeSymbol tradeSymbol = new TradeSymbol(request.getSymbol());
        TradeSide tradeSide = new TradeSide(request.getSide());

        Trade trade = Trade.create(tradeId, tradeSymbol, tradeSide);

        repository.save(trade);
        eventBus.publish(trade.pullDomainEvents());
    }
}
