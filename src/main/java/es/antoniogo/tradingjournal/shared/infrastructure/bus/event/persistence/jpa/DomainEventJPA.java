package es.antoniogo.tradingjournal.shared.infrastructure.bus.event.persistence.jpa;

import es.antoniogo.tradingjournal.shared.infrastructure.persistence.HashMapConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Entity(name="DomainEvent")
@Table(name="domain_events")
public class DomainEventJPA implements Serializable {

    @Id
    private String id;

    private String aggregateId;
    private String name;

    @Convert(converter = HashMapConverter.class)
    private Map<String, Serializable> body;

    private LocalDateTime occurredOn;

    public DomainEventJPA(String id, String aggregateId, String name, Map<String, Serializable> body, LocalDateTime occurredOn) {
        this.id = id;
        this.aggregateId = aggregateId;
        this.name = name;
        this.body = body;
        this.occurredOn = occurredOn;
    }

    public DomainEventJPA() {

    }

    public String getId() {
        return id;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public String getName() {
        return name;
    }

    public Map<String, Serializable> getBody() {
        return body;
    }

    public LocalDateTime getOccurredOn() {
        return occurredOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainEventJPA that = (DomainEventJPA) o;
        return Objects.equals(id, that.id) && Objects.equals(aggregateId, that.aggregateId) && Objects.equals(name, that.name) && Objects.equals(body, that.body) && Objects.equals(occurredOn, that.occurredOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aggregateId, name, body, occurredOn);
    }

    @Override
    public String toString() {
        return "DomainEventJPA{" +
                "id='" + id + '\'' +
                ", aggregateId='" + aggregateId + '\'' +
                ", name='" + name + '\'' +
                ", body=" + body +
                ", occurredOn='" + occurredOn + '\'' +
                '}';
    }
}
