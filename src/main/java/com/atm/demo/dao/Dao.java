package com.atm.demo.dao;

import com.atm.demo.domain.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Dao {

    private static Map<String, Account> accounts;

    public Account getAccount(String id) {

        return accounts.get(id);
    }

    public static void createAccounts() {
        accounts = new HashMap<>();
        accounts.put("AB123", new Account("AB123", BigDecimal.valueOf(100L)));
        accounts.put("CD456", new Account("CD456", BigDecimal.valueOf(200L)));
        accounts.put("EF789", new Account("EF789", BigDecimal.valueOf(300L)));
    }

}
