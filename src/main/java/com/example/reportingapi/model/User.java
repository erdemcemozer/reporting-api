package com.example.reportingapi.model;

import com.example.reportingapi.util.TokenStorage;
import lombok.Data;

/**
 * @Author Erdem Ozer
 * Date: 04/11/2023
 */

@Data
public class User {
    String email;
    String password;
    TokenStorage token;
}
