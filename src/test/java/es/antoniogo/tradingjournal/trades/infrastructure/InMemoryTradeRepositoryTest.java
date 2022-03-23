package es.antoniogo.tradingjournal.trades.infrastructure;

import es.antoniogo.tradingjournal.trades.domain.Trade;
import es.antoniogo.tradingjournal.trades.domain.TradeId;
import es.antoniogo.tradingjournal.trades.domain.TradeSide;
import es.antoniogo.tradingjournal.trades.domain.TradeSymbol;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryTradeRepositoryTest {

    @Test
    void save_a_trade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();

        Trade trade = new Trade(
                new TradeId("e65430b5-0aca-44d8-971b-c9533e80cd8e"),
                new TradeSymbol("symbol"),
                new TradeSide("side")
        );

        repository.save(trade);
    }

    @Test
    void return_an_existing_trade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();

        Trade trade = new Trade(
                new TradeId("e65430b5-0aca-44d8-971b-c9533e80cd8e"),
                new TradeSymbol("symbol"),
                new TradeSide("side")
        );

        repository.save(trade);

        assertEquals(Optional.of(trade), repository.search(trade.getId()));
    }

    @Test
    void not_find_a_non_existing_trade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();

        assertFalse(repository.search(new TradeId("a65430b5-0aca-44d8-971b-c9533e80cd8e")).isPresent());
    }
}