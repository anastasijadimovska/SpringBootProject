package mk.ukim.finki.labwp.service;

import mk.ukim.finki.labwp.model.User;
import mk.ukim.finki.labwp.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;

public interface UserService  {
    User login(String username, String password);
    User register(String username, String password, String repeatPassword,String name,String surname, LocalDate dateOfBirth, Role role);
}
