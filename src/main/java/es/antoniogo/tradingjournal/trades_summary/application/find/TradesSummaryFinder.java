package es.antoniogo.tradingjournal.trades_summary.application.find;

import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummary;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryNotInitialized;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryRepository;
import org.springframework.stereotype.Service;

@Service
public final class TradesSummaryFinder {
    private TradesSummaryRepository repository;

    public TradesSummaryFinder(TradesSummaryRepository repository) {
        this.repository = repository;
    }

    public TradesSummaryResponse find() {
        TradesSummary tradesSummary = repository.search().orElseGet(() -> {
            throw new TradesSummaryNotInitialized();
        });

        return new TradesSummaryResponse(tradesSummary.getTotal().getValue());
    }
}
