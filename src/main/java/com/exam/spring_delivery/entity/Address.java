package com.exam.spring_delivery.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String city;
    private String street;
    private double latitude;
    private double longitude;
}
