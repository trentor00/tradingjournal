package es.antoniogo.tradingjournal.trades;

import es.antoniogo.tradingjournal.shared.infrastructure.InfrastructureTestCase;
import es.antoniogo.tradingjournal.trades.domain.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TradesModuleInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    protected TradeRepository inMemoryTradeRepository;

    @Autowired
    protected TradeRepository mySqlTradeRepository;

}
