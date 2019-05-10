package com.katabanking.corebanking;

import com.katabanking.corebanking.domain.Account;
import com.katabanking.corebanking.domain.Transaction;
import javafx.beans.NamedArg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.util.List;

@Component
public class AccountServiceImpl implements  AccountService {


    @Autowired
    private GenericWebApplicationContext context;

    @Override
    public Account deposit(String amout) {

        Account account=context.getBean(Account.class);
        account.deposit(amout);
        return account;
    }

    @Override
    public Account withdraw(String amount) {
        Account account=context.getBean(Account.class);
        account.withdrawal(amount);
        return account;
    }

    @Override
    public List<Transaction> getAccountHistory() {
        return context.getBean(Account.class).getOperations();
    }
}
