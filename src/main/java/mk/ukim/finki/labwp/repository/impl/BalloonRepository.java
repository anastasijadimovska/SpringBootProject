package mk.ukim.finki.labwp.repository.impl;

import mk.ukim.finki.labwp.data.DataHolder;
import mk.ukim.finki.labwp.model.Balloon;
import mk.ukim.finki.labwp.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons(){
        return DataHolder.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloons.stream().filter(r -> r.getName().equals(text) || r.getDescription().contains(text)).collect(Collectors.toList());
    }

    public Optional<Balloon> save (Long id, String name, String description, Manufacturer manufacturer){
        Balloon balloon = new Balloon(name,description,manufacturer);
        DataHolder.balloons.removeIf(r -> r.getName().equals(name));
        DataHolder.balloons.add(balloon);
        return Optional.of(balloon);

    }

    public Optional<Balloon> findById(Long id){
        return DataHolder.balloons.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
    public void delete(Long id){
        DataHolder.balloons.removeIf(r -> r.getId().equals(id));
    }
}
