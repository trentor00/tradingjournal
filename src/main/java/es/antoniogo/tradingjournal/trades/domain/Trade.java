package es.antoniogo.tradingjournal.trades.domain;

import java.util.Objects;

public class Trade {
    private String id;
    private String symbol;
    private String side;

    public Trade(String id, String symbol, String side) {
        this.id = id;
        this.symbol = symbol;
        this.side = side;
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
        Trade trade = (Trade) o;
        return Objects.equals(id, trade.id) && Objects.equals(symbol, trade.symbol) && Objects.equals(side, trade.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, side);
    }
}
