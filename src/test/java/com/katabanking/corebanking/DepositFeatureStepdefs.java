package com.katabanking.corebanking;


import com.katabanking.corebanking.domain.Account;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;


public class DepositFeatureStepdefs {

    Account account;
    int accountBalanceBeforeDeposit;
    @Given("a bank client Account")
    public void a_bank_client_Account() {
        account=new Account();
        accountBalanceBeforeDeposit=account.getBalance();

    }

    @When("the client ask to deposit (.*)")
    public void the_client_ask_to_deposit_Money(String amount) {
        account.deposit(amount);
    }

    @Then("the Account is credited with the given (.*) of Money")
    public void the_Account_is_credited_with_the_given_amount_of_Money(String amount) {
        int i=Integer.valueOf(amount);
        assertEquals(i,account.getBalance()-accountBalanceBeforeDeposit);

    }

}
