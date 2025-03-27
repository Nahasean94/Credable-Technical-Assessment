package com.credable.external.soap.wsdl;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Generated;
import lombok.Setter;


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
@Setter
@Generated
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

}
