package com.tpf.events.account;

import com.tpf.events.AbstractEvent;

public class MoneyDepositedEvent extends AbstractEvent {
    private final double amount;

    public MoneyDepositedEvent(String id, double amount) {
        super(id);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
