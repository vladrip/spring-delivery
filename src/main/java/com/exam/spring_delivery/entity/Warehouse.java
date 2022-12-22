package com.exam.spring_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Warehouse {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ToString.Exclude
    @OneToMany(mappedBy = "warehouseFrom")
    private List<Delivery> deliveriesFrom;

    @ToString.Exclude
    @OneToMany(mappedBy = "warehouseTo")
    private List<Delivery> deliveriesTo;
}