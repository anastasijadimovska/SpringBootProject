package mk.ukim.finki.labwp.repository.jpa;

import mk.ukim.finki.labwp.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPABalloonRepository extends JpaRepository<Balloon,Long> {
    List<Balloon> findByName(String text);


}
