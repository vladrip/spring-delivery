package com.exam.spring_delivery.dto;

import lombok.Data;

import java.util.List;

@Data
public class TransporterDto {
    private Long id;
    private String fullname;
    private String carModel;
    private Integer loadCapacity;
    private List<Long> deliveriesIds;
}