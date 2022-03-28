package es.antoniogo.tradingjournal.shared.infrastructure.bus.event.persistence.jpa;

import es.antoniogo.tradingjournal.trades_summary.infrastructure.persistence.jpa.TradesSummaryJPA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DomainEventRepositoryJPA extends CrudRepository<DomainEventJPA, String> {
    List<DomainEventJPA> findTop100ByOrderByOccurredOnAsc();
}
