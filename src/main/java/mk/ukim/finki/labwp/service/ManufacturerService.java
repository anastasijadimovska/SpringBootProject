package mk.ukim.finki.labwp.service;

import mk.ukim.finki.labwp.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    public List<Manufacturer> findAll();
    public Optional<Manufacturer> findById(Long id);
}
