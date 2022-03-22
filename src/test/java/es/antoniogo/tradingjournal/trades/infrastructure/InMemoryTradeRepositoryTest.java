package es.antoniogo.tradingjournal.trades.infrastructure;

import es.antoniogo.tradingjournal.trades.domain.Trade;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryTradeRepositoryTest {

    @Test
    void save_a_valid_trade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();

        repository.save(new Trade("some-id", "some-symbol", "some-side"));
    }

    @Test
    void search_an_existing_trade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();

        Trade trade = new Trade("some-id", "some-symbol", "some-side");

        repository.save(trade);

        assertEquals(Optional.of(trade), repository.search(trade.getId()));
    }

    @Test
    void not_find_a_non_existing_trade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();

        assertFalse(repository.search("non-existing-id").isPresent());
    }
}