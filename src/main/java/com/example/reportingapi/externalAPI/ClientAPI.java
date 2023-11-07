package com.example.reportingapi.externalAPI;

import com.example.reportingapi.constants.ReportingConstants;
import com.example.reportingapi.model.Transaction;
import com.example.reportingapi.response.ClientResponse;
import com.example.reportingapi.util.ParamBuilder;
import com.example.reportingapi.util.TokenStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.example.reportingapi.constants.ReportingConstants.*;
import static com.example.reportingapi.util.JsonWriter.createJsonFromTransaction;

/**
 * @Author Erdem Ozer
 * Date: 07/11/2023
 */
@Component
public class ClientAPI {
    private final ParamBuilder paramBuilder;

    @Autowired
    public ClientAPI(ParamBuilder paramBuilder) {
        this.paramBuilder = paramBuilder;
    }

    public ClientResponse getClient(Transaction transaction) throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();

        String externalApiUrl = paramBuilder.buildApiUrl(ReportingConstants.CLIENT_ENDPOINT);
        String requestBody = createJsonFromTransaction(transaction);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(externalApiUrl))
                .header(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .header(AUTHORIZATION_HEADER_NAME, TokenStorage.getInstance().getToken())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), ClientResponse.class);
    }
}
