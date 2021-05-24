package com.springboot.transaction.services;

import com.springboot.transaction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//批量更新用户
@Service
public class UserBatchServiceImpl implements UserBatchService{
    @Autowired
    private UserService userService;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> userList) {
        int count =0;
        for (User user:userList
             ) {count+=userService.insertUser(user);

        }
        return count;
    }
}
