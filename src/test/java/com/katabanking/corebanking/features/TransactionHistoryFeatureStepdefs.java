package com.katabanking.corebanking.features;


import com.katabanking.corebanking.domain.Account;
import com.katabanking.corebanking.domain.Transaction;
import com.katabanking.corebanking.domain.TransactionType;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class TransactionHistoryFeatureStepdefs {

    Account account;

    List<Transaction> transactionsHistory;


    private Account initData(){

        Account account=new Account();
        account.setBalance(100);
        List<Transaction> operations=new ArrayList<>();
        Transaction transaction1=Transaction.builder().transactionType(TransactionType.DEPOSIT).amount(10).date(new Date()).balance(110).build();
        operations.add(transaction1);
        Transaction transaction2=Transaction.builder().transactionType(TransactionType.WITHDRAWAL).amount(10).date(new Date()).balance(100).build();
        operations.add(transaction2);
        Transaction transaction3=Transaction.builder().transactionType(TransactionType.DEPOSIT).amount(10).date(new Date()).balance(110).build();
        operations.add(transaction3);
        Transaction transaction4=Transaction.builder().transactionType(TransactionType.DEPOSIT).amount(10).date(new Date()).balance(120).build();
        operations.add(transaction4);
        Transaction transaction5=Transaction.builder().transactionType(TransactionType.WITHDRAWAL).amount(10).date(new Date()).balance(110).build();
        operations.add(transaction5);

        account.setBalance(transaction5.getBalance());
        account.setOperations(operations);

        return account;
    }

    @Given("a bank client Account with transactions history")
    public void a_bank_client_Account_with_transactions_history() {
        account=initData();
    }

    @When("the client ask for account transactions history")
    public void the_client_ask_for_account_transactions_history()  {
        transactionsHistory=account.getOperations();
    }

    @Then("the Account transactions history is returned")
    public void the_Account_transactions_history_is_returned(){
        assertNotNull(transactionsHistory);
        assertFalse(transactionsHistory.isEmpty());

    }

}
