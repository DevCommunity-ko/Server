package com.devko.magnet.model.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserStatusAttributeConverter implements AttributeConverter<String, Character> {

    @Override
    public Character convertToDatabaseColumn(String attribute) {
        return attribute.charAt(0);
    }

    @Override
    public String convertToEntityAttribute(Character dbData) {
        return dbData.toString();
    }
}
