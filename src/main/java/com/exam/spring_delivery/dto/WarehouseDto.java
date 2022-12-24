package com.exam.spring_delivery.dto;

import com.exam.spring_delivery.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class WarehouseDto {
    private Long id;
    private String title;
    private Address address;
    private List<Long> deliveriesFromIds;
    private List<Long> deliveriesToIds;
}