package com.alialsubhi.Codeline.Evaluation.WebApp;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    public boolean authenticate(String username,String password) {
        boolean isValidUserName = username.equalsIgnoreCase("Ali");
        boolean isValidPassword = password.equalsIgnoreCase("a");


        return isValidUserName && isValidPassword;
    }
}
