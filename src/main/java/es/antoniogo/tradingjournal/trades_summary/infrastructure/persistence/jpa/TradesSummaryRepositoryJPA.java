package es.antoniogo.tradingjournal.trades_summary.infrastructure.persistence.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TradesSummaryRepositoryJPA extends CrudRepository<TradesSummaryJPA, String> {
    List<TradesSummaryJPA> findAll();
}
