package es.antoniogo.tradingjournal.trades.infrastructure.controller;

import es.antoniogo.tradingjournal.trades.application.create.CreateTradeRequest;
import es.antoniogo.tradingjournal.trades.application.create.TradeCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class TradesPutController {
    private TradeCreator creator;

    public TradesPutController(TradeCreator creator) {
        this.creator = creator;
    }

    @PutMapping("/trades/{id}")
    public ResponseEntity<String> create(@PathVariable String id, @RequestBody Request request) {
        creator.create(new CreateTradeRequest(id, request.getSymbol(), request.getSide()));

        return new ResponseEntity(HttpStatus.CREATED);
    }
}

final class Request {
    private String symbol;
    private String side;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}