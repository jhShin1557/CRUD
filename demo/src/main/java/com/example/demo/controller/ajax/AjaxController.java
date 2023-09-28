package com.example.demo.controller.ajax;

import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@Controller
public class AjaxController {
    @GetMapping("/ajax")
    public String ajax(Model model) {
        User user = new User("jongha", "1234", "신종하");
        model.addAttribute(user);
        return "ajax/ajax";
    }

    @PostMapping("/sendJson")
    @ResponseBody
    public User receiveJson(@RequestBody User user) {
        return user;
    }
}
