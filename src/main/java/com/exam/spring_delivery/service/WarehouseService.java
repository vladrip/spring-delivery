package com.exam.spring_delivery.service;

import com.exam.spring_delivery.dto.WarehouseDto;
import com.exam.spring_delivery.entity.Warehouse;
import com.exam.spring_delivery.exception.EntityNotFoundException;
import com.exam.spring_delivery.filter.WarehouseFilter;
import com.exam.spring_delivery.mapper.Mapper;
import com.exam.spring_delivery.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final Mapper mapper;

    public Page<WarehouseDto> getAll(WarehouseFilter warehouseFilter, Pageable pageable) {
        return warehouseRepository.findAllBy(warehouseFilter, pageable)
                .map(mapper::toWarehouseDto);
    }

    public WarehouseDto get(Long id) {
        return mapper.toWarehouseDto(retrieve(id));
    }

    public void update(Long id, WarehouseDto warehouseDto) {
        Warehouse warehouse = retrieve(id);
        mapper.mergeWarehouse(warehouseDto, warehouse);
        warehouseRepository.save(warehouse);
    }

    public void create(WarehouseDto warehouseDto) {
        Warehouse warehouse = mapper.toWarehouse(warehouseDto);
        warehouse.setId(null);
        warehouseRepository.save(warehouse);
    }

    public void delete(Long id) {
        warehouseRepository.deleteById(id);
    }

    public Warehouse retrieve(Long id) {
        return warehouseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Warehouse" + id));
    }
}
