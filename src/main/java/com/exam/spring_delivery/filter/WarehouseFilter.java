package com.exam.spring_delivery.filter;

import lombok.Value;
import org.springdoc.core.annotations.ParameterObject;

@Value
@ParameterObject
public class WarehouseFilter {
    Long id;
    String title;
    String city;
    String street;
    Double latitude;
    Double longitude;
}