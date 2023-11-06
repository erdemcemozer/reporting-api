package com.example.reportingapi.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */

@Data
public class TransactionsReportResponse extends DefaultResponse {

    private List<Response> response;

    @Getter
    @Setter
    public static class Response {
        private Integer count;
        private Long total;
        private String currency;
    }
}
