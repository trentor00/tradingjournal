package es.antoniogo.tradingjournal.shared.domain;

import java.util.Random;

public final class RandomElementPicker {
    public static <T> T from(T... elements) {
        Random rand = new Random();

        return elements[rand.nextInt(elements.length)];
    }
}
