package com.katabanking.corebanking;

import com.katabanking.corebanking.domain.Transaction;

import java.util.List;

public interface CoreBankingController {

    int deposit(String amount);

    List<Transaction> getHistory();
}
