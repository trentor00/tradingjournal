package es.antoniogo.tradingjournal.trades_summary.infrastructure.persistence;

import es.antoniogo.tradingjournal.trades.domain.TradeId;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummary;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryId;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryRepository;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryTotal;
import es.antoniogo.tradingjournal.trades_summary.infrastructure.persistence.jpa.TradesSummaryJPA;
import es.antoniogo.tradingjournal.trades_summary.infrastructure.persistence.jpa.TradesSummaryRepositoryJPA;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MySqlTradesSummaryRepository implements TradesSummaryRepository {

    private TradesSummaryRepositoryJPA repository;

    public MySqlTradesSummaryRepository(TradesSummaryRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public void save(TradesSummary tradesSummary) {
        TradesSummaryJPA tradesSummaryJPA = new TradesSummaryJPA(
                tradesSummary.getId().getValue(),
                tradesSummary.getTotal().getValue(),
                tradesSummary.getExistingTrades().stream()
                        .map(tradeId -> tradeId.getValue()).collect(Collectors.toList())
        );

        repository.save(tradesSummaryJPA);
    }

    @Override
    public Optional<TradesSummary> search() {
        List<TradesSummaryJPA> tradesSummaryJPAs = repository.findAll();
        if(tradesSummaryJPAs.size() == 0){
            return Optional.empty();
        }
        TradesSummaryJPA tradesSummaryJPA = tradesSummaryJPAs.get(0);

        return Optional.ofNullable(new TradesSummary(
                new TradesSummaryId(tradesSummaryJPA.getId()),
                new TradesSummaryTotal(tradesSummaryJPA.getTotal()),
                tradesSummaryJPA.getExistingTrades().stream()
                        .map(tradeId -> new TradeId(tradeId)).collect(Collectors.toList())
        ));
    }

}
