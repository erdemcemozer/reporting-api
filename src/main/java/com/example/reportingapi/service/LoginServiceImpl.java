package com.example.reportingapi.service;

import com.example.reportingapi.externalAPI.LoginAPI;
import com.example.reportingapi.model.User;
import com.example.reportingapi.response.LoginResponse;
import com.example.reportingapi.util.TokenStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 04/11/2023
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginAPI loginAPI;

    @Override
    public LoginResponse loginUser(User user) throws IOException, InterruptedException {
        TokenStorage token = TokenStorage.getInstance();
        LoginResponse response = loginAPI.loginToExternalAPI(user);
        token.setToken(response.getToken());
        return response;
    }
}
