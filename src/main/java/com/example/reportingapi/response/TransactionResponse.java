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
    public static class CustomerInfo {
        private Integer id;
        private String created_at;
        private String updated_at;
        private String deleted_at;
        private String number;
        private String expiryMonth;
        private String expiryYear;
        private String startMonth;
        private String startYear;
        private String issueNumber;
        private String email;
        private String birthday;
        private String gender;
        private String billingTitle;
        private String billingFirstName;
        private String billingLastName;
        private String billingCompany;
        private String billingAddress1;
        private String billingAddress2;
        private String billingCity;
        private String billingPostcode;
        private String billingState;
        private String billingCountry;
        private String billingPhone;
        private String billingFax;
        private String shippingTitle;
        private String shippingFirstName;
        private String shippingLastName;
        private String shippingCompany;
        private String shippingAddress1;
        private String shippingAddress2;
        private String shippingCity;
        private String shippingPostcode;
        private String shippingState;
        private String shippingCountry;
        private String shippingPhone;
        private String shippingFax;
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
