package mk.ukim.finki.labwp.service.impl;

import mk.ukim.finki.labwp.model.User;
import mk.ukim.finki.labwp.model.enums.Role;
import mk.ukim.finki.labwp.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.labwp.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.labwp.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.labwp.model.exceptions.UserNameAlreadyExistsException;
import mk.ukim.finki.labwp.repository.jpa.JPAUserRepository;
import mk.ukim.finki.labwp.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {
    private final JPAUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(JPAUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
           throw new InvalidArgumentException();
        }
         return userRepository.findByUsername(username).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username,  String name, String surname,String password, String repeatPassword, LocalDate dateOfBirth, Role role) {
//        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
//            throw new InvalidArgumentException();
//        }
//        if(!password.equals(repeatPassword)){
//             throw new PasswordsDoNotMatchException();
//        }
//        if(userRepository.findByUsername(username).isPresent()){
//         throw new UserNameAlreadyExistsException(username);
//        }
        User user = new User(username,name,surname,passwordEncoder.encode(password),dateOfBirth,role);
        userRepository.save(user);
        return user;
    }
}
