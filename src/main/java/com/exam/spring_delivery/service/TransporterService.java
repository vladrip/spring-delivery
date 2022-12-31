package com.exam.spring_delivery.service;

import com.exam.spring_delivery.dto.TransporterDto;
import com.exam.spring_delivery.entity.Transporter;
import com.exam.spring_delivery.exception.EntityNotFoundException;
import com.exam.spring_delivery.filter.TransporterFilter;
import com.exam.spring_delivery.mapper.Mapper;
import com.exam.spring_delivery.repository.TransporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransporterService {
    private final TransporterRepository transporterRepository;
    private final Mapper mapper;

    public Page<TransporterDto> getAll(TransporterFilter transporterFilter, Pageable pageable) {
        return transporterRepository.findAllBy(transporterFilter, pageable).map(mapper::toTransporterDto);
    }

    public TransporterDto get(Long id) {
        return mapper.toTransporterDto(retrieve(id));
    }

    public void update(Long id, TransporterDto transporterDto) {
        Transporter transporter = retrieve(id);
        mapper.mergeTransporter(transporterDto, transporter);
        transporterRepository.save(transporter);
    }

    public void create(TransporterDto transporterDto) {
        Transporter transporter = mapper.toTransporter(transporterDto);
        transporter.setId(null);
        transporterRepository.save(transporter);
    }

    public void delete(Long id) {
        transporterRepository.deleteById(id);
    }

    public Transporter retrieve(Long id) {
        return transporterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transporter" + id));
    }
}
