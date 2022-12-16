package com.exam.spring_delivery.controller;

import com.exam.spring_delivery.entity.Delivery;
import com.exam.spring_delivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping
    private List<Delivery> getAll() {
        return deliveryService.getAll();
    }

    @GetMapping(value = "/{id}")
    private Delivery get(@PathVariable Long id) {
        return deliveryService.get(id);
    }

    @PostMapping
    public void create(@RequestBody Delivery delivery) {
        deliveryService.create(delivery);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Delivery delivery) {
        deliveryService.update(id, delivery);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deliveryService.delete(id);
    }
}
