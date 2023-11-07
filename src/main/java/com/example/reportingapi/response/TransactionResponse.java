package com.example.reportingapi.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.String;

/**
 * @Author Erdem Ozer
 * String: 06/11/2023
 */

@Data
public class TransactionResponse extends DefaultResponse {
    private Fx fx;
    private CustomerInfo customerInfo;
    private Merchant merchant;
    private Transaction transaction;

    @Getter
    @Setter
    public static class Fx {
        private MerchantFx merchant;
    }

    @Getter
    @Setter
    public static class Merchant {
        private String name;
    }

    @Getter
    @Setter
    public static class Transaction {
        private MerchantTransaction merchant;
    }

    @Getter
    @Setter
    public static class MerchantFx {
        private int originalAmount;
        private String originalCurrency;
        private int convertedAmount;
        private String convertedCurrency;
    }

    @Getter
    @Setter
    public static class MerchantTransaction {
        private String referenceNo;
        private Integer merchantId;
        private String status;
        private String channel;
        private String customData;
        private String chainId;
        private Integer agentInfoId;
        private String operation;
        private Integer code;
        private Integer fxTransactionId;
        private Integer acquirerTransactionId;
        private Integer id;
        private String message;
        private String created_at;
        private String updated_at;
        private String transactionId;
        private Object agent;
        private String type;
    }
}
