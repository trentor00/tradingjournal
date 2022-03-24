package es.antoniogo.tradingjournal.trades_summary.application.find;

import es.antoniogo.tradingjournal.trades_summary.TradesSummaryModuleUnitTestCase;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummary;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryMother;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryNotInitialized;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class TradesSummaryFinderTest extends TradesSummaryModuleUnitTestCase {
    TradesSummaryFinder finder;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        finder = new TradesSummaryFinder(repository);
    }

    @Test
    void find_an_existing_trades_summary() {
        TradesSummary tradesSummary  = TradesSummaryMother.random();
        TradesSummaryResponse response = TradesSummaryResponseMother.create(tradesSummary.getTotal().getValue());

        shouldSearch(tradesSummary);

        assertEquals(response, finder.find());
    }

    @Test
    void throw_an_exception_when_trades_summary_does_not_exists() {
        shouldSearch();

        assertThrows(TradesSummaryNotInitialized.class, () -> finder.find());
    }
}
