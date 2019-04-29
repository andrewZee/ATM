package com.atm.demo.service;

import com.atm.demo.domain.Account;
import com.atm.demo.domain.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private AccountService accountService;

    @Override
    public String displayBalance(String accountId) {
        String response;
        try {
            Account account = accountService.getAccount(accountId);
            response = "Balance for account " + account.getId() + " is " + account.getAmount();
        } catch (AccountNotFoundException e) {
            response = e.getMessage();
        }

        return response;
    }

    @Override
    public String doDeposit(String accountId, BigDecimal amount) {
        String response;

        try {
            accountService.deposit(accountId, amount);
            response = "Deposit operation successfully completed for account " + accountId;
        } catch (AccountNotFoundException e) {
            response = e.getMessage();
        }

        return response;
    }

    @Override
    public String doWithdrawal(String accountId, BigDecimal amount) {
        String response;

        try {
            accountService.withdrawal(accountId, amount);
            response = "Withdrawal operation successfully completed for account " + accountId;
        } catch (AccountNotFoundException e) {
            response = e.getMessage();
        }

        return response;
    }

    @Override
    public String doTransfer(String accountIdOrigin, String accountIdRemote, BigDecimal amount) {
        String response;

        try {
            accountService.transfer(accountIdOrigin, accountIdRemote, amount);
            response = "Transfer operation successfully completed for accounts " +
                    accountIdOrigin + " -> " + accountIdRemote;
        } catch (AccountNotFoundException e) {
            response = e.getMessage();
        }

        return response;
    }
}
