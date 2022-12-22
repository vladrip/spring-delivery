package com.exam.spring_delivery.entity;

import com.exam.spring_delivery.model.delivery.DeliveryStatus;
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

    private Integer cargoAmount;

    /**Конвертація через model.delivery.DeliveryStatusConverter*/
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
}