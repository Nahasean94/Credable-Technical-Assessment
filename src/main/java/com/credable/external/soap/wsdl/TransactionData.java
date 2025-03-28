package com.credable.external.soap.wsdl;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for transactionData complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="transactionData">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="alternativechanneltrnscrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="alternativechanneltrnscrNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="alternativechanneltrnsdebitAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="alternativechanneltrnsdebitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="atmTransactionsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="atmtransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="bouncedChequesDebitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="bouncedchequescreditNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="bouncedchequetransactionscrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="bouncedchequetransactionsdrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="chequeDebitTransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="chequeDebitTransactionsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="credittransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="debitcardpostransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="debitcardpostransactionsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="fincominglocaltransactioncrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="incominginternationaltrncrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="incominginternationaltrncrNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="incominglocaltransactioncrNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="intrestAmount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="lastTransactionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="lastTransactionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="lastTransactionValue" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="maxAtmTransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxMonthlyBebitTransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxalternativechanneltrnscr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxalternativechanneltrnsdebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxbouncedchequetransactionscr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxchequedebittransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxdebitcardpostransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxincominginternationaltrncr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxincominglocaltransactioncr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxmobilemoneycredittrn" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxmobilemoneydebittransaction" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxmonthlycredittransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxoutgoinginttrndebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxoutgoinglocaltrndebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="maxoverthecounterwithdrawals" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minAtmTransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minMonthlyDebitTransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minalternativechanneltrnscr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minalternativechanneltrnsdebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minbouncedchequetransactionscr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minchequedebittransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="mindebitcardpostransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minincominginternationaltrncr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minincominglocaltransactioncr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minmobilemoneycredittrn" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minmobilemoneydebittransaction" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minmonthlycredittransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minoutgoinginttrndebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minoutgoinglocaltrndebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="minoverthecounterwithdrawals" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="mobilemoneycredittransactionAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="mobilemoneycredittransactionNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="mobilemoneydebittransactionAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="mobilemoneydebittransactionNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="monthlyBalance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="monthlydebittransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="outgoinginttransactiondebitAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="outgoinginttrndebitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="outgoinglocaltransactiondebitAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="outgoinglocaltransactiondebitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="overdraftLimit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="overthecounterwithdrawalsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="overthecounterwithdrawalsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="transactionValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="updatedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionData", propOrder = {
    "accountNumber",
    "alternativechanneltrnscrAmount",
    "alternativechanneltrnscrNumber",
    "alternativechanneltrnsdebitAmount",
    "alternativechanneltrnsdebitNumber",
    "atmTransactionsNumber",
    "atmtransactionsAmount",
    "bouncedChequesDebitNumber",
    "bouncedchequescreditNumber",
    "bouncedchequetransactionscrAmount",
    "bouncedchequetransactionsdrAmount",
    "chequeDebitTransactionsAmount",
    "chequeDebitTransactionsNumber",
    "createdAt",
    "createdDate",
    "credittransactionsAmount",
    "debitcardpostransactionsAmount",
    "debitcardpostransactionsNumber",
    "fincominglocaltransactioncrAmount",
    "id",
    "incominginternationaltrncrAmount",
    "incominginternationaltrncrNumber",
    "incominglocaltransactioncrNumber",
    "intrestAmount",
    "lastTransactionDate",
    "lastTransactionType",
    "lastTransactionValue",
    "maxAtmTransactions",
    "maxMonthlyBebitTransactions",
    "maxalternativechanneltrnscr",
    "maxalternativechanneltrnsdebit",
    "maxbouncedchequetransactionscr",
    "maxchequedebittransactions",
    "maxdebitcardpostransactions",
    "maxincominginternationaltrncr",
    "maxincominglocaltransactioncr",
    "maxmobilemoneycredittrn",
    "maxmobilemoneydebittransaction",
    "maxmonthlycredittransactions",
    "maxoutgoinginttrndebit",
    "maxoutgoinglocaltrndebit",
    "maxoverthecounterwithdrawals",
    "minAtmTransactions",
    "minMonthlyDebitTransactions",
    "minalternativechanneltrnscr",
    "minalternativechanneltrnsdebit",
    "minbouncedchequetransactionscr",
    "minchequedebittransactions",
    "mindebitcardpostransactions",
    "minincominginternationaltrncr",
    "minincominglocaltransactioncr",
    "minmobilemoneycredittrn",
    "minmobilemoneydebittransaction",
    "minmonthlycredittransactions",
    "minoutgoinginttrndebit",
    "minoutgoinglocaltrndebit",
    "minoverthecounterwithdrawals",
    "mobilemoneycredittransactionAmount",
    "mobilemoneycredittransactionNumber",
    "mobilemoneydebittransactionAmount",
    "mobilemoneydebittransactionNumber",
    "monthlyBalance",
    "monthlydebittransactionsAmount",
    "outgoinginttransactiondebitAmount",
    "outgoinginttrndebitNumber",
    "outgoinglocaltransactiondebitAmount",
    "outgoinglocaltransactiondebitNumber",
    "overdraftLimit",
    "overthecounterwithdrawalsAmount",
    "overthecounterwithdrawalsNumber",
    "transactionValue",
    "updatedAt"
})

