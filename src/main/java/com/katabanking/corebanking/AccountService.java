package com.katabanking.corebanking;

import com.katabanking.corebanking.domain.Account;
import com.katabanking.corebanking.domain.Transaction;

import java.util.List;

public interface AccountService {


    Account deposit(String amount);

    Account withdraw(String amount);

    List<Transaction> getAccountHistory();

}
