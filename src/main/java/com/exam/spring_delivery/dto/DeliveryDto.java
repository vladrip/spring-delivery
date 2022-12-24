package com.exam.spring_delivery.dto;

import com.exam.spring_delivery.entity.Delivery;
import lombok.Data;

@Data
public class DeliveryDto {
    private Long id;
    private String cargoName;
    private Integer cargoAmount;
    private Delivery.DeliveryStatus deliveryStatus;
    private Long warehouseFromId;
    private Long warehouseToId;
    private Long transporterId;
}