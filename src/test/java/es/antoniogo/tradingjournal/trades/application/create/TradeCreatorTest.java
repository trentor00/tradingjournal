package es.antoniogo.tradingjournal.trades.application.create;

import es.antoniogo.tradingjournal.trades.TradesModuleUnitTestCase;
import es.antoniogo.tradingjournal.trades.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class TradeCreatorTest extends TradesModuleUnitTestCase {

    private TradeCreator creator;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        creator = new TradeCreator(repository);
    }

    @Test
    void create_a_valid_trade() {
        CreateTradeRequest request = CreateTradeRequestMother.random();

        Trade trade = TradeMother.fromRequest(request);

        creator.create(request);

        shouldHaveSaved(trade);
    }
}