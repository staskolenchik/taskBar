package com.geekbrains.controller;

import com.geekbrains.domain.Role;
import com.geekbrains.domain.User;
import com.geekbrains.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class RegistrationController {

    private static final String REGISTRATION_MAPPING = "/registration";
    private static final String VIEW = "registration";
    private static final String REDIRECTION = "/login" ;
    private static final String LOGIN_EXISTS_NOTIFICATION = "Логин уже существует!";

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping(REGISTRATION_MAPPING)
    public String registration() {
        return VIEW;
    }

    @PostMapping(REGISTRATION_MAPPING)
    public String save(@RequestParam String username, String password, Model model) {
        User user = new User();
        String result = null;
        password = passwordEncoder.encode(password);

        User userFromDB = userService.getByUsername(username);
        if (userFromDB != null) {
            model.addAttribute("isLoginExists", Boolean.TRUE);
            model.addAttribute("loginExistsNotification", LOGIN_EXISTS_NOTIFICATION);
            result = REGISTRATION_MAPPING;
        } else {
            user.setUsername(username);
            user.setPassword(password);
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));

            userService.save(user);
            result = REDIRECTION;
        }

        return result;

    }

}
