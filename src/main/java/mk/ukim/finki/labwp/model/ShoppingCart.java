package mk.ukim.finki.labwp.model;

import lombok.Data;
import mk.ukim.finki.labwp.model.enums.ShoppingCartStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @DateTimeFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "shoppingCart")
    private List<Order> orders;

    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;


    public ShoppingCart(User user) {
        this.user = user;
        this.dateCreated = LocalDateTime.now();
        this.orders = new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;

    }
    public ShoppingCart(){

    }
}
