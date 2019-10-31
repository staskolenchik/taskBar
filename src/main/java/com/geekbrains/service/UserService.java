package com.geekbrains.service;

import com.geekbrains.domain.Project;
import com.geekbrains.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends Service<User, Long>, UserDetailsService {

    User getByUsername(String name);

    User getByEmail(String email);

}
