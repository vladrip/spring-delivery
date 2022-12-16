package com.exam.spring_delivery.model.delivery;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class DeliveryStatusConverter implements AttributeConverter<DeliveryStatus, String> {
    @Override
    public String convertToDatabaseColumn(DeliveryStatus deliveryStatus) {
        return deliveryStatus == null ? DeliveryStatus.UNKNOWN.getDbCode() : deliveryStatus.getDbCode();
    }

    @Override
    public DeliveryStatus convertToEntityAttribute(String dbCode) {
        return Stream.of(DeliveryStatus.values())
                .filter(status -> status.getDbCode().equals(dbCode))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
