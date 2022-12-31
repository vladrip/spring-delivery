package com.exam.spring_delivery.service;

import com.exam.spring_delivery.dto.DeliveryDto;
import com.exam.spring_delivery.entity.Delivery;
import com.exam.spring_delivery.exception.EntityNotFoundException;
import com.exam.spring_delivery.filter.DeliveryFilter;
import com.exam.spring_delivery.mapper.Mapper;
import com.exam.spring_delivery.repository.DeliveryRepository;
import com.exam.spring_delivery.repository.TransporterRepository;
import com.exam.spring_delivery.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final TransporterRepository transporterRepository;
    private final WarehouseRepository warehouseRepository;
    private final Mapper mapper;

    public Page<DeliveryDto> getAll(DeliveryFilter deliveryFilter, Pageable pageable) {
        return deliveryRepository.findAllBy(deliveryFilter, deliveryFilter.getDeliveryStatus(), pageable)
                .map(mapper::toDeliveryDto);
    }

    public DeliveryDto get(Long id) {
        return mapper.toDeliveryDto(retrieve(id));
    }

    public void update(Long id, DeliveryDto deliveryDto) {
        Delivery delivery = retrieve(id);
        mapper.mergeDelivery(deliveryDto, delivery);
        fetchReferences(deliveryDto, delivery);
        deliveryRepository.save(delivery);
    }

    public void create(DeliveryDto deliveryDto) {
        Delivery delivery = mapper.toDelivery(deliveryDto);
        fetchReferences(deliveryDto, delivery);
        delivery.setId(null);
        deliveryRepository.save(delivery);
    }

    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }

    public Delivery retrieve(Long id) {
        return deliveryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Delivery" + id));
    }

    public void fetchReferences(DeliveryDto deliveryDto, Delivery delivery) {
        Long warehouseFromId = deliveryDto.getWarehouseFromId();
        Long warehouseToId = deliveryDto.getWarehouseToId();
        Long transporterId = deliveryDto.getTransporterId();
        delivery.setWarehouseFrom(warehouseRepository.findById(warehouseFromId)
                .orElseThrow(() -> new EntityNotFoundException("Warehouse" + warehouseFromId)));
        delivery.setWarehouseTo(warehouseRepository.findById(warehouseToId)
                .orElseThrow(() -> new EntityNotFoundException("Warehouse" + warehouseToId)));
        delivery.setTransporter(transporterRepository.findById(transporterId)
                .orElseThrow(() -> new EntityNotFoundException("Transporter" + transporterId)));
    }
}