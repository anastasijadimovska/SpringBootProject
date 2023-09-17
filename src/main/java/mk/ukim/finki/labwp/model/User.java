package mk.ukim.finki.labwp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import mk.ukim.finki.labwp.model.enums.Role;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "shop_users")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

//    private String name;
//
//    private String surname;

    private String password;

    @Convert(converter = UserFullnameConverter.class)
    private UserFullname userfullname;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> carts;

    public User(String username, String name, String surname,String password,  LocalDate dateOfBirth, Role role) {
        this.username = username;
        this.userfullname = new UserFullname(name,surname);
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }
    public User(){

    }
}
