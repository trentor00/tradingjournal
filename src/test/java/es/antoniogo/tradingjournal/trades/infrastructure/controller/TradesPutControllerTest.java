package es.antoniogo.tradingjournal.trades.infrastructure.controller;

import es.antoniogo.tradingjournal.shared.infrastructure.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

public final class TradesPutControllerTest extends RequestTestCase {
    @Test
    void create_a_valid_trade() throws Exception {
        assertRequestWithBody(
                "PUT",
                "/trades/d2da9776-f8e2-41ed-90e0-880df4fd9358",
                "{\"symbol\": \"BTCUSDT\", \"side\": \"LONG\"}",
                201
                );
    }
}
