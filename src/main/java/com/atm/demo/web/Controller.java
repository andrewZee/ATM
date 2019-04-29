package com.atm.demo.web;

import com.atm.demo.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class Controller {

    @Autowired
    private ResponseService responseService;

    @RequestMapping(value = "/balance/{accountId}", method = RequestMethod.GET)
    public String getBalance(@PathVariable("accountId") String accountId) {
        return responseService.displayBalance(accountId);
    }

    @RequestMapping(value = "/deposit/{accountId}/{amount}", method = RequestMethod.GET)
    public String doDeposit(@PathVariable("accountId") String accountId,
                            @PathVariable("amount") BigDecimal amount) {
            return responseService.doDeposit(accountId, amount);
    }

    @RequestMapping(value = "/withdrawal/{accountId}/{amount}", method = RequestMethod.GET)
    public String doWithdrawal(@PathVariable("accountId") String accountId,
                               @PathVariable("amount") BigDecimal amount) {
        return responseService.doWithdrawal(accountId, amount);
    }

    @RequestMapping(value = "/transfer/{accountIdFrom}/{accountIdTo}/{amount}", method = RequestMethod.GET)
    public String doTransfer(@PathVariable("accountIdFrom") String accountIdFrom,
                             @PathVariable("accountIdTo") String accountIdTo,
                             @PathVariable("amount") BigDecimal amount) {
        return responseService.doTransfer(accountIdFrom, accountIdTo, amount);
    }

}
