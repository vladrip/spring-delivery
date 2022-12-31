package com.exam.spring_delivery.repository;

import com.exam.spring_delivery.entity.Warehouse;
import com.exam.spring_delivery.filter.WarehouseFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    @Query("""
        SELECT w FROM Warehouse w
        WHERE (:#{#w.id} IS NULL OR :#{#w.id} = w.id)
        AND (:#{#w.title} IS NULL OR lower(w.title) LIKE concat('%', lower(:#{#w.title}),'%'))
        AND (:#{#w.city} IS NULL OR lower(w.address.city) LIKE concat('%', lower(:#{#w.city}),'%'))
        AND (:#{#w.street} IS NULL OR lower(w.address.street) LIKE concat('%', lower(:#{#w.street}),'%'))
        AND (:#{#w.latitude} IS NULL OR :#{#w.latitude} = w.address.latitude)
        AND (:#{#w.longitude} IS NULL OR :#{#w.longitude} = w.address.longitude)
    """)
    Page<Warehouse> findAllBy(@Param("w") WarehouseFilter warehouseFilter, Pageable pageable);
}