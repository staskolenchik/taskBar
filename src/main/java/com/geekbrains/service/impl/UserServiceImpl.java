package com.geekbrains.service.impl;

import com.geekbrains.domain.Project;
import com.geekbrains.domain.User;
import com.geekbrains.repo.UserRepository;
import com.geekbrains.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    PagingAndSortingRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    public User getByUsername(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public User getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = getByUsername(s);
        if (user == null) {
            user = getByEmail(s);
        }
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        return user;
    }
}
