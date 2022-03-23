package es.antoniogo.tradingjournal.trades.infrastructure.persistence;

import es.antoniogo.tradingjournal.trades.TradesModuleInfrastructureTestCase;
import es.antoniogo.tradingjournal.trades.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryTradeRepositoryTest extends TradesModuleInfrastructureTestCase {

    @Test
    void save_a_trade() {
        Trade trade = TradeMother.random();

        inMemoryTradeRepository.save(trade);
    }

    @Test
    void return_an_existing_trade() {
        Trade trade = TradeMother.random();

        inMemoryTradeRepository.save(trade);

        assertEquals(Optional.of(trade), inMemoryTradeRepository.search(trade.getId()));
    }

    @Test
    void not_find_a_non_existing_trade() {
        assertFalse(inMemoryTradeRepository.search(TradeIdMother.random()).isPresent());
    }
}