package es.antoniogo.tradingjournal.shared.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public final class Utils {
    public static String dateToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static String dateToString(Timestamp timestamp) {
        return dateToString(timestamp.toLocalDateTime());
    }

    public static LocalDateTime stringToDate(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static Timestamp stringToTimestamp(String date) {
        return Timestamp.valueOf(stringToDate(date));
    }

    public static String jsonEncodeMap(Map<String, Serializable> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static String jsonEncodeList(List<String> list) {
        try {
            return new ObjectMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static Map<String, Serializable> jsonDecodeMap(String body) {
        try {
            return new ObjectMapper().readValue(body, Map.class);
        } catch (IOException e) {
            return null;
        }
    }

    public static List<String> jsonDecodeList(String body) {
        try {
            return new ObjectMapper().readValue(body, List.class);
        } catch (IOException e) {
            return null;
        }
    }

}


