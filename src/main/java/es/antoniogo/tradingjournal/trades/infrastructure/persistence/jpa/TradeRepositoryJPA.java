package es.antoniogo.tradingjournal.trades.infrastructure.persistence.jpa;

import org.springframework.data.repository.CrudRepository;

public interface TradeRepositoryJPA extends CrudRepository<TradeJPA, String> {

}
