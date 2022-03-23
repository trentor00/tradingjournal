package es.antoniogo.tradingjournal.trades.infrastructure.persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity(name="Trade")
@Table(name="trades")
public class TradeJPA implements Serializable {
    @Id
    private String id;
    private String symbol;
    private String side;

    public TradeJPA(String id, String symbol, String side) {
        this.id = id;
        this.symbol = symbol;
        this.side = side;
    }

    public TradeJPA() {
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
        TradeJPA tradeJPA = (TradeJPA) o;
        return Objects.equals(id, tradeJPA.id) && Objects.equals(symbol, tradeJPA.symbol) && Objects.equals(side, tradeJPA.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, side);
    }

    @Override
    public String toString() {
        return "TradeJPA{" +
                "id='" + id + '\'' +
                ", symbol='" + symbol + '\'' +
                ", side='" + side + '\'' +
                '}';
    }
}
