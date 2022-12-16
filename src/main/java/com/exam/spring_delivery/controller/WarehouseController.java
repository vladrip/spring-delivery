package com.exam.spring_delivery.controller;

import com.exam.spring_delivery.entity.Warehouse;
import com.exam.spring_delivery.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping
    private List<Warehouse> getAll() {
        return warehouseService.getAll();
    }

    @GetMapping(value = "/{id}")
    private Warehouse get(@PathVariable Long id) {
        return warehouseService.get(id);
    }

    @PostMapping
    public void create(@RequestBody Warehouse warehouse) {
        warehouseService.create(warehouse);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Warehouse warehouse) {
        warehouseService.update(id, warehouse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        warehouseService.delete(id);
    }
}
