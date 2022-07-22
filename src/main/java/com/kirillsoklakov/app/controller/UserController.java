package com.kirillsoklakov.app.controller;

import com.kirillsoklakov.app.model.User;
import com.kirillsoklakov.app.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Post запрос на регистрацию пользователя
    @PostMapping("/users")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    //Post запрос на авторизацию пользователя
    @PostMapping("/login")
    public void signIn(@RequestBody User user) {
        ResponseEntity.ok(userService.getCurrentUser());
    }

    @GetMapping("/users/me")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
