package com.springboot.transaction.dao;

import com.springboot.transaction.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUser(Long id);

    int insertUser(User user);
}
