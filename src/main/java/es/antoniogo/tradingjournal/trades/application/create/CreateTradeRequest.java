package es.antoniogo.tradingjournal.trades.application.create;

import java.util.Objects;

public final class CreateTradeRequest {
    private final String id;
    private final String symbol;
    private final String side;

    public CreateTradeRequest(String id, String name, String duration) {
        this.id = id;
        this.symbol = name;
        this.side = duration;
    }

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSide() {
        return side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateTradeRequest that = (CreateTradeRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(symbol, that.symbol) && Objects.equals(side, that.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, side);
    }
}
