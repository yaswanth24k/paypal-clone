package com.paypal.user_service.service;

import com.paypal.user_service.entity.User;
import com.paypal.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createuser(User user) {
        return (User) userRepository.save(user);
    }

    @Override
    public Optional<User> getbyUserId(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getallusers() {
        return userRepository.findAll();
    }
}
