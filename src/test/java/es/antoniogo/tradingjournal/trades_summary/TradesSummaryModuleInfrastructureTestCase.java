package es.antoniogo.tradingjournal.trades_summary;

import es.antoniogo.tradingjournal.shared.infrastructure.InfrastructureTestCase;
import es.antoniogo.tradingjournal.trades.domain.TradeRepository;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TradesSummaryModuleInfrastructureTestCase extends InfrastructureTestCase {

    @Autowired
    protected TradesSummaryRepository repository;

}
