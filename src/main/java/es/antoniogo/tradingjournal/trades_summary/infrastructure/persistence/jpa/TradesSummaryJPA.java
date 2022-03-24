package es.antoniogo.tradingjournal.trades_summary.infrastructure.persistence.jpa;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(name="TradesSummary")
@Table(name="trades_summary")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class TradesSummaryJPA implements Serializable {
    @Id
    private String id;

    private Integer total;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<String> existingTrades;

    public TradesSummaryJPA(String id, Integer total, List<String> existingTrades) {
        this.id = id;
        this.total = total;
        this.existingTrades = existingTrades;
    }

    public TradesSummaryJPA() {

    }

    public String getId() {
        return id;
    }

    public Integer getTotal() {
        return total;
    }

    public List<String> getExistingTrades() {
        return existingTrades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesSummaryJPA that = (TradesSummaryJPA) o;
        return Objects.equals(id, that.id) && Objects.equals(total, that.total) && Objects.equals(existingTrades, that.existingTrades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, existingTrades);
    }

    @Override
    public String toString() {
        return "TradesSummaryJPA{" +
                "id='" + id + '\'' +
                ", total=" + total +
                ", existingTrades=" + existingTrades +
                '}';
    }
}
