package mk.ukim.finki.labwp.service;

import mk.ukim.finki.labwp.model.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Optional<Order> placeOrder (String balloonColor, String balloonSize, LocalDateTime dateCreated);
    public List<Order> listAll();
    public List<LocalDateTime> findAllByDateCreatedBetween (LocalDateTime from, LocalDateTime to);

}
