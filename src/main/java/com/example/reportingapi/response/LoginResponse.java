package com.example.reportingapi.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Erdem Ozer
 * Date: 05/11/2023
 */

@Getter
@Setter
public class LoginResponse {

    private String token;
    private String status;
}
