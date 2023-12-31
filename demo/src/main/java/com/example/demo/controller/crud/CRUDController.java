package com.example.demo.controller.crud;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "crud/list";
    }

    @GetMapping("/searchList")
    public String userConditionList(Model model, String searchId) {
        List<User> users = userService.userSearchList(searchId);
        model.addAttribute("users", users);
        return "crud/list";
    }

    @GetMapping("/addUser")
    public String addUserForm() {
        return "crud/addUser";
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
    @GetMapping("/userInfo/{userNumber}")
    public String userInfo(@PathVariable Integer userNumber, Model model) {
        User user = userService.getUser(userNumber);
        model.addAttribute("user", user);
        return "crud/userInfo";
    }

    @GetMapping("/userModify/{userNumber}")
    public String userModifyForm(@PathVariable Integer userNumber, Model model) {
        User user = userService.getUser(userNumber);
        model.addAttribute("user", user);
        return "crud/modifyUser";
    }

    @PostMapping("/userModify")
    public String userModify(User user) {
        userService.modifyUser(user);
        return "redirect:/list";
    }


}
