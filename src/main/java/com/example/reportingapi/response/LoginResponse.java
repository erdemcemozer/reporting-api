package com.example.reportingapi.response;

import lombok.Data;

/**
 * @Author Erdem Ozer
 * Date: 05/11/2023
 */

@Data
public class LoginResponse {

    private String token;
    private String status;
}