public class TransactionData {

    protected String accountNumber;
    protected double alternativechanneltrnscrAmount;
    protected int alternativechanneltrnscrNumber;
    protected double alternativechanneltrnsdebitAmount;
    protected int alternativechanneltrnsdebitNumber;
    protected int atmTransactionsNumber;
    protected double atmtransactionsAmount;
    protected int bouncedChequesDebitNumber;
    protected int bouncedchequescreditNumber;
    protected double bouncedchequetransactionscrAmount;
    protected double bouncedchequetransactionsdrAmount;
    protected double chequeDebitTransactionsAmount;
    protected int chequeDebitTransactionsNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    protected double credittransactionsAmount;
    protected double debitcardpostransactionsAmount;
    protected int debitcardpostransactionsNumber;
    protected double fincominglocaltransactioncrAmount;
    protected Long id;
    protected double incominginternationaltrncrAmount;
    protected int incominginternationaltrncrNumber;
    protected int incominglocaltransactioncrNumber;
    protected Integer intrestAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastTransactionDate;
    protected String lastTransactionType;
    protected Integer lastTransactionValue;
    protected double maxAtmTransactions;
    protected double maxMonthlyBebitTransactions;
    protected double maxalternativechanneltrnscr;
    protected double maxalternativechanneltrnsdebit;
    protected double maxbouncedchequetransactionscr;
    protected double maxchequedebittransactions;
    protected double maxdebitcardpostransactions;
    protected double maxincominginternationaltrncr;
    protected double maxincominglocaltransactioncr;
    protected double maxmobilemoneycredittrn;
    protected double maxmobilemoneydebittransaction;
    protected double maxmonthlycredittransactions;
    protected double maxoutgoinginttrndebit;
    protected double maxoutgoinglocaltrndebit;
    protected double maxoverthecounterwithdrawals;
    protected double minAtmTransactions;
    protected double minMonthlyDebitTransactions;
    protected double minalternativechanneltrnscr;
    protected double minalternativechanneltrnsdebit;
    protected double minbouncedchequetransactionscr;
    protected double minchequedebittransactions;
    protected double mindebitcardpostransactions;
    protected double minincominginternationaltrncr;
    protected double minincominglocaltransactioncr;
    protected double minmobilemoneycredittrn;
    protected double minmobilemoneydebittransaction;
    protected double minmonthlycredittransactions;
    protected double minoutgoinginttrndebit;
    protected double minoutgoinglocaltrndebit;
    protected double minoverthecounterwithdrawals;
    protected double mobilemoneycredittransactionAmount;
    protected int mobilemoneycredittransactionNumber;
    protected double mobilemoneydebittransactionAmount;
    protected int mobilemoneydebittransactionNumber;
    protected double monthlyBalance;
    protected double monthlydebittransactionsAmount;
    protected double outgoinginttransactiondebitAmount;
    protected int outgoinginttrndebitNumber;
    protected double outgoinglocaltransactiondebitAmount;
    protected int outgoinglocaltransactiondebitNumber;
    protected double overdraftLimit;
    protected double overthecounterwithdrawalsAmount;
    protected int overthecounterwithdrawalsNumber;
    protected double transactionValue;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedAt;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAlternativechanneltrnscrAmount() {
        return alternativechanneltrnscrAmount;
    }

    public void setAlternativechanneltrnscrAmount(double alternativechanneltrnscrAmount) {
        this.alternativechanneltrnscrAmount = alternativechanneltrnscrAmount;
    }

    public int getAlternativechanneltrnscrNumber() {
        return alternativechanneltrnscrNumber;
    }

