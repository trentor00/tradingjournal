package es.antoniogo.tradingjournal.trades.infrastructure;

import es.antoniogo.tradingjournal.trades.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryTradeRepositoryTest {

    @Test
    void save_a_trade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();

        Trade trade = TradeMother.random();

        repository.save(trade);
    }

    @Test
    void return_an_existing_trade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();

        Trade trade = TradeMother.random();

        repository.save(trade);

        assertEquals(Optional.of(trade), repository.search(trade.getId()));
    }

    @Test
    void not_find_a_non_existing_trade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();

        assertFalse(repository.search(TradeIdMother.random()).isPresent());
    }
}