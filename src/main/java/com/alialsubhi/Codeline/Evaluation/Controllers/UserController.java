package com.alialsubhi.Codeline.Evaluation.Controllers;

import com.alialsubhi.Codeline.Evaluation.Models.User;
import com.alialsubhi.Codeline.Evaluation.Requests.UserRegistrationRequest;
import com.alialsubhi.Codeline.Evaluation.Requests.UserUpdateRequest;
import com.alialsubhi.Codeline.Evaluation.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        userService.registerUser(registrationRequest);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserByID(@PathVariable("id") Long id){
        return userService.getUserByID(id);
    }
    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.GetUserByUsername(username);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id , @RequestBody UserUpdateRequest updateRequest){
        userService.updateUser(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
