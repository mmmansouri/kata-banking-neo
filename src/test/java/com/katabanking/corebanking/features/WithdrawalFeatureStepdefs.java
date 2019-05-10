package com.katabanking.corebanking.features;


import com.katabanking.corebanking.domain.Account;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;


public class WithdrawalFeatureStepdefs {

    Account account;
    int accountBalanceBeforeWithdrawal;
    int accountOperationsBeforeWithdrawal;

    @Given("a bank client Account to withdraw")
    public void a_bank_client_Account() {
        account=new Account();
        accountBalanceBeforeWithdrawal =account.getBalance();
        accountOperationsBeforeWithdrawal =account.getOperations().size();

    }

    @When("the client ask to withdraw (.*)")
    public void the_client_ask_to_withdraw_Money(String amount) {
        account.withdrawal(amount);
    }

    @Then("the Account is debited with the given (.*) of Money")
    public void the_Account_is_debited_with_the_given_amount_of_Money(String amount) {
        int iAmount=Integer.valueOf(amount);
        assertEquals(accountOperationsBeforeWithdrawal,account.getOperations().size()-1);
        assertEquals(iAmount,accountBalanceBeforeWithdrawal-account.getBalance());

    }

}
