package com.exam.spring_delivery.repository;

import com.exam.spring_delivery.entity.Transporter;
import com.exam.spring_delivery.filter.TransporterFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporterRepository extends JpaRepository<Transporter, Long> {
    @Query("""
        SELECT t FROM Transporter t
        WHERE (:#{#t.id} IS NULL OR :#{#t.id} = t.id)
        AND (:#{#t.fullname} IS NULL OR lower(t.fullname) LIKE concat('%', lower(:#{#t.fullname}),'%'))
        AND (:#{#t.carModel} IS NULL OR lower(t.carModel) LIKE concat('%', lower(:#{#t.carModel}),'%'))
        AND (:#{#t.loadCapacity} IS NULL OR :#{#t.loadCapacity} = t.loadCapacity)
    """)
    Page<Transporter> findAllBy(@Param("t") TransporterFilter transporterFilter, Pageable pageable);
}