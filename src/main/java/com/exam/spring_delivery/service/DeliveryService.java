package com.exam.spring_delivery.service;

import com.exam.spring_delivery.entity.Delivery;
import com.exam.spring_delivery.exception.EntityNotFoundException;
import com.exam.spring_delivery.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    public Delivery get(Long id) {
        return deliveryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    //https://stackoverflow.com/questions/11881479/how-do-i-update-an-entity-using-spring-data-jpa норм так робити?
    public void update(Long id, Delivery delivery) {
        if (deliveryRepository.existsById(id)) {
            getRidOfReferences(delivery);
            delivery.setId(id);
            deliveryRepository.save(delivery);
        }
    }

    public void create(Delivery delivery) {
        getRidOfReferences(delivery);
        deliveryRepository.save(delivery);
    }

    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }

    //@TODO: прибрати після виконання дз
    public void getRidOfReferences(Delivery delivery) {
        delivery.setWarehouseFrom(null);
        delivery.setWarehouseTo(null);
        delivery.setTransporter(null);
    }
}
