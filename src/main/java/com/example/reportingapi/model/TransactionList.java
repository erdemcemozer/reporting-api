package com.example.reportingapi.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
@Data
public class TransactionList {

    Date fromDate;
    Date toDate;
    String status;
    String operation;
    Integer merchantId;
    Integer acquirerId;
    String paymentMethod;
    String errorCode;
    String filterField;
    String filterValue;
    Integer page;
}
