package com.exam.spring_delivery.repository;

import com.exam.spring_delivery.entity.Delivery;
import com.exam.spring_delivery.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
