package com.exam.spring_delivery.controller;

import com.exam.spring_delivery.entity.Transporter;
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
    private List<Transporter> getAll() {
        return transporterService.getAll();
    }

    @GetMapping(value = "/{id}")
    private Transporter get(@PathVariable Long id) {
        return transporterService.get(id);
    }

    @PostMapping
    public void create(@RequestBody Transporter transporter) {
        transporterService.create(transporter);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Transporter transporter) {
        transporterService.update(id, transporter);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transporterService.delete(id);
    }
}
