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
    public String registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        userService.registerUser(registrationRequest);
        return "The user Created Successfully";
    }

    //http://localhost:8080/api/users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //http://localhost:8080/api/users/5
    @GetMapping("/{id}")
    public User getUserByID(@PathVariable("id") Long id){
        return userService.getUserByID(id);
    }

    //http://localhost:8080/api/users/username/Ali
    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.GetUserByUsername(username);
    }

    /*http://localhost:8080/api/users/1

    {
        "username": "Ali",
        "password": "PassUpdated"
    }

     */
    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id , @RequestBody UserUpdateRequest updateRequest){
        userService.updateUser(id, updateRequest);
        return "The user updated Successfully";

    }


    //http://localhost:8080/api/users/2
    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "The user deleted Successfully";
    }
}
