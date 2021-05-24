package com.springboot.transaction.services;

import com.springboot.transaction.entity.User;

import java.util.List;
//批量更新用户
public interface UserBatchService {
    public int insertUsers(List<User> userList);
}
