package com.credable.controller;


import com.credable.external.soap.wsdl.TransactionData;
import com.credable.model.TransactionResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@Tag(name = "Transaction management", description = "Manages transaction records for a user")
@Slf4j
public class TransactionController {


        private final TransactionResponse transactionResponse= new TransactionResponse();
    @GetMapping("/v1/transactions/getTransactions/{customerNumber}")
    public TransactionResponse requestLoan(@PathVariable String customerNumber) {
        log.info("Received request to get customer transactions {}", customerNumber);

        try {
            String json = """
                    [
                    {
                    "accountNumber": "332216783322167555621628"
                    ,
                    "alternativechanneltrnscrAmount": 87988.2441,
                    "alternativechanneltrnscrNumber": 0,
                    "alternativechanneltrnsdebitAmount": 675.3423,
                    "alternativechanneltrnsdebitNumber": 902403930,
                    "atmTransactionsNumber": 4812921,
                    "atmtransactionsAmount": 561.96661249,
                    "bouncedChequesDebitNumber": 8,
                    "bouncedchequescreditNumber": 0,
                    "bouncedchequetransactionscrAmount": 748011.19,
                    "bouncedchequetransactionsdrAmount": 43345.569028578,
                    "chequeDebitTransactionsAmount": 4.6933076819151E8,
                    "chequeDebitTransactionsNumber": 44,
                    "createdAt": 740243532000,
                    "createdDate": 1196266216000,
                    "credittransactionsAmount": 609.297663,
                    "debitcardpostransactionsAmount": 21.134264,
                    "debitcardpostransactionsNumber": 502,
                    "fincominglocaltransactioncrAmount": 0.0,
                    "id": 2,
                    "incominginternationaltrncrAmount": 70.52733936,
                    "incominginternationaltrncrNumber": 9,
                    "incominglocaltransactioncrNumber": 876,
                    "intrestAmount": 310118,
                    "lastTransactionDate": 1169339429000,
                    "lastTransactionType": null,
                    "lastTransactionValue": 3,
                    "maxAtmTransactions": 6.0,
                    "maxMonthlyBebitTransactions": 5.66201073E8,
                    "maxalternativechanneltrnscr": 0.0,
                    "maxalternativechanneltrnsdebit": 0.0,
                    "maxbouncedchequetransactionscr": 0.0,
                    "maxchequedebittransactions": 0.0,
                    "maxdebitcardpostransactions": 5.18696078798654E15,
                    "maxincominginternationaltrncr": 0.0,
                    "maxincominglocaltransactioncr": 0.0,
                    "maxmobilemoneycredittrn": 0.0,
                    "maxmobilemoneydebittransaction": 0.0,
                    "maxmonthlycredittransactions": 0.0,
                    "maxoutgoinginttrndebit": 0.0,
                    "maxoutgoinglocaltrndebit": 0.0,
                    "maxoverthecounterwithdrawals": 959858.0,
                    "minAtmTransactions": 0.0,
                    "minMonthlyDebitTransactions": 0.0,
                    "minalternativechanneltrnscr": 0.0,
                    "minalternativechanneltrnsdebit": 0.0,
                    "minbouncedchequetransactionscr": 0.0,
                    "minchequedebittransactions": 0.0,
                    "mindebitcardpostransactions": 4.539102239610779E15,
                    "minincominginternationaltrncr": 0.0,
                    "minincominglocaltransactioncr": 0.0,
                    "minmobilemoneycredittrn": 0.0,
                    "minmobilemoneydebittransaction": 524.0,
                    "minmonthlycredittransactions": 0.0,
                    "minoutgoinginttrndebit": 0.0,
                    "minoutgoinglocaltrndebit": 0.0,
                    "minoverthecounterwithdrawals": 5821338.0,
                    "mobilemoneycredittransactionAmount": 0.0,
                    "mobilemoneycredittransactionNumber": 946843,
                    "mobilemoneydebittransactionAmount": 0.0,
                    "mobilemoneydebittransactionNumber": 5523407,
                    "monthlyBalance": 6.59722841E8,
                    "monthlydebittransactionsAmount": 103262.90429936,
                    "outgoinginttransactiondebitAmount": 5.473303560725E7,
                    "outgoinginttrndebitNumber": 646,
                    "outgoinglocaltransactiondebitAmount": 565972.1236,
                    "outgoinglocaltransactiondebitNumber": 2971,
                    "overdraftLimit": 0.0,
                    "overthecounterwithdrawalsAmount": 332.0,
                    "overthecounterwithdrawalsNumber": 87569,
                    "transactionValue": 1.0,
                    "updatedAt": 773556430000
                    },
                    {
                    "accountNumber": "332216783322167555621628"
                    ,
                    "alternativechanneltrnscrAmount": 27665.6889301,
                    "alternativechanneltrnscrNumber": 0,
                    "alternativechanneltrnsdebitAmount": 2.9997265951905E7,
                    "alternativechanneltrnsdebitNumber": 114,
                    "atmTransactionsNumber": 36934417,
                    "atmtransactionsAmount": 192538.94,
                    "bouncedChequesDebitNumber": 535,
                    "bouncedchequescreditNumber": 0,
                    "bouncedchequetransactionscrAmount": 1.37,
                    "bouncedchequetransactionsdrAmount": 2602.4,
                    "chequeDebitTransactionsAmount": 2765.57,
                    "chequeDebitTransactionsNumber": 6,
                    "createdAt": 1401263420000,
                    "createdDate": 1350538588000,
                    "credittransactionsAmount": 0.0,
                    "debitcardpostransactionsAmount": 117347.063,
                    "debitcardpostransactionsNumber": 931309756,
                    "fincominglocaltransactioncrAmount": 2552389.4,
                    "id": 5,
                    "incominginternationaltrncrAmount": 76.160425,
                    "incominginternationaltrncrNumber": 285700400,
                    "incominglocaltransactioncrNumber": 1,
                    "intrestAmount": 22,
                    "lastTransactionDate": 554704439000,
                    "lastTransactionType": null,
                    "lastTransactionValue": 1,
                    "maxAtmTransactions": 0.0,
                    "maxMonthlyBebitTransactions": 7.8272009E7,
                    "maxalternativechanneltrnscr": 0.0,
                    "maxalternativechanneltrnsdebit": 0.0,
                    "maxbouncedchequetransactionscr": 0.0,
                    "maxchequedebittransactions": 0.0,
                    "maxdebitcardpostransactions": 5.468080253826023E15,
                    "maxincominginternationaltrncr": 0.0,
                    "maxincominglocaltransactioncr": 0.0,
                    "maxmobilemoneycredittrn": 0.0,
                    "maxmobilemoneydebittransaction": 0.0,
                    "maxmonthlycredittransactions": 0.0,
                    "maxoutgoinginttrndebit": 0.0,
                    "maxoutgoinglocaltrndebit": 0.0,
                    "maxoverthecounterwithdrawals": 6.09866462E8,
                    "minAtmTransactions": 0.0,
                    "minMonthlyDebitTransactions": 0.0,
                    "minalternativechanneltrnscr": 0.0,
                    "minalternativechanneltrnsdebit": 0.0,
                    "minbouncedchequetransactionscr": 0.0,
                    "minchequedebittransactions": 0.0,
                    "mindebitcardpostransactions": 4.716295906413E12,
                    "minincominginternationaltrncr": 0.0,
                    "minincominglocaltransactioncr": 0.0,
                    "minmobilemoneycredittrn": 0.0,
                    "minmobilemoneydebittransaction": 0.0,
                    "minmonthlycredittransactions": 29624.78,
                    "minoutgoinginttrndebit": 0.0,
                    "minoutgoinglocaltrndebit": 0.0,
                    "minoverthecounterwithdrawals": 1.00927826E8,
                    "mobilemoneycredittransactionAmount": 349693.8071922,
                    "mobilemoneycredittransactionNumber": 4092,
                    "mobilemoneydebittransactionAmount": 1.87382823746E7,
                    "mobilemoneydebittransactionNumber": 0,
                    "monthlyBalance": 2205.0,
                    "monthlydebittransactionsAmount": 295.6677,
                    "outgoinginttransactiondebitAmount": 9.561730814,
                    "outgoinginttrndebitNumber": 0,
                    "outgoinglocaltransactiondebitAmount": 56.03,
                    "outgoinglocaltransactiondebitNumber": 0,
                    "overdraftLimit": 7.0,
                    "overthecounterwithdrawalsAmount": 3.72849038239E8,
                    "overthecounterwithdrawalsNumber": 546382904,
                    "transactionValue": 51.0,
                    "updatedAt": 687774305000
                    }
                    ]""";

            ObjectMapper objectMapper = new ObjectMapper();


            List<TransactionData> transactions = objectMapper.readValue(json, new TypeReference<>() {});
            transactionResponse.setStatus("successful");
            transactionResponse.setMessage("Successfully obtained transactions data");
            transactionResponse.setData(transactions);
            log.info("Successfully processed request to obtain customer transactions {}", transactionResponse);

            return transactionResponse;
        } catch (Exception e) {
            log.error("An error occurred while obtaining customer transactions: {}", e.getMessage());
            transactionResponse.setStatus("failed");
            transactionResponse.setMessage("An error occurred while obtaining customer transactions");
            transactionResponse.setData(null);
            return transactionResponse;

        }
    }
}
