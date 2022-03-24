package es.antoniogo.tradingjournal.trades_summary.infrastructure.controller;

import es.antoniogo.tradingjournal.shared.infrastructure.controller.RequestTestCase;
import es.antoniogo.tradingjournal.trades.domain.TradeCreatedDomainEvent;
import org.junit.jupiter.api.Test;

public final class TradesSummaryGetControllerTest extends RequestTestCase {
    @Test
    void get_the_trade_summary_with_one_trade() throws Exception {
        givenISendEventsToTheBus(
                new TradeCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "BTCUSDT", "LONG")
        );

        assertResponse("/trades-summary", 200, "{'total': 1}");
    }

    @Test
    void get_the_trade_summary_with_more_than_one_trade() throws Exception {
        givenISendEventsToTheBus(
                new TradeCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "BTCUSDT", "LONG"),
                new TradeCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "ETHUSDT", "SHORT"),
                new TradeCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DOGEUSDT", "LONG")
        );

        assertResponse("/trades-summary", 200, "{'total': 3}");
    }

    @Test
    void get_the_trade_summary_with_more_than_one_trade_having_duplicated_events() throws Exception {
        givenISendEventsToTheBus(
                new TradeCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "BTCUSDT", "LONG"),
                new TradeCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "BTCUSDT", "LONG"),
                new TradeCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "BTCUSDT", "LONG"),
                new TradeCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "ETHUSDT", "SHORT"),
                new TradeCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "ETHUSDT", "SHORT"),
                new TradeCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "ETHUSDTP", "SHORT"),
                new TradeCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "ETHUSDT", "SHORT"),
                new TradeCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DOGEUSDT", "LONG"),
                new TradeCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DOGEUSDT", "LONG")
        );

        assertResponse("/trades-summary", 200, "{'total': 3}");
    }
}
