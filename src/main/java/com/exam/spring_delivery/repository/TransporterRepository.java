package com.exam.spring_delivery.repository;

import com.exam.spring_delivery.entity.Delivery;
import com.exam.spring_delivery.entity.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporterRepository extends JpaRepository<Transporter, Long> {

}
