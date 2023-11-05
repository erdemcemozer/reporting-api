package com.example.reportingapi.externalAPI;

import com.example.reportingapi.constants.ReportingConstants;
import com.example.reportingapi.model.User;
import com.example.reportingapi.util.TokenStorage;
import com.example.reportingapi.util.ParamBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.example.reportingapi.constants.ReportingConstants.*;

/**
 * @Author Erdem Ozer
 * Date: 04/11/2023
 */

@Component
public class LoginAPI {
    private final ParamBuilder paramBuilder;

    @Autowired
    public LoginAPI(ParamBuilder paramBuilder) {
        this.paramBuilder = paramBuilder;
    }

    public String loginToExternalAPI(User user) throws IOException, InterruptedException {
        TokenStorage token = new TokenStorage();
        ObjectMapper objectMapper = new ObjectMapper();

        String externalApiUrl = paramBuilder.buildApiUrl(ReportingConstants.USER_LOGIN_ENDPOINT);
        String requestBody = "{\"email\": \"" + user.getEmail() + "\", \"password\": \"" + user.getPassword() + "\"}";

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(externalApiUrl))
                .header(CONTENT_TYPE_HEADER_NAME, CONTENT_TYPE_HEADER_VALUE)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonNode jsonNode = objectMapper.readTree(response.body());
        token.setToken(jsonNode.get(JSON_FIELD_TOKEN).asText());
        return token.getToken();
    }
}
