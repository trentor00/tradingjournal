package es.antoniogo.tradingjournal.trades.infrastructure.persistence;

import es.antoniogo.tradingjournal.trades.TradesModuleInfrastructureTestCase;
import es.antoniogo.tradingjournal.trades.domain.Trade;
import es.antoniogo.tradingjournal.trades.domain.TradeIdMother;
import es.antoniogo.tradingjournal.trades.domain.TradeMother;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class MySqlTradeRepositoryTest extends TradesModuleInfrastructureTestCase {

    @Test
    void save_a_trade() {
        Trade trade = TradeMother.random();

        mySqlTradeRepository.save(trade);
    }

    @Test
    void return_an_existing_trade() {
        Trade trade = TradeMother.random();

        mySqlTradeRepository.save(trade);

        assertEquals(Optional.of(trade), mySqlTradeRepository.search(trade.getId()));
    }

    @Test
    void not_find_a_non_existing_trade() {
        assertFalse(mySqlTradeRepository.search(TradeIdMother.random()).isPresent());
    }
}