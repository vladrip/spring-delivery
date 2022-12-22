package com.exam.spring_delivery.dto;

import com.exam.spring_delivery.model.delivery.DeliveryStatus;
import lombok.Data;

@Data
public class DeliveryDto {
    private Long id;
    private String cargoName;
    private Integer cargoAmount;
    private DeliveryStatus deliveryStatus;
    private Long warehouseFromId;
    private Long warehouseToId;
    private Long transporterId;
}