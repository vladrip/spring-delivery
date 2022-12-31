package com.exam.spring_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Transporter {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    private String carModel;

    private Integer loadCapacity;

    @ToString.Exclude
    @OneToMany(mappedBy = "transporter")
    private List<Delivery> deliveries;
}