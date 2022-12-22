package com.exam.spring_delivery.controller;

import com.exam.spring_delivery.dto.WarehouseDto;
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
    private List<WarehouseDto> getAll() {
        return warehouseService.getAll();
    }

    @GetMapping(value = "/{id}")
    private WarehouseDto get(@PathVariable Long id) {
        return warehouseService.get(id);
    }

    @PostMapping
    public void create(@RequestBody WarehouseDto warehouseDto) {
        warehouseService.create(warehouseDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody WarehouseDto warehouseDto) {
        warehouseService.update(id, warehouseDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        warehouseService.delete(id);
    }
}
