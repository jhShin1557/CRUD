package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private Long userNumber;
    private String id;
    private String password;
    private String name;
    private String phoneNumber;

    public User(){}

    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
