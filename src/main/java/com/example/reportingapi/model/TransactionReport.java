package com.example.reportingapi.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
@Data
public class TransactionReport {
    Date fromDate;
    Date toDate;
    Integer merchant;
    Integer acquirer;
}
