package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
    @GetMapping("/ajax")
    public String ajax() {
        return "ajax";
    }

    @PostMapping("/sendData")
    @ResponseBody
    public String receiveData(@RequestBody String data) {
        String response = data;
        return response;
    }
}
