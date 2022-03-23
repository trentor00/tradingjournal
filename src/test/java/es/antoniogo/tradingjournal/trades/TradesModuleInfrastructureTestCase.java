package es.antoniogo.tradingjournal.trades;

import es.antoniogo.tradingjournal.shared.infrastructure.InfrastructureTestCase;
import es.antoniogo.tradingjournal.trades.infrastructure.InMemoryTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TradesModuleInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    protected InMemoryTradeRepository repository;

}
