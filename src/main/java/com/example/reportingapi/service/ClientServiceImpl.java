package com.example.reportingapi.service;

import com.example.reportingapi.externalAPI.ClientAPI;
import com.example.reportingapi.model.Transaction;
import com.example.reportingapi.response.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 07/11/2023
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientAPI clientAPI;

    @Override
    public ClientResponse getClient(Transaction transaction) throws IOException, InterruptedException {
        return clientAPI.getClient(transaction);
    }
}
