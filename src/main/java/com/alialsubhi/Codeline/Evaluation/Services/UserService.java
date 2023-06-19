package com.alialsubhi.Codeline.Evaluation.Services;

import com.alialsubhi.Codeline.Evaluation.Models.User;
import com.alialsubhi.Codeline.Evaluation.Repo.UserRepo;
import com.alialsubhi.Codeline.Evaluation.Requests.UserRegistrationRequest;
import com.alialsubhi.Codeline.Evaluation.Requests.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepository;

    public void registerUser(UserRegistrationRequest registrationRequest){
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setUsername(registrationRequest.getPassword());

        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByID(Long id){
        return userRepository.findById(id).get();
    }

    public User GetUserByUsername(String username){
        return userRepository.findByUsername(username).get();
    }

    public void updateUser(Long id , UserUpdateRequest updateRequest) {
        User user = getUserByID(id);
        user.setUsername(updateRequest.getUsername());
        user.setPassword(updateRequest.getPassword());

        userRepository.save(user);
    }



}
