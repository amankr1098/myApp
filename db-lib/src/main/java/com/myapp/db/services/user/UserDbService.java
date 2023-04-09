package com.myapp.db.services.user;

import com.myapp.db.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDbService {
    void save(User user);

    Optional<User> fetchUserById(int id);

    List<User> fetchAll();


    User fetchByUsername(String username);

    User fetchByEmail(String email);
}
