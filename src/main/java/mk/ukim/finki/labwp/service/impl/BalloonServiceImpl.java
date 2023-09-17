package mk.ukim.finki.labwp.service.impl;


import mk.ukim.finki.labwp.model.Balloon;
import mk.ukim.finki.labwp.model.Manufacturer;
import mk.ukim.finki.labwp.repository.jpa.JPABalloonRepository;
import mk.ukim.finki.labwp.repository.jpa.JPAManufacturerRepository;
import mk.ukim.finki.labwp.service.BalloonService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final JPABalloonRepository balloonRepository;
    private final JPAManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(JPABalloonRepository balloonRepository, JPAManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll();
    }

    @Override
    public List<Balloon> findByNameOrDescription(String text) {
        return balloonRepository.findByName(text);
    }

    @Override
    public Optional<Balloon> save(Long id, String name, String description, Long manufacturerId) {
        Manufacturer manufacturer  = manufacturerRepository.findById(manufacturerId).get();
        Balloon balloon = new Balloon(id,name, description, manufacturer);
        return Optional.of(balloonRepository.save(balloon));
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        balloonRepository.deleteById(id);
    }




}
