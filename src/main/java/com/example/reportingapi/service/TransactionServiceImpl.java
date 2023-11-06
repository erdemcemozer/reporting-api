package com.example.reportingapi.service;

import com.example.reportingapi.externalAPI.TransactionAPI;
import com.example.reportingapi.model.TransactionList;
import com.example.reportingapi.model.TransactionReport;
import com.example.reportingapi.response.TransactionResponse;
import com.example.reportingapi.response.TransactionsReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionAPI transactionAPI;

    @Override
    public TransactionsReportResponse postReport(TransactionReport transactionReport) throws IOException, InterruptedException {
        return transactionAPI.postReport(transactionReport);
    }

    @Override
    public TransactionResponse postTransactionList(TransactionList transactionList) throws IOException, InterruptedException {
        return transactionAPI.postTransaction(transactionList);
    }
}
