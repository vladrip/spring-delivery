package com.exam.spring_delivery.controller;

import com.exam.spring_delivery.dto.TransporterDto;
import com.exam.spring_delivery.service.TransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transporter")
public class TransporterController {
    private final TransporterService transporterService;

    @GetMapping
    private List<TransporterDto> getAll() {
        return transporterService.getAll();
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
