package com.springboot.transaction.controller;

import com.springboot.transaction.entity.User;
import com.springboot.transaction.services.UserBatchService;
import com.springboot.transaction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserBatchService userBatchService;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id){
        return userService.getUser(id);
    }
    @RequestMapping("/insertUser")
    @ResponseBody
    public Map<String,Object> insertUser(String userNmae, String note){
        User user = new User();
        user.setUserName(userNmae);
        user.setNote(note);

        int update = userService.insertUser(user);
        Map<String,Object> result = new HashMap<>();
        result.put("success",update == 1);
        result.put("user",user);
        return result;
    }
    @RequestMapping("/insertUsers")
    @ResponseBody
    public Map<String, Object> insertUsers(String userName1, String note1, String userName2, String note2){
        User user1 = new User();
        user1.setUserName(userName1);
        user1.setNote(note1);
        User user2 = new User();
        user1.setUserName(userName2);
        user1.setNote(note2);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        int inserts = userBatchService.insertUsers(userList);
        Map<String,Object> result = new HashMap<>();
        result.put("success",inserts>0);
        result.put("user",userList);
        System.out.println(result);
        return result;
    }

}
