package es.antoniogo.tradingjournal.trades_summary.application.update;

import es.antoniogo.tradingjournal.trades.domain.TradeCreatedDomainEvent;
import es.antoniogo.tradingjournal.trades.domain.TradeCreatedDomainEventMother;
import es.antoniogo.tradingjournal.trades.domain.TradeId;
import es.antoniogo.tradingjournal.trades.domain.TradeIdMother;
import es.antoniogo.tradingjournal.trades_summary.TradesSummaryModuleUnitTestCase;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummary;
import es.antoniogo.tradingjournal.trades_summary.domain.TradesSummaryMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class UpdateTradesSummaryOnTradeCreatedTest extends TradesSummaryModuleUnitTestCase {
    UpdateTradesSummaryOnTradeCreated subscriber;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subscriber = new UpdateTradesSummaryOnTradeCreated(
                new TradesSummaryUpdater(repository, uuidGenerator)
        );
    }

    @Test
    void initialize_a_new_trades_summary() {
        TradeCreatedDomainEvent event = TradeCreatedDomainEventMother.random();

        TradeId tradeId = TradeIdMother.create(event.getAggregateId());
        TradesSummary newTradesSummary = TradesSummaryMother.withOne(tradeId);

        shouldSearch();
        shouldGenerateUuid(newTradesSummary.getId().getValue());

        subscriber.on(event);

        shouldHaveSaved(newTradesSummary);
    }

    @Test
    void increment_an_existing_trades_summary() {
        TradeCreatedDomainEvent event = TradeCreatedDomainEventMother.random();

        TradeId tradeId = TradeIdMother.create(event.getAggregateId());
        TradesSummary existingTradesSummary = TradesSummaryMother.random();
        TradesSummary incrementedTradesSummary = TradesSummaryMother.incrementing(existingTradesSummary, tradeId);

        shouldSearch(existingTradesSummary);

        subscriber.on(event);

        shouldHaveSaved(incrementedTradesSummary);
    }

    @Test
    void not_increment_an_already_incremented_trade() {
        TradeCreatedDomainEvent event = TradeCreatedDomainEventMother.random();

        TradeId tradeId = TradeIdMother.create(event.getAggregateId());
        TradesSummary existingTradesSummary = TradesSummaryMother.withOne(tradeId);

        shouldSearch(existingTradesSummary);

        subscriber.on(event);
    }

}
