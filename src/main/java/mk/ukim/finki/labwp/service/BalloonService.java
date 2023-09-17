package mk.ukim.finki.labwp.service;

import mk.ukim.finki.labwp.model.Balloon;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BalloonService {
    public List<Balloon> listAll();
    public List<Balloon> findByNameOrDescription(String text);
    public Optional<Balloon> save (Long id, String name, String description, Long manufacturerId);
    public Optional<Balloon> findById(Long id);
    public void delete(Long id);
}
