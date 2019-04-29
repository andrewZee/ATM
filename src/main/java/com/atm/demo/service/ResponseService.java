package com.atm.demo.service;


import java.math.BigDecimal;

public interface ResponseService {

    String displayBalance(String accountId);

    String doDeposit(String accountId, BigDecimal amount);

    String doWithdrawal(String accountId, BigDecimal amount);

    String doTransfer(String accountIdOrigin, String accountIdRemote, BigDecimal amount);

}
