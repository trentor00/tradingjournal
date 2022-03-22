package es.antoniogo.tradingjournal.shared.infrastructure.controller.health_check;

import es.antoniogo.tradingjournal.shared.infrastructure.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

final class HealthCheckGetControllerTest extends RequestTestCase {

    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}