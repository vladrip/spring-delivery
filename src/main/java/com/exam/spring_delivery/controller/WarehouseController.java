package com.exam.spring_delivery.controller;

import com.exam.spring_delivery.dto.WarehouseDto;
import com.exam.spring_delivery.filter.WarehouseFilter;
import com.exam.spring_delivery.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping
    private Page<WarehouseDto> getAll(WarehouseFilter warehouseFilter,
                                      @PageableDefault(sort = "id") @ParameterObject Pageable pageable) {
        return warehouseService.getAll(warehouseFilter, pageable);
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
