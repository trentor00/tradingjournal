package es.antoniogo.tradingjournal.trades.application.create;

import es.antoniogo.tradingjournal.trades.domain.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

final class TradeCreatorTest {

    @Test
    void save_a_valid_trade() {
        TradeRepository repository = mock(TradeRepository.class);
        TradeCreator creator = new TradeCreator(repository);

        CreateTradeRequest request = new CreateTradeRequest("e65430b5-0aca-44d8-971b-c9533e80cd8e", "symbol", "side");

        Trade trade = new Trade(
                new TradeId(request.getId()),
                new TradeSymbol(request.getSymbol()),
                new TradeSide(request.getSide())
        );

        creator.create(request);

        verify(repository, atLeastOnce()).save(trade);
    }
}