package com.atm.demo.domain;

import java.math.BigDecimal;

public class Account {

    private String id;
    private BigDecimal amount;

    public Account (String id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
