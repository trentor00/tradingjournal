package es.antoniogo.tradingjournal.trades.domain;

import es.antoniogo.tradingjournal.shared.domain.RandomElementPicker;

public final class TradeSymbolMother {
    public static TradeSymbol create(String value) {
        return new TradeSymbol(value);
    }

    public static TradeSymbol random() {
        return create(RandomElementPicker.from(
                "BTCUSDT",
                "ETHUSDT",
                "LITUSDT",
                "DOGEUSDT"
        ));
    }
}
