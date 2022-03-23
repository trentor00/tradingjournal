package es.antoniogo.tradingjournal.shared.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Identifier {
    private String value;

    public Identifier(String value) {
        ensureValidUuid(value);

        this.value = value;
    }

    private void ensureValidUuid(String value) {
        UUID.fromString(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
