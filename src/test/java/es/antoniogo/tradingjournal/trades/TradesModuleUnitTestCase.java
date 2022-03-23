package es.antoniogo.tradingjournal.trades;

import es.antoniogo.tradingjournal.shared.infrastructure.UnitTestCase;
import es.antoniogo.tradingjournal.trades.domain.Trade;
import es.antoniogo.tradingjournal.trades.domain.TradeRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public abstract class TradesModuleUnitTestCase extends UnitTestCase {
    protected TradeRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(TradeRepository.class);
    }

    public void shouldHaveSaved(Trade trade) {
        verify(repository, atLeastOnce()).save(trade);
    }
}
