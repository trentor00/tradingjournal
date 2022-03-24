package es.antoniogo.tradingjournal.shared.infrastructure;

import es.antoniogo.tradingjournal.shared.domain.UuidGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
