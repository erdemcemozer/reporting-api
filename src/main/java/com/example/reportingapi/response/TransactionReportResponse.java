package com.example.reportingapi.response;

import lombok.Data;

import java.util.List;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */

@Data
public class TransactionReportResponse {

    private String status;
    private List<Response> response;

    public static class Response {
        private Integer count;
        private Integer total;
        private String currency;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }
    }
}
