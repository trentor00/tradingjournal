package es.antoniogo.tradingjournal.trades.domain;

import java.util.Objects;

public class Trade {
    private TradeId id;
    private TradeSymbol symbol;
    private TradeSide side;

    public Trade(TradeId id, TradeSymbol symbol, TradeSide side) {
        this.id = id;
        this.symbol = symbol;
        this.side = side;
    }

    public TradeId getId() {
        return id;
    }

    public TradeSymbol getSymbol() {
        return symbol;
    }

    public TradeSide getSide() {
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
