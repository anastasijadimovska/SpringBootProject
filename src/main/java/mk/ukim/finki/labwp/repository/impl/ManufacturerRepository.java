package mk.ukim.finki.labwp.repository.impl;

import mk.ukim.finki.labwp.data.DataHolder;
import mk.ukim.finki.labwp.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {
    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers;
    }
    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturers.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
