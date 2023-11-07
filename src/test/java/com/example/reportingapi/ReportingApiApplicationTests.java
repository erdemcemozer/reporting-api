package com.example.reportingapi;

import com.example.reportingapi.model.Transaction;
import com.example.reportingapi.util.JsonWriter;
import com.example.reportingapi.util.ParamBuilder;
import com.example.reportingapi.util.TokenStorage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class ReportingApiApplicationTests {
    @Test
    public void testBuildApiUrl() {
        String endpoint = "exampleEndpoint";
        ParamBuilder paramBuilder = new ParamBuilder();

        String apiUrl = paramBuilder.buildApiUrl(endpoint);

        assertEquals("https://sandbox-reporting.rpdpymnt.com/api/v3/" + endpoint, apiUrl);
    }

    @Test
    public void testSingletonBehavior() {
        TokenStorage tokenStorage1 = TokenStorage.getInstance();
        TokenStorage tokenStorage2 = TokenStorage.getInstance();

        assertSame(tokenStorage1, tokenStorage2);
    }

    @Test
    public void testTokenSetAndGet() {
        TokenStorage tokenStorage = TokenStorage.getInstance();
        String expectedToken = "exampleToken";
        tokenStorage.setToken(expectedToken);

        String retrievedToken = tokenStorage.getToken();

        assertEquals(expectedToken, retrievedToken);
    }

    @Test
    public void testCreateJsonFromTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionId("12345");
        String expectedJson = "{\"transactionId\":\"12345\"}";

        String result = JsonWriter.createJsonFromTransaction(transaction);

        assertEquals(expectedJson, result);
    }

}
