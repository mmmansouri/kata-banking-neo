package com.katabanking.corebanking.bootstrap;

import com.katabanking.corebanking.domain.Account;
import com.katabanking.corebanking.domain.Transaction;
import com.katabanking.corebanking.domain.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private GenericWebApplicationContext context;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Account account=initData();
        context.registerBean(Account.class,()->account);
    }

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

        return  account;
    }

}
