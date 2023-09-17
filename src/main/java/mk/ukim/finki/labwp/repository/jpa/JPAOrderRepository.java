package mk.ukim.finki.labwp.repository.jpa;

import mk.ukim.finki.labwp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface JPAOrderRepository extends JpaRepository<Order,Long> {
    public List<LocalDateTime> findAllByDateCreatedBetween (LocalDateTime from, LocalDateTime to);
}