    public void setAlternativechanneltrnscrNumber(int alternativechanneltrnscrNumber) {
        this.alternativechanneltrnscrNumber = alternativechanneltrnscrNumber;
    }

    public double getAlternativechanneltrnsdebitAmount() {
        return alternativechanneltrnsdebitAmount;
    }

    public void setAlternativechanneltrnsdebitAmount(double alternativechanneltrnsdebitAmount) {
        this.alternativechanneltrnsdebitAmount = alternativechanneltrnsdebitAmount;
    }

    public int getAlternativechanneltrnsdebitNumber() {
        return alternativechanneltrnsdebitNumber;
    }

    public void setAlternativechanneltrnsdebitNumber(int alternativechanneltrnsdebitNumber) {
        this.alternativechanneltrnsdebitNumber = alternativechanneltrnsdebitNumber;
    }

    public int getAtmTransactionsNumber() {
        return atmTransactionsNumber;
    }

    public void setAtmTransactionsNumber(int atmTransactionsNumber) {
        this.atmTransactionsNumber = atmTransactionsNumber;
    }

    public double getAtmtransactionsAmount() {
        return atmtransactionsAmount;
    }

    public void setAtmtransactionsAmount(double atmtransactionsAmount) {
        this.atmtransactionsAmount = atmtransactionsAmount;
    }

    public int getBouncedChequesDebitNumber() {
        return bouncedChequesDebitNumber;
    }

    public void setBouncedChequesDebitNumber(int bouncedChequesDebitNumber) {
        this.bouncedChequesDebitNumber = bouncedChequesDebitNumber;
    }

    public int getBouncedchequescreditNumber() {
        return bouncedchequescreditNumber;
    }

    public void setBouncedchequescreditNumber(int bouncedchequescreditNumber) {
        this.bouncedchequescreditNumber = bouncedchequescreditNumber;
    }

    public double getBouncedchequetransactionscrAmount() {
        return bouncedchequetransactionscrAmount;
    }

    public void setBouncedchequetransactionscrAmount(double bouncedchequetransactionscrAmount) {
        this.bouncedchequetransactionscrAmount = bouncedchequetransactionscrAmount;
    }

    public double getBouncedchequetransactionsdrAmount() {
        return bouncedchequetransactionsdrAmount;
    }

    public void setBouncedchequetransactionsdrAmount(double bouncedchequetransactionsdrAmount) {
        this.bouncedchequetransactionsdrAmount = bouncedchequetransactionsdrAmount;
    }

    public double getChequeDebitTransactionsAmount() {
        return chequeDebitTransactionsAmount;
    }

    public void setChequeDebitTransactionsAmount(double chequeDebitTransactionsAmount) {
        this.chequeDebitTransactionsAmount = chequeDebitTransactionsAmount;
    }

    public int getChequeDebitTransactionsNumber() {
        return chequeDebitTransactionsNumber;
    }

    public void setChequeDebitTransactionsNumber(int chequeDebitTransactionsNumber) {
        this.chequeDebitTransactionsNumber = chequeDebitTransactionsNumber;
    }

    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(XMLGregorianCalendar createdAt) {
        this.createdAt = createdAt;
    }

    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(XMLGregorianCalendar createdDate) {
        this.createdDate = createdDate;
    }

    public double getCredittransactionsAmount() {
        return credittransactionsAmount;
    }

    public void setCredittransactionsAmount(double credittransactionsAmount) {
        this.credittransactionsAmount = credittransactionsAmount;
    }

    public double getDebitcardpostransactionsAmount() {
        return debitcardpostransactionsAmount;
    }

    public void setDebitcardpostransactionsAmount(double debitcardpostransactionsAmount) {
        this.debitcardpostransactionsAmount = debitcardpostransactionsAmount;
    }

    public int getDebitcardpostransactionsNumber() {
        return debitcardpostransactionsNumber;
    }

    public void setDebitcardpostransactionsNumber(int debitcardpostransactionsNumber) {
        this.debitcardpostransactionsNumber = debitcardpostransactionsNumber;
    }

    public double getFincominglocaltransactioncrAmount() {
        return fincominglocaltransactioncrAmount;
    }

