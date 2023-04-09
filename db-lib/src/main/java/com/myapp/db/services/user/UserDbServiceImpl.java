package com.myapp.db.services.user;

import com.myapp.db.entity.User;
import com.myapp.db.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDbServiceImpl implements UserDbService {

    private final UserRepository userRepository;

    public UserDbServiceImpl(@Autowired(required = false) UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> fetchUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    @Override
    public User fetchByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User fetchByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
