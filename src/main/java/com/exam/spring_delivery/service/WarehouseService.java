package com.exam.spring_delivery.service;

import com.exam.spring_delivery.entity.Delivery;
import com.exam.spring_delivery.entity.Warehouse;
import com.exam.spring_delivery.exception.EntityNotFoundException;
import com.exam.spring_delivery.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public List<Warehouse> getAll() {
        return warehouseRepository.findAll();
    }

    public Warehouse get(Long id) {
        return warehouseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    //https://stackoverflow.com/questions/11881479/how-do-i-update-an-entity-using-spring-data-jpa норм так робити?
    public void update(Long id, Warehouse warehouse) {
        if (warehouseRepository.existsById(id)) {
            getRidOfReferences(warehouse);
            warehouse.setId(id);
            warehouseRepository.save(warehouse);
        }
    }

    public void create(Warehouse warehouse) {
        getRidOfReferences(warehouse);
        warehouseRepository.save(warehouse);
    }

    public void delete(Long id) {
        warehouseRepository.deleteById(id);
    }

    //@TODO: прибрати після виконання дз
    public void getRidOfReferences(Warehouse warehouse) {
        warehouse.setAddress(null);
        warehouse.setDeliveriesFrom(null);
        warehouse.setDeliveriesTo(null);
    }
}
