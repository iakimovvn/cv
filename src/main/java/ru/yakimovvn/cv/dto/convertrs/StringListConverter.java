package ru.yakimovvn.cv.dto.convertrs;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;

/**
 * Create by Vladimir Yakimov on 11.09.2022
 * cv
 **/
public class StringListConverter implements AttributeConverter<List<String>, String> {
    private String DELIMITER = ";";

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return String.join(DELIMITER, attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return Arrays.asList(dbData.split(DELIMITER));

    }
}
