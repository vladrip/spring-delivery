package com.exam.spring_delivery.repository;

import com.exam.spring_delivery.entity.Delivery;
import com.exam.spring_delivery.filter.DeliveryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    @Query("""
        SELECT d FROM Delivery AS d
        WHERE (:#{#d.id} IS NULL OR :#{#d.id} = d.id)
        AND (:#{#d.cargoName} IS NULL OR lower(d.cargoName) LIKE concat('%', lower(:#{#d.cargoName}),'%'))
        AND (:#{#d.cargoWeightMin} IS NULL OR :#{#d.cargoWeightMax} IS NULL
            OR d.cargoWeight BETWEEN :#{#d.cargoWeightMin} AND :#{#d.cargoWeightMax})
        AND (:deliveryStatus IS NULL OR :deliveryStatus = d.deliveryStatus)
        AND (:#{#d.warehouseFrom} IS NULL OR :#{#d.warehouseFrom} = d.warehouseFrom.id)
        AND (:#{#d.warehouseTo} IS NULL OR :#{#d.warehouseTo} = d.warehouseTo.id)
        AND (:#{#d.transporter} IS NULL OR :#{#d.transporter} = d.transporter.id)
    """)
    Page<Delivery> findAllBy(@Param("d") DeliveryFilter deliveryFilter, Delivery.DeliveryStatus deliveryStatus,
                             Pageable pageable);
}