package es.antoniogo.tradingjournal.trades_summary.infrastructure.controller;

import es.antoniogo.tradingjournal.trades_summary.application.find.TradesSummaryFinder;
import es.antoniogo.tradingjournal.trades_summary.application.find.TradesSummaryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class TradesSummaryGetController {
    TradesSummaryFinder finder;

    public TradesSummaryGetController(TradesSummaryFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/trades-summary")
    public HashMap<String, Integer> index() {
        TradesSummaryResponse response = finder.find();

        return new HashMap<String, Integer>() {{
            put("total", response.getTotal());
        }};
    }
}
