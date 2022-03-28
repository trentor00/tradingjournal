package es.antoniogo.tradingjournal.shared.infrastructure.persistence;

import es.antoniogo.tradingjournal.shared.domain.Utils;

import javax.persistence.AttributeConverter;
import java.io.Serializable;
import java.util.Map;

public class HashMapConverter implements AttributeConverter<Map<String, Serializable>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, Serializable> attribute) {
        return Utils.jsonEncodeMap(attribute);
    }

    @Override
    public Map<String, Serializable> convertToEntityAttribute(String dbData) {
        return Utils.jsonDecodeMap(dbData);
    }
}
