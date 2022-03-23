package es.antoniogo.tradingjournal.trades.application.create;

import es.antoniogo.tradingjournal.trades.domain.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

final class TradeCreatorTest {

    @Test
    void save_a_valid_trade() {
        TradeRepository repository = mock(TradeRepository.class);
        TradeCreator creator = new TradeCreator(repository);

        CreateTradeRequest request = CreateTradeRequestMother.random();

        Trade trade = TradeMother.fromRequest(request);

        creator.create(request);

        verify(repository, atLeastOnce()).save(trade);
    }
}