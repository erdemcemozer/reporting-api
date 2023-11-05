package com.example.reportingapi.controller;

import com.example.reportingapi.model.User;
import com.example.reportingapi.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 04/11/2023
 */
@RestController
public class LoginController {
    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) throws IOException, InterruptedException {
        logger.info("loginUser::class::" + this.getClass().getSimpleName());
        String token = loginService.loginUser(user);
        if (token != null) {
            return ResponseEntity.ok().body("Logged in successfully: "+ token);
        } else {
            return ResponseEntity.status(401).body("Login failed");
        }
    }
}
