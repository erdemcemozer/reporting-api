package com.example.reportingapi.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
@Data
public class TransactionResponse extends DefaultResponse {

    private Integer per_page;
    private Integer current_page;
    private String next_page_url;
    private String prev_page_url;
    private String path;
    private String first_page_url;
    private Integer from;
    private Integer to;
    private List<Data> data;

    @Getter
    @Setter
    public static class Data {
        private Fx fx;
        private CustomerInfo customerInfo;
        private Merchant merchant;
        private Ipn ipn;
        private Transaction transaction;
        private Acquirer acquirer;
        private boolean refundable;
        private String updated_at;
        private String created_at;

        @Getter
        @Setter
        public static class Fx {
            private MerchantFx merchant;
        }

        @Getter
        @Setter
        public static class CustomerInfo {
            private String number;
            private String email;
            private String billingFirstName;
            private String billingLastName;
        }

        @Getter
        @Setter
        public static class Merchant {
            private int id;
            private String name;
            private boolean allowPartialRefund;
            private boolean allowPartialCapture;

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
            private String status;
            private String customData;
            private String type;
            private String operation;
            private String message;
            private String created_at;
            private String transactionId;
        }

        @Getter
        @Setter
        public static class Ipn {
            private boolean received;
        }

        @Getter
        @Setter
        public static class Transaction {
            private MerchantTransaction merchant;
        }

        @Getter
        @Setter
        public static class Acquirer {
            private int id;
            private String name;
            private String code;
            private String type;
        }
    }
}
