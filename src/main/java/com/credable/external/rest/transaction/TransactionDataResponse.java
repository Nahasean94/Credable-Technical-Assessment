package com.credable.external.rest.transaction;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionDataResponse {
    private List<TransactionData> transactions;

    public List<TransactionData> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionData> transactions) {
        this.transactions = transactions;
    }
}
@Setter
@Getter
class TransactionData {
    private String accountNumber;
    private BigDecimal alternativeChannelTrnsCrAmount;
    private int alternativeChannelTrnsCrNumber;
    private BigDecimal alternativeChannelTrnsDebitAmount;
    private int alternativeChannelTrnsDebitNumber;
    private int atmTransactionsNumber;
    private BigDecimal atmTransactionsAmount;
    private int bouncedChequesDebitNumber;
    private int bouncedChequesCreditNumber;
    private BigDecimal bouncedChequeTransactionsCrAmount;
    private BigDecimal bouncedChequeTransactionsDrAmount;
    private BigDecimal chequeDebitTransactionsAmount;
    private int chequeDebitTransactionsNumber;
    private Date createdAt;
    private Date createdDate;
    private BigDecimal creditTransactionsAmount;
    private BigDecimal debitCardPosTransactionsAmount;
    private int debitCardPosTransactionsNumber;
    private BigDecimal incomingInternationalTrnCrAmount;
    private int incomingInternationalTrnCrNumber;
    private int incomingLocalTransactionCrNumber;
    private BigDecimal interestAmount;
    private Date lastTransactionDate;
    private String lastTransactionType;
    private BigDecimal lastTransactionValue;
    private BigDecimal maxAtmTransactions;
    private BigDecimal maxMonthlyDebitTransactions;
    private BigDecimal maxOverTheCounterWithdrawals;
    private BigDecimal minAtmTransactions;
    private BigDecimal minMonthlyDebitTransactions;
    private BigDecimal minOverTheCounterWithdrawals;
    private BigDecimal mobileMoneyCreditTransactionAmount;
    private int mobileMoneyCreditTransactionNumber;
    private BigDecimal mobileMoneyDebitTransactionAmount;
    private int mobileMoneyDebitTransactionNumber;
    private BigDecimal monthlyBalance;
    private BigDecimal monthlyDebitTransactionsAmount;
    private BigDecimal outgoingIntTransactionDebitAmount;
    private int outgoingIntTrnDebitNumber;
    private BigDecimal outgoingLocalTransactionDebitAmount;
    private int outgoingLocalTransactionDebitNumber;
    private BigDecimal overdraftLimit;
    private BigDecimal overTheCounterWithdrawalsAmount;
    private int overTheCounterWithdrawalsNumber;
    private BigDecimal transactionValue;
    private Date updatedAt;


}
