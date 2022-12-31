package com.exam.spring_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cargoName;

    private Integer cargoWeight;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "warehouse_from_id")
    private Warehouse warehouseFrom;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "warehouse_to_id")
    private Warehouse warehouseTo;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "transporter_id")
    private Transporter transporter;

    public enum DeliveryStatus {
        PROCESSING,
        ACCEPTED,
        IN_TRANSIT,
        DELIVERED,
        PICKED_UP,
        CANCELED,
        UNKNOWN
    }
}