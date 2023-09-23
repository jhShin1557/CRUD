package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CRUDController {

    private final UserService userService;

    @Autowired
    public CRUDController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String main() {
        return "home";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        List<User> users = userService.userList();
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/searchList")
    public String userConditionList(Model model, String searchId) {
        List<User> users = userService.userSearchList(searchId);
        model.addAttribute("users", users);
        return "list";
    }

    @GetMapping("/addUser")
    public String addUserForm() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/list";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(Long userNumber) {
        userService.deleteUser(userNumber);
        return "redirect:/list";
    }


}
