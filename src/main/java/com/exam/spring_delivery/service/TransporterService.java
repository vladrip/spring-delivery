package com.exam.spring_delivery.service;

import com.exam.spring_delivery.entity.Transporter;
import com.exam.spring_delivery.exception.EntityNotFoundException;
import com.exam.spring_delivery.repository.TransporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransporterService {
    private final TransporterRepository transporterRepository;

    public List<Transporter> getAll() {
        return transporterRepository.findAll();
    }

    public Transporter get(Long id) {
        return transporterRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    //https://stackoverflow.com/questions/11881479/how-do-i-update-an-entity-using-spring-data-jpa норм так робити?
    public void update(Long id, Transporter transporter) {
        if (transporterRepository.existsById(id)) {
            getRidOfReferences(transporter);
            transporter.setId(id);
            transporterRepository.save(transporter);
        }
    }

    public void create(Transporter transporter) {
        getRidOfReferences(transporter);
        transporterRepository.save(transporter);
    }

    public void delete(Long id) {
        transporterRepository.deleteById(id);
    }

    //@TODO: прибрати після виконання дз
    public void getRidOfReferences(Transporter transporter) {
        transporter.setDeliveries(null);
    }
}
