package com.example.reportingapi.service;

import com.example.reportingapi.model.User;
import com.example.reportingapi.response.LoginResponse;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 04/11/2023
 */
public interface LoginService {
    LoginResponse loginUser(User user) throws IOException, InterruptedException;
}
