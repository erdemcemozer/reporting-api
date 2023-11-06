package com.example.reportingapi.service;

import com.example.reportingapi.model.TransactionReport;
import com.example.reportingapi.response.TransactionReportResponse;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
public interface TransactionService {
    TransactionReportResponse postReport(TransactionReport transactionReport) throws IOException, InterruptedException;
}
