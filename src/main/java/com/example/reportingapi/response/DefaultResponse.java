package com.example.reportingapi.response;

import lombok.Data;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */

@Data
public class DefaultResponse {

    private Integer code;
    private String status;
    private String message;
}
