package com.exam.spring_delivery.controller;

import com.exam.spring_delivery.dto.TransporterDto;
import com.exam.spring_delivery.filter.TransporterFilter;
import com.exam.spring_delivery.service.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transporter")
public class TransporterController {
    private final TransporterService transporterService;

    @GetMapping
    private Page<TransporterDto> getAll(TransporterFilter transporterFilter,
                                        @PageableDefault(sort = "id") @ParameterObject Pageable pageable) {
        return transporterService.getAll(transporterFilter, pageable);
    }

    @GetMapping(value = "/{id}")
    private TransporterDto get(@PathVariable Long id) {
        return transporterService.get(id);
    }

    @PostMapping
    public void create(@RequestBody TransporterDto transporterDto) {
        transporterService.create(transporterDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody TransporterDto transporterDto) {
        transporterService.update(id, transporterDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transporterService.delete(id);
    }
}
