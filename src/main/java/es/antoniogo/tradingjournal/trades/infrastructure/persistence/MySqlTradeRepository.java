package es.antoniogo.tradingjournal.trades.infrastructure.persistence;

import es.antoniogo.tradingjournal.trades.domain.*;
import es.antoniogo.tradingjournal.trades.infrastructure.persistence.jpa.TradeJPA;
import es.antoniogo.tradingjournal.trades.infrastructure.persistence.jpa.TradeRepositoryJPA;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository("mySqlTradeRepository")
@Transactional
public class MySqlTradeRepository implements TradeRepository {

    private TradeRepositoryJPA repository;

    public MySqlTradeRepository(TradeRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void save(Trade trade) {
        TradeJPA tradeJPA = new TradeJPA(trade.getId().getValue(), trade.getSymbol().getValue(),trade.getSide().getValue());
        repository.save(tradeJPA);
    }

    @Override
    public Optional<Trade> search(TradeId id) {
        Optional<TradeJPA> tradeJPA = repository.findById(id.getValue());
        if(tradeJPA.isEmpty()){
            return Optional.empty();
        }
        Trade trade = new Trade(new TradeId(tradeJPA.get().getId()),new TradeSymbol(tradeJPA.get().getSymbol()), new TradeSide(tradeJPA.get().getSide()));
        return Optional.of(trade);
    }
}
