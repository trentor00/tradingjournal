package es.antoniogo.tradingjournal.trades.application.create;

import es.antoniogo.tradingjournal.trades.domain.Trade;
import es.antoniogo.tradingjournal.trades.domain.TradeRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

final class TradeCreatorTest {

    @Test
    void save_a_valid_trade() {
        TradeRepository repository = mock(TradeRepository.class);
        TradeCreator creator = new TradeCreator(repository);

        Trade trade = new Trade("some-id", "some-symbol", "some-side");

        creator.create(new CreateTradeRequest(trade.getId(), trade.getSymbol(), trade.getSide()));

        verify(repository, atLeastOnce()).save(trade);
    }
}