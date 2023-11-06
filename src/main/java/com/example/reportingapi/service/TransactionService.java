package com.example.reportingapi.service;

import com.example.reportingapi.model.TransactionList;
import com.example.reportingapi.model.TransactionReport;
import com.example.reportingapi.response.TransactionResponse;
import com.example.reportingapi.response.TransactionsReportResponse;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
public interface TransactionService {
    TransactionsReportResponse postReport(TransactionReport transactionReport) throws IOException, InterruptedException;

    TransactionResponse postTransactionList(TransactionList transactionList) throws IOException, InterruptedException;
}
