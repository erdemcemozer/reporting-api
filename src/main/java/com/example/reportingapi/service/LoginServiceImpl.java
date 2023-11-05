package com.example.reportingapi.service;

import com.example.reportingapi.externalAPI.LoginAPI;
import com.example.reportingapi.model.User;
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
    public String loginUser(User user) throws IOException, InterruptedException {
        return loginAPI.loginToExternalAPI(user);
    }
}
