package com.springboot.transaction.services;

import com.springboot.transaction.dao.UserMapper;
import com.springboot.transaction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
