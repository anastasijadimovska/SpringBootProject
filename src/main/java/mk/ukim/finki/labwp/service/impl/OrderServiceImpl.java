package mk.ukim.finki.labwp.service.impl;

import mk.ukim.finki.labwp.model.Order;
import mk.ukim.finki.labwp.repository.jpa.JPAOrderRepository;
import mk.ukim.finki.labwp.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final JPAOrderRepository orderRepository;

    public OrderServiceImpl(JPAOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> placeOrder(String balloonColor, String balloonSize, LocalDateTime dateCreated) {

        Order order = new Order(balloonColor,balloonSize,dateCreated);

        return Optional.of(orderRepository.save(order));
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<LocalDateTime> findAllByDateCreatedBetween(LocalDateTime from, LocalDateTime to) {
        return orderRepository.findAllByDateCreatedBetween(from,to);
    }
}
