package com.atm.demo.service;

import com.atm.demo.domain.Account;
import com.atm.demo.domain.AccountNotFoundException;

import java.math.BigDecimal;

public interface AccountService {

    Account getAccount(String accountId) throws AccountNotFoundException;

    void deposit(String accountId, BigDecimal amount) throws AccountNotFoundException;

    void withdrawal(String accountId, BigDecimal amount) throws AccountNotFoundException;

    void transfer(String accountIdOrigin, String accountIdRemote, BigDecimal amount) throws AccountNotFoundException;

}
