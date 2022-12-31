package com.exam.spring_delivery.filter;

import com.exam.spring_delivery.entity.Delivery.DeliveryStatus;
import lombok.Value;
import org.springdoc.core.annotations.ParameterObject;

@Value
@ParameterObject
public class DeliveryFilter {
    Long id;
    String cargoName;
    Integer cargoWeightMin;
    Integer cargoWeightMax;
    DeliveryStatus deliveryStatus;
    Long warehouseFrom;
    Long warehouseTo;
    Long transporter;
}
