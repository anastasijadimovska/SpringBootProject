package mk.ukim.finki.labwp.service.impl;

import mk.ukim.finki.labwp.model.Manufacturer;
import mk.ukim.finki.labwp.repository.jpa.JPAManufacturerRepository;
import mk.ukim.finki.labwp.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final JPAManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(JPAManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }
}
