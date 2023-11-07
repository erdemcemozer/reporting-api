package com.example.reportingapi.util;

import com.example.reportingapi.model.Transaction;
import com.example.reportingapi.model.TransactionList;
import com.example.reportingapi.model.TransactionReport;
import com.example.reportingapi.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.text.SimpleDateFormat;
import java.util.Optional;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
public class JsonWriter {
    public static void addToJsonIfNotNull(ObjectNode json, String key, Object value) {
        Optional.ofNullable(value).ifPresent(val -> json.put(key, val.toString()));
    }

    public static String createJsonFromTransactionReport(TransactionReport transactionReport) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ObjectNode json = objectMapper.createObjectNode();

        addToJsonIfNotNull(json, "fromDate", dateFormat.format(transactionReport.getFromDate()));
        addToJsonIfNotNull(json, "toDate", dateFormat.format(transactionReport.getToDate()));
        addToJsonIfNotNull(json, "merchant", transactionReport.getMerchant());
        addToJsonIfNotNull(json, "acquirer", transactionReport.getAcquirer());

        return json.toString();
    }

    public static String createJsonFromTransactionList(TransactionList transactionList) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ObjectNode json = objectMapper.createObjectNode();

        addToJsonIfNotNull(json, "fromDate", dateFormat.format(transactionList.getFromDate()));
        addToJsonIfNotNull(json, "toDate", dateFormat.format(transactionList.getToDate()));
        addToJsonIfNotNull(json, "status", transactionList.getStatus());
        addToJsonIfNotNull(json, "operation", transactionList.getOperation());
        addToJsonIfNotNull(json, "merchantId", transactionList.getMerchantId());
        addToJsonIfNotNull(json, "acquirerId", transactionList.getAcquirerId());
        addToJsonIfNotNull(json, "paymentMethod", transactionList.getPaymentMethod());
        addToJsonIfNotNull(json, "errorCode", transactionList.getErrorCode());
        addToJsonIfNotNull(json, "filterField", transactionList.getFilterField());
        addToJsonIfNotNull(json, "filterValue", transactionList.getFilterValue());
        addToJsonIfNotNull(json, "page", transactionList.getPage());

        return json.toString();
    }

    public static String createJsonFromTransaction(Transaction transaction) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = objectMapper.createObjectNode();

        addToJsonIfNotNull(json, "transactionId", transaction.getTransactionId());

        return json.toString();
    }


    public static String createJsonForLogin(User user) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = objectMapper.createObjectNode();

        addToJsonIfNotNull(json, "email", user.getEmail());
        addToJsonIfNotNull(json, "password", user.getPassword());

        return json.toString();
    }
}
