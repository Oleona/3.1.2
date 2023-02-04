package ru.javamentor.springboot.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.springboot.entity.User;
import ru.javamentor.springboot.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;

    public UserController() {

    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String listUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("listUsers", users);
        return "index";
    }

    @GetMapping("/new")
    public String newEmptyUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }


}
