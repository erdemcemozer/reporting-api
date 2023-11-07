package com.example.reportingapi.service;

import com.example.reportingapi.model.Transaction;
import com.example.reportingapi.response.ClientResponse;

import java.io.IOException;

/**
 * @Author Erdem Ozer
 * Date: 07/11/2023
 */
public interface ClientService {

    ClientResponse getClient(Transaction transaction) throws IOException, InterruptedException;
}
