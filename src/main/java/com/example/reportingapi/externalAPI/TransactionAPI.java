package com.example.reportingapi.externalAPI;

import com.example.reportingapi.constants.ReportingConstants;
import com.example.reportingapi.model.TransactionList;
import com.example.reportingapi.model.TransactionReport;
import com.example.reportingapi.response.TransactionResponse;
import com.example.reportingapi.response.TransactionsReportResponse;
import com.example.reportingapi.util.ParamBuilder;
import com.example.reportingapi.util.TokenStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;

import static com.example.reportingapi.constants.ReportingConstants.*;
import static com.example.reportingapi.util.JsonWriter.addToJsonIfNotNull;

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
        String token = TokenStorage.getInstance().getToken();

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(externalApiUrl))
                .header(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .header(AUTHORIZATION_HEADER_NAME, token)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), TransactionsReportResponse.class);
    }

    public TransactionResponse postTransaction(TransactionList transactionList) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String externalApiUrl = paramBuilder.buildApiUrl(TRANSACTION_LIST_ENDPOINT);
        String requestBody = createJsonFromTransaction(transactionList);
        String token = TokenStorage.getInstance().getToken();

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(externalApiUrl))
                .header(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .header(AUTHORIZATION_HEADER_NAME, token)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), TransactionResponse.class);
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

    public static String createJsonFromTransaction(TransactionList transactionList) {
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
}
