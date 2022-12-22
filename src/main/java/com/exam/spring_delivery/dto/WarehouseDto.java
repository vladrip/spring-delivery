package com.exam.spring_delivery.dto;

import lombok.Data;

import java.util.List;

@Data
public class WarehouseDto {
    private Long id;
    private String title;
    private Long addressId;
    private List<Long> deliveriesFromIds;
    private List<Long> deliveriesToIds;
}