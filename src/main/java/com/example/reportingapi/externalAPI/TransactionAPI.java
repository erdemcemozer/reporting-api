package com.example.reportingapi.externalAPI;

import com.example.reportingapi.constants.ReportingConstants;
import com.example.reportingapi.model.TransactionReport;
import com.example.reportingapi.response.TransactionReportResponse;
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

    public TransactionReportResponse postReport(TransactionReport transactionReport) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        String token = TokenStorage.getInstance().getToken();

        String externalApiUrl = paramBuilder.buildApiUrl(ReportingConstants.TRANSACTION_REPORT_ENDPOINT);
        String requestBody = createJsonFromTransactionReport(transactionReport);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(externalApiUrl))
                .header(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .header(AUTHORIZATION_HEADER_NAME, token)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), TransactionReportResponse.class);
    }

    private static String createJsonFromTransactionReport(TransactionReport transactionReport) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode json = objectMapper.createObjectNode();

        if (transactionReport.getFromDate() != null) {
            json.put("fromDate", dateFormat.format(transactionReport.getFromDate()));
        }
        if (transactionReport.getToDate() != null) {
            json.put("toDate",  dateFormat.format(transactionReport.getToDate()));
        }
        if (transactionReport.getMerchant() != null) {
            json.put("merchant", transactionReport.getMerchant());
        }
        if (transactionReport.getAcquirer() != null) {
            json.put("acquirer", transactionReport.getAcquirer());
        }

        return json.toString();
    }}
