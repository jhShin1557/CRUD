package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUser(Integer userNumber) {
        return userMapper.getUser(userNumber);
    }

    public List<User> userList() {
        return userMapper.getUserList();
    }

    public List<User> userSearchList(String searchId) {
        return userMapper.getUserSearchList(searchId);
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public void modifyUser(User user) {
        userMapper.modifyUser(user);
    }

    public void deleteUser(Long userNumber) {
        userMapper.deleteUser(userNumber);
    }
}
