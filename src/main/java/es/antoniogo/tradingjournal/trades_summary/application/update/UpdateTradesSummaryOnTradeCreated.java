package es.antoniogo.tradingjournal.trades_summary.application.update;

import es.antoniogo.tradingjournal.trades.domain.TradeCreatedDomainEvent;
import es.antoniogo.tradingjournal.trades.domain.TradeId;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UpdateTradesSummaryOnTradeCreated {
    private final TradesSummaryUpdater updater;

    public UpdateTradesSummaryOnTradeCreated(TradesSummaryUpdater updater) {
        this.updater = updater;
    }

    @Transactional
    @EventListener
    public void on(TradeCreatedDomainEvent event) {
        TradeId tradeId = new TradeId(event.getAggregateId());
        updater.update(tradeId);
        System.out.println("LLegaaa!!!!!!!!!!!!!!");
    }
}
