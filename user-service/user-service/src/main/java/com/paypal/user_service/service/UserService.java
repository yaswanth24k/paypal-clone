package com.paypal.user_service.service;

import com.paypal.user_service.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
   User createuser(User user);
    Optional<User> getbyUserId(long id);
    List<User> getallusers();

}
