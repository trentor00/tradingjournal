package es.antoniogo.tradingjournal.shared.infrastructure.controller.health_check;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthCheckGetController {
    @GetMapping("/health-check")
    public HashMap<String,String> handle() {
        HashMap<String,String> status = new HashMap<>();
        status.put("status", "ok");

        return status;
    }
}