    public void setFincominglocaltransactioncrAmount(double fincominglocaltransactioncrAmount) {
        this.fincominglocaltransactioncrAmount = fincominglocaltransactioncrAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getIncominginternationaltrncrAmount() {
        return incominginternationaltrncrAmount;
    }

    public void setIncominginternationaltrncrAmount(double incominginternationaltrncrAmount) {
        this.incominginternationaltrncrAmount = incominginternationaltrncrAmount;
    }

    public int getIncominginternationaltrncrNumber() {
        return incominginternationaltrncrNumber;
    }

    public void setIncominginternationaltrncrNumber(int incominginternationaltrncrNumber) {
        this.incominginternationaltrncrNumber = incominginternationaltrncrNumber;
    }

    public int getIncominglocaltransactioncrNumber() {
        return incominglocaltransactioncrNumber;
    }

    public void setIncominglocaltransactioncrNumber(int incominglocaltransactioncrNumber) {
        this.incominglocaltransactioncrNumber = incominglocaltransactioncrNumber;
    }

    public Integer getIntrestAmount() {
        return intrestAmount;
    }

    public void setIntrestAmount(Integer intrestAmount) {
        this.intrestAmount = intrestAmount;
    }

    public XMLGregorianCalendar getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(XMLGregorianCalendar lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public String getLastTransactionType() {
        return lastTransactionType;
    }

    public void setLastTransactionType(String lastTransactionType) {
        this.lastTransactionType = lastTransactionType;
    }

    public Integer getLastTransactionValue() {
        return lastTransactionValue;
    }

    public void setLastTransactionValue(Integer lastTransactionValue) {
        this.lastTransactionValue = lastTransactionValue;
    }

    public double getMaxAtmTransactions() {
        return maxAtmTransactions;
    }

    public void setMaxAtmTransactions(double maxAtmTransactions) {
        this.maxAtmTransactions = maxAtmTransactions;
    }

    public double getMaxMonthlyBebitTransactions() {
        return maxMonthlyBebitTransactions;
    }

    public void setMaxMonthlyBebitTransactions(double maxMonthlyBebitTransactions) {
        this.maxMonthlyBebitTransactions = maxMonthlyBebitTransactions;
    }

    public double getMaxalternativechanneltrnscr() {
        return maxalternativechanneltrnscr;
    }

    public void setMaxalternativechanneltrnscr(double maxalternativechanneltrnscr) {
        this.maxalternativechanneltrnscr = maxalternativechanneltrnscr;
    }

    public double getMaxalternativechanneltrnsdebit() {
        return maxalternativechanneltrnsdebit;
    }

    public void setMaxalternativechanneltrnsdebit(double maxalternativechanneltrnsdebit) {
        this.maxalternativechanneltrnsdebit = maxalternativechanneltrnsdebit;
    }

    public double getMaxbouncedchequetransactionscr() {
        return maxbouncedchequetransactionscr;
    }

    public void setMaxbouncedchequetransactionscr(double maxbouncedchequetransactionscr) {
        this.maxbouncedchequetransactionscr = maxbouncedchequetransactionscr;
    }

    public double getMaxchequedebittransactions() {
        return maxchequedebittransactions;
    }

    public void setMaxchequedebittransactions(double maxchequedebittransactions) {
        this.maxchequedebittransactions = maxchequedebittransactions;
    }

    public double getMaxdebitcardpostransactions() {
        return maxdebitcardpostransactions;
    }

    public void setMaxdebitcardpostransactions(double maxdebitcardpostransactions) {
        this.maxdebitcardpostransactions = maxdebitcardpostransactions;
    }

    public double getMaxincominginternationaltrncr() {
        return maxincominginternationaltrncr;
    }

    public void setMaxincominginternationaltrncr(double maxincominginternationaltrncr) {
        this.maxincominginternationaltrncr = maxincominginternationaltrncr;
    }

    public double getMaxincominglocaltransactioncr() {
        return maxincominglocaltransactioncr;
    }

    public void setMaxincominglocaltransactioncr(double maxincominglocaltransactioncr) {
        this.maxincominglocaltransactioncr = maxincominglocaltransactioncr;
    }

    public double getMaxmobilemoneycredittrn() {
        return maxmobilemoneycredittrn;
    }

    public void setMaxmobilemoneycredittrn(double maxmobilemoneycredittrn) {
        this.maxmobilemoneycredittrn = maxmobilemoneycredittrn;
    }

    public double getMaxmobilemoneydebittransaction() {
        return maxmobilemoneydebittransaction;
    }

    public void setMaxmobilemoneydebittransaction(double maxmobilemoneydebittransaction) {
        this.maxmobilemoneydebittransaction = maxmobilemoneydebittransaction;
    }

    public double getMaxmonthlycredittransactions() {
        return maxmonthlycredittransactions;
    }

    public void setMaxmonthlycredittransactions(double maxmonthlycredittransactions) {
        this.maxmonthlycredittransactions = maxmonthlycredittransactions;
    }

    public double getMaxoutgoinginttrndebit() {
        return maxoutgoinginttrndebit;
    }

    public void setMaxoutgoinginttrndebit(double maxoutgoinginttrndebit) {
        this.maxoutgoinginttrndebit = maxoutgoinginttrndebit;
    }

    public double getMaxoutgoinglocaltrndebit() {
        return maxoutgoinglocaltrndebit;
    }

    public void setMaxoutgoinglocaltrndebit(double maxoutgoinglocaltrndebit) {
        this.maxoutgoinglocaltrndebit = maxoutgoinglocaltrndebit;
    }

    public double getMaxoverthecounterwithdrawals() {
        return maxoverthecounterwithdrawals;
    }

    public void setMaxoverthecounterwithdrawals(double maxoverthecounterwithdrawals) {
        this.maxoverthecounterwithdrawals = maxoverthecounterwithdrawals;
    }

    public double getMinAtmTransactions() {
        return minAtmTransactions;
    }

    public void setMinAtmTransactions(double minAtmTransactions) {
        this.minAtmTransactions = minAtmTransactions;
    }

    public double getMinMonthlyDebitTransactions() {
        return minMonthlyDebitTransactions;
    }

    public void setMinMonthlyDebitTransactions(double minMonthlyDebitTransactions) {
        this.minMonthlyDebitTransactions = minMonthlyDebitTransactions;
    }

    public double getMinalternativechanneltrnscr() {
        return minalternativechanneltrnscr;
    }

    public void setMinalternativechanneltrnscr(double minalternativechanneltrnscr) {
        this.minalternativechanneltrnscr = minalternativechanneltrnscr;
    }

    public double getMinalternativechanneltrnsdebit() {
        return minalternativechanneltrnsdebit;
    }

    public void setMinalternativechanneltrnsdebit(double minalternativechanneltrnsdebit) {
        this.minalternativechanneltrnsdebit = minalternativechanneltrnsdebit;
    }

    public double getMinbouncedchequetransactionscr() {
        return minbouncedchequetransactionscr;
    }

    public void setMinbouncedchequetransactionscr(double minbouncedchequetransactionscr) {
        this.minbouncedchequetransactionscr = minbouncedchequetransactionscr;
    }

    public double getMinchequedebittransactions() {
        return minchequedebittransactions;
    }

    public void setMinchequedebittransactions(double minchequedebittransactions) {
        this.minchequedebittransactions = minchequedebittransactions;
    }

    public double getMindebitcardpostransactions() {
        return mindebitcardpostransactions;
    }

    public void setMindebitcardpostransactions(double mindebitcardpostransactions) {
        this.mindebitcardpostransactions = mindebitcardpostransactions;
    }

    public double getMinincominginternationaltrncr() {
        return minincominginternationaltrncr;
    }

    public void setMinincominginternationaltrncr(double minincominginternationaltrncr) {
        this.minincominginternationaltrncr = minincominginternationaltrncr;
    }

    public double getMinincominglocaltransactioncr() {
        return minincominglocaltransactioncr;
    }

    public void setMinincominglocaltransactioncr(double minincominglocaltransactioncr) {
        this.minincominglocaltransactioncr = minincominglocaltransactioncr;
    }

    public double getMinmobilemoneycredittrn() {
        return minmobilemoneycredittrn;
    }

    public void setMinmobilemoneycredittrn(double minmobilemoneycredittrn) {
        this.minmobilemoneycredittrn = minmobilemoneycredittrn;
    }

    public double getMinmobilemoneydebittransaction() {
        return minmobilemoneydebittransaction;
    }

    public void setMinmobilemoneydebittransaction(double minmobilemoneydebittransaction) {
        this.minmobilemoneydebittransaction = minmobilemoneydebittransaction;
    }

    public double getMinmonthlycredittransactions() {
        return minmonthlycredittransactions;
    }

    public void setMinmonthlycredittransactions(double minmonthlycredittransactions) {
        this.minmonthlycredittransactions = minmonthlycredittransactions;
    }

    public double getMinoutgoinginttrndebit() {
        return minoutgoinginttrndebit;
    }

    public void setMinoutgoinginttrndebit(double minoutgoinginttrndebit) {
        this.minoutgoinginttrndebit = minoutgoinginttrndebit;
    }

    public double getMinoutgoinglocaltrndebit() {
        return minoutgoinglocaltrndebit;
    }

    public void setMinoutgoinglocaltrndebit(double minoutgoinglocaltrndebit) {
        this.minoutgoinglocaltrndebit = minoutgoinglocaltrndebit;
    }

    public double getMinoverthecounterwithdrawals() {
        return minoverthecounterwithdrawals;
    }

    public void setMinoverthecounterwithdrawals(double minoverthecounterwithdrawals) {
        this.minoverthecounterwithdrawals = minoverthecounterwithdrawals;
    }

    public double getMobilemoneycredittransactionAmount() {
        return mobilemoneycredittransactionAmount;
    }

    public void setMobilemoneycredittransactionAmount(double mobilemoneycredittransactionAmount) {
        this.mobilemoneycredittransactionAmount = mobilemoneycredittransactionAmount;
    }

    public int getMobilemoneycredittransactionNumber() {
        return mobilemoneycredittransactionNumber;
    }

    public void setMobilemoneycredittransactionNumber(int mobilemoneycredittransactionNumber) {
        this.mobilemoneycredittransactionNumber = mobilemoneycredittransactionNumber;
    }

    public double getMobilemoneydebittransactionAmount() {
        return mobilemoneydebittransactionAmount;
    }

    public void setMobilemoneydebittransactionAmount(double mobilemoneydebittransactionAmount) {
        this.mobilemoneydebittransactionAmount = mobilemoneydebittransactionAmount;
    }

    public int getMobilemoneydebittransactionNumber() {
        return mobilemoneydebittransactionNumber;
    }

    public void setMobilemoneydebittransactionNumber(int mobilemoneydebittransactionNumber) {
        this.mobilemoneydebittransactionNumber = mobilemoneydebittransactionNumber;
    }

    public double getMonthlyBalance() {
        return monthlyBalance;
    }

    public void setMonthlyBalance(double monthlyBalance) {
        this.monthlyBalance = monthlyBalance;
    }

    public double getMonthlydebittransactionsAmount() {
        return monthlydebittransactionsAmount;
    }

    public void setMonthlydebittransactionsAmount(double monthlydebittransactionsAmount) {
        this.monthlydebittransactionsAmount = monthlydebittransactionsAmount;
    }

    public double getOutgoinginttransactiondebitAmount() {
        return outgoinginttransactiondebitAmount;
    }

    public void setOutgoinginttransactiondebitAmount(double outgoinginttransactiondebitAmount) {
        this.outgoinginttransactiondebitAmount = outgoinginttransactiondebitAmount;
    }

    public int getOutgoinginttrndebitNumber() {
        return outgoinginttrndebitNumber;
    }

    public void setOutgoinginttrndebitNumber(int outgoinginttrndebitNumber) {
        this.outgoinginttrndebitNumber = outgoinginttrndebitNumber;
    }

    public double getOutgoinglocaltransactiondebitAmount() {
        return outgoinglocaltransactiondebitAmount;
    }

    public void setOutgoinglocaltransactiondebitAmount(double outgoinglocaltransactiondebitAmount) {
        this.outgoinglocaltransactiondebitAmount = outgoinglocaltransactiondebitAmount;
    }

    public int getOutgoinglocaltransactiondebitNumber() {
        return outgoinglocaltransactiondebitNumber;
    }

    public void setOutgoinglocaltransactiondebitNumber(int outgoinglocaltransactiondebitNumber) {
        this.outgoinglocaltransactiondebitNumber = outgoinglocaltransactiondebitNumber;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverthecounterwithdrawalsAmount() {
        return overthecounterwithdrawalsAmount;
    }

    public void setOverthecounterwithdrawalsAmount(double overthecounterwithdrawalsAmount) {
        this.overthecounterwithdrawalsAmount = overthecounterwithdrawalsAmount;
    }

    public int getOverthecounterwithdrawalsNumber() {
        return overthecounterwithdrawalsNumber;
    }

    public void setOverthecounterwithdrawalsNumber(int overthecounterwithdrawalsNumber) {
        this.overthecounterwithdrawalsNumber = overthecounterwithdrawalsNumber;
    }

    public double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public XMLGregorianCalendar getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(XMLGregorianCalendar updatedAt) {
        this.updatedAt = updatedAt;
    }
}
