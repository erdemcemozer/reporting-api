package com.example.reportingapi.controller;

import com.example.reportingapi.model.TransactionList;
import com.example.reportingapi.model.TransactionReport;
import com.example.reportingapi.response.TransactionResponse;
import com.example.reportingapi.response.TransactionsReportResponse;
import com.example.reportingapi.service.TransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
@RestController
public class TransactionController {
    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/transactions/report")
    public ResponseEntity<TransactionsReportResponse> postReport(@RequestBody TransactionReport report) throws IOException, InterruptedException {
        logger.info("postReport::class::" + this.getClass().getSimpleName());
        TransactionsReportResponse response = transactionService.postReport(report);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/transaction/list")
    public ResponseEntity<TransactionResponse> postTransactionList(@RequestBody TransactionList transactionList) throws IOException, InterruptedException {
        logger.info("postTransaction::class::" + this.getClass().getSimpleName());
        TransactionResponse response = transactionService.postTransactionList(transactionList);
        return ResponseEntity.ok(response);
    }
}
