package com.example.demo.domain;

import lombok.Data;

@Data
public class User {
    private Long userNumber;
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
}
