package com.exam.spring_delivery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String title;

    /**Хоча відношення 1-1, вирішив винести як окрему entity. Думаю адресу можна назвати географічною сутністю.*/
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "warehouseFrom")
    private List<Delivery> deliveriesFrom;

    @OneToMany(mappedBy = "warehouseTo")
    private List<Delivery> deliveriesTo;
}