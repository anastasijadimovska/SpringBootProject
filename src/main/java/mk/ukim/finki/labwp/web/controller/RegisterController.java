package mk.ukim.finki.labwp.web.controller;

import mk.ukim.finki.labwp.model.User;
import mk.ukim.finki.labwp.model.enums.Role;
import mk.ukim.finki.labwp.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.labwp.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.labwp.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.labwp.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(Model model){
        model.addAttribute("bodyContent","register");
        return "master-template";
    }
    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                           @RequestParam Role role){
        try{
            this.userService.register(username,name, surname, password, repeatPassword, dateOfBirth, role);
            return "redirect:/login";
        }catch (PasswordsDoNotMatchException | InvalidArgumentException e){
            return "redirect:/register?error=" + e.getMessage();
        }

    }
}

