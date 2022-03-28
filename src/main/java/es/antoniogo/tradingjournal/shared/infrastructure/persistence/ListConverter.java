package es.antoniogo.tradingjournal.shared.infrastructure.persistence;

import es.antoniogo.tradingjournal.shared.domain.Utils;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return Utils.jsonEncodeList(attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return Utils.jsonDecodeList(dbData);
    }
}
