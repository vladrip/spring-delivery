package com.exam.spring_delivery.entity;

import com.exam.spring_delivery.model.delivery.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String cargoName;

    private Integer cargoAmount;

    /**Конвертація через model.delivery.DeliveryStatusConverter*/
    private DeliveryStatus deliveryStatus;

    @ManyToOne
    @JoinColumn(name = "warehouse_from_id")
    private Warehouse warehouseFrom;

    @ManyToOne
    @JoinColumn(name = "warehouse_to_id")
    private Warehouse warehouseTo;

    @ManyToOne
    @JoinColumn(name = "transporter_id")
    private Transporter transporter;
}