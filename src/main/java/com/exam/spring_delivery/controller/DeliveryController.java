package com.exam.spring_delivery.controller;

import com.exam.spring_delivery.dto.DeliveryDto;
import com.exam.spring_delivery.filter.DeliveryFilter;
import com.exam.spring_delivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping
    private Page<DeliveryDto> getAll(DeliveryFilter deliveryFilter,
                                     @PageableDefault(sort = "id") @ParameterObject Pageable pageable) {
        return deliveryService.getAll(deliveryFilter, pageable);
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