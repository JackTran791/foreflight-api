package com.foreflight.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    public static final String FOREFLIGHT_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FOREFLIGHT_DATETIME_FORMAT);
        String dateTimeString = jsonParser.getText();
        try {
            return LocalDateTime.parse(dateTimeString, formatter);
        } catch (DateTimeException e) {
            log.warn("Unable to parse \"{}\" as LocalDateTime for object {}",
                    dateTimeString,
                    jsonParser.getCurrentValue().getClass().getName());
            return LocalDateTime.MIN;
        }
    }
}
