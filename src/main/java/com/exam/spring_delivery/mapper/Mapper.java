package com.exam.spring_delivery.mapper;

import com.exam.spring_delivery.dto.DeliveryDto;
import com.exam.spring_delivery.dto.TransporterDto;
import com.exam.spring_delivery.dto.WarehouseDto;
import com.exam.spring_delivery.entity.Delivery;
import com.exam.spring_delivery.entity.Transporter;
import com.exam.spring_delivery.entity.Warehouse;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    @Named("deliveriesToIds")
    static List<Long> deliveriesToIds(List<Delivery> entities) {
        return entities.stream().map(Delivery::getId).toList();
    }

    @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "deliveriesFromIds", source = "deliveriesFrom", qualifiedByName = "deliveriesToIds")
    @Mapping(target = "deliveriesToIds", source = "deliveriesTo", qualifiedByName = "deliveriesToIds")
    WarehouseDto toWarehouseDto(Warehouse entity);
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "deliveriesFrom", ignore = true)
    @Mapping(target = "deliveriesTo", ignore = true)
    Warehouse toWarehouse(WarehouseDto dto);
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "deliveriesFrom", ignore = true)
    @Mapping(target = "deliveriesTo", ignore = true)
    @Mapping(target = "id", ignore = true)
    void mergeWarehouse(WarehouseDto warehouseDto, @MappingTarget Warehouse warehouse);

    @Mapping(target = "deliveriesIds", source = "deliveries", qualifiedByName = "deliveriesToIds")
    TransporterDto toTransporterDto(Transporter entity);
    @Mapping(target = "deliveries", ignore = true)
    Transporter toTransporter(TransporterDto dto);
    @Mapping(target = "deliveries", ignore = true)
    @Mapping(target = "id", ignore = true)
    void mergeTransporter(TransporterDto transporterDto, @MappingTarget Transporter transporter);

    @Mapping(target = "warehouseFromId", source = "warehouseFrom.id")
    @Mapping(target = "warehouseToId", source = "warehouseTo.id")
    @Mapping(target = "transporterId", source = "transporter.id")
    DeliveryDto toDeliveryDto(Delivery entity);
    @Mapping(target = "warehouseFrom", ignore = true)
    @Mapping(target = "warehouseTo", ignore = true)
    @Mapping(target = "transporter", ignore = true)
    Delivery toDelivery(DeliveryDto dto);
    @Mapping(target = "transporter", ignore = true)
    @Mapping(target = "warehouseFrom", ignore = true)
    @Mapping(target = "warehouseTo", ignore = true)
    @Mapping(target = "id", ignore = true)
    void mergeDelivery(DeliveryDto deliveryDto, @MappingTarget Delivery delivery);
}