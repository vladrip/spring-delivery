package com.exam.spring_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Address {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String street;

    private double latitude;

    private double longitude;

    @ToString.Exclude
    @OneToOne(mappedBy = "address")
    private Warehouse warehouse;
}
