package com.example.reportingapi.controller;

import com.example.reportingapi.model.Transaction;
import com.example.reportingapi.response.ClientResponse;
import com.example.reportingapi.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 07/11/2023
 */
@RestController
public class ClientController {
    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/client")
    public ResponseEntity<ClientResponse> getClient(@RequestBody Transaction transaction) throws IOException, InterruptedException {
        logger.info("getClient::class::" + this.getClass().getSimpleName());
        ClientResponse response = clientService.getClient(transaction);
        return ResponseEntity.ok(response);
    }
}
