package com.example.reportingapi.externalAPI;

import com.example.reportingapi.constants.ReportingConstants;
import com.example.reportingapi.model.Transaction;
import com.example.reportingapi.model.TransactionList;
import com.example.reportingapi.model.TransactionReport;
import com.example.reportingapi.response.TransactionListResponse;
import com.example.reportingapi.response.TransactionResponse;
import com.example.reportingapi.response.TransactionsReportResponse;
import com.example.reportingapi.util.ParamBuilder;
import com.example.reportingapi.util.TokenStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.example.reportingapi.constants.ReportingConstants.*;
import static com.example.reportingapi.util.JsonWriter.*;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
@Component
public class TransactionAPI {
    private final ParamBuilder paramBuilder;

    public TransactionAPI(ParamBuilder paramBuilder) {
        this.paramBuilder = paramBuilder;
    }

    public TransactionsReportResponse postReport(TransactionReport transactionReport) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String externalApiUrl = paramBuilder.buildApiUrl(ReportingConstants.TRANSACTION_REPORT_ENDPOINT);
        String requestBody = createJsonFromTransactionReport(transactionReport);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(externalApiUrl))
                .header(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .header(AUTHORIZATION_HEADER_NAME, TokenStorage.getInstance().getToken())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), TransactionsReportResponse.class);
    }

    public TransactionListResponse postTransaction(TransactionList transactionList) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String externalApiUrl = paramBuilder.buildApiUrl(TRANSACTION_LIST_ENDPOINT);
        String requestBody = createJsonFromTransactionList(transactionList);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(externalApiUrl))
                .header(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .header(AUTHORIZATION_HEADER_NAME, TokenStorage.getInstance().getToken())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), TransactionListResponse.class);
    }

    public TransactionResponse getTransaction(Transaction transaction) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String externalApiUrl = paramBuilder.buildApiUrl(TRANSACTION_ENDPOINT);
        String requestBody = createJsonFromTransaction(transaction);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(externalApiUrl))
                .header(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .header(AUTHORIZATION_HEADER_NAME, TokenStorage.getInstance().getToken())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), TransactionResponse.class);
    }
}
