package com.atm.demo.service;

import com.atm.demo.dao.Dao;
import com.atm.demo.domain.Account;
import com.atm.demo.domain.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private static final String ACCOUNT_NOT_FOUND = "Account not found";

    @Autowired
    private Dao dao;

    @Override
    public Account getAccount(String accountId) {
        return dao.getAccount(accountId);
    }

    @Override
    public void deposit(String accountId, BigDecimal amount) throws AccountNotFoundException {
        final Account account = dao.getAccount(accountId);

        if (account == null) {
            throw new AccountNotFoundException(ACCOUNT_NOT_FOUND);
        }

        account.setAmount(account.getAmount().add(amount));

    }

    @Override
    public void withdrawal(String accountId, BigDecimal amount) throws AccountNotFoundException {
        final Account account = dao.getAccount(accountId);

        if (account == null) {
            throw new AccountNotFoundException(ACCOUNT_NOT_FOUND);
        }

        account.setAmount(account.getAmount().subtract(amount));
    }

    @Override
    public void transfer(String accountIdFrom, String accountIdTo, BigDecimal amount) throws AccountNotFoundException {
        final Account accountOrigin = dao.getAccount(accountIdFrom);
        final Account accountRemote = dao.getAccount(accountIdTo);

        if (accountOrigin == null) {
            throw new AccountNotFoundException(ACCOUNT_NOT_FOUND + " (origin)");
        } else if (accountRemote == null) {
            throw new AccountNotFoundException(ACCOUNT_NOT_FOUND + " (remote)");
        }

        accountOrigin.setAmount(accountOrigin.getAmount().subtract(amount));
        accountRemote.setAmount(accountOrigin.getAmount().add(amount));
    }

}
