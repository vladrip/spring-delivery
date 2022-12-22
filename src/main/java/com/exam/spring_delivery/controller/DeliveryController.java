package com.exam.spring_delivery.controller;

import com.exam.spring_delivery.dto.DeliveryDto;
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
    private List<DeliveryDto> getAll() {
        return deliveryService.getAll();
    }

    @GetMapping(value = "/{id}")
    private DeliveryDto get(@PathVariable Long id) {
        return deliveryService.get(id);
    }

    @PostMapping
    public void create(@RequestBody DeliveryDto deliveryDto) {
        deliveryService.create(deliveryDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody DeliveryDto deliveryDto) {
        deliveryService.update(id, deliveryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deliveryService.delete(id);
    }
}
