package es.antoniogo.tradingjournal.trades_summary.infrastructure.persistence;

import es.antoniogo.tradingjournal.trades_summary.TradesSummaryModuleInfrastructureTestCase;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummary;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryMother;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
public class MySqlTradesSummaryRepositoryTest extends TradesSummaryModuleInfrastructureTestCase {
    @Test
    void return_an_existing_trades_summary() {
        TradesSummary tradesSummary = TradesSummaryMother.random();

        repository.save(tradesSummary);

        assertEquals(Optional.of(tradesSummary), repository.search());
    }
}
