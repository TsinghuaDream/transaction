package com.springboot.transaction.services;

import com.springboot.transaction.entity.User;

public interface UserService {
    public User getUser(Long id);

    public int insertUser(User user);
}
