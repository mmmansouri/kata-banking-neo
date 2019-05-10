package com.katabanking.corebanking;

import com.katabanking.corebanking.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoreBankingControllerImpl implements CoreBankingController {


    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.POST,path="/deposit")
    public int deposit(@RequestBody String amount) {
        return accountService.deposit(amount).getBalance();
    }

    @RequestMapping(method = RequestMethod.POST,path="/withdraw")
    public int withdraw(@RequestBody String amount) {
        return accountService.withdraw(amount).getBalance();
    }

    @RequestMapping(method = RequestMethod.GET,path="/history")
    public List<Transaction> getHistory() {
        return accountService.getAccountHistory();
    }
}
