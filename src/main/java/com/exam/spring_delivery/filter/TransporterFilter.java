package com.exam.spring_delivery.filter;

import lombok.Value;
import org.springdoc.core.annotations.ParameterObject;

@Value
@ParameterObject
public class TransporterFilter {
    Long id;
    String fullname;
    String carModel;
    Integer loadCapacity;
}
