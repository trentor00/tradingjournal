package es.antoniogo.tradingjournal.trades_summary.application.update;

import es.antoniogo.tradingjournal.shared.domain.UuidGenerator;
import es.antoniogo.tradingjournal.trades.domain.TradeId;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummary;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryRepository;
import org.springframework.stereotype.Service;

@Service
public final class TradesSummaryUpdater {
    private TradesSummaryRepository repository;
    private UuidGenerator uuidGenerator;

    public TradesSummaryUpdater(TradesSummaryRepository repository, UuidGenerator uuidGenerator) {
        this.repository = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void update(TradeId id) {
        TradesSummary tradesSummary = repository.search()
                .orElseGet(() -> TradesSummary.initialize(uuidGenerator.generate()));

        if(!tradesSummary.hasIncremented(id)) {
            tradesSummary.increment(id);

            repository.save(tradesSummary);
        }
    }
}
