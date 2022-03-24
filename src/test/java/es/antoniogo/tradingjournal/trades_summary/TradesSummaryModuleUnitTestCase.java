package es.antoniogo.tradingjournal.trades_summary;

import es.antoniogo.tradingjournal.shared.infrastructure.UnitTestCase;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummary;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class TradesSummaryModuleUnitTestCase extends UnitTestCase {
    protected TradesSummaryRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(TradesSummaryRepository.class);
    }

    public void shouldSearch(TradesSummary tradesSummary) {
        Mockito.when(repository.search()).thenReturn(Optional.of(tradesSummary));
    }

    public void shouldSearch() {
        Mockito.when(repository.search()).thenReturn(Optional.empty());
    }

    public void shouldHaveSaved(TradesSummary tradesSummary) {
        verify(repository, atLeastOnce()).save(tradesSummary);
    }

}
