package com.exam.spring_delivery.service;

import com.exam.spring_delivery.dto.WarehouseDto;
import com.exam.spring_delivery.entity.Warehouse;
import com.exam.spring_delivery.exception.EntityNotFoundException;
import com.exam.spring_delivery.mapper.Mapper;
import com.exam.spring_delivery.repository.AddressRepository;
import com.exam.spring_delivery.repository.DeliveryRepository;
import com.exam.spring_delivery.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final AddressRepository addressRepository;
    private final DeliveryRepository deliveryRepository;
    private final Mapper mapper;

    public List<WarehouseDto> getAll() {
        return warehouseRepository.findAll().stream().map(mapper::toWarehouseDto).toList();
    }

    public WarehouseDto get(Long id) {
        return mapper.toWarehouseDto(retrieve(id));
    }

    public void update(Long id, WarehouseDto warehouseDto) {
        Warehouse warehouse = retrieve(id);
        mapper.mergeWarehouse(warehouseDto, warehouse);
        fetchReferences(warehouseDto, warehouse);
        warehouseRepository.save(warehouse);
    }

    public void create(WarehouseDto warehouseDto) {
        Warehouse warehouse = mapper.toWarehouse(warehouseDto);
        fetchReferences(warehouseDto, warehouse);
        warehouseRepository.save(warehouse);
    }

    public void delete(Long id) {
        warehouseRepository.deleteById(id);
    }

    public Warehouse retrieve(Long id) {
        return warehouseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Warehouse" + id));
    }

    public void fetchReferences(WarehouseDto warehouseDto, Warehouse warehouse) {
        Long addressId = warehouseDto.getAddressId();
        warehouse.setAddress(addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address" + addressId)));
    }
}
