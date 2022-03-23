package es.antoniogo.tradingjournal.trades.domain;

import es.antoniogo.tradingjournal.shared.domain.RandomElementPicker;

public final class TradeSideMother {
    public static TradeSide create(String value) {
        return new TradeSide(value);
    }

    public static TradeSide random() {
        return create(RandomElementPicker.from("LONG","SHORT"));
    }
}
