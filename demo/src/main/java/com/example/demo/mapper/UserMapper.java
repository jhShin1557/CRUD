package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUser(Integer userNumber);

    List<User> getUserList();

    List<User> getUserSearchList(String searchId);

    void addUser(User user);

    void modifyUser(User user);

    void deleteUser(Long userNumber);
}
