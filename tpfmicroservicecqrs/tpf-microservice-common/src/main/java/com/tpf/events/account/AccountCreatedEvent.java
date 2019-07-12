package com.tpf.events.account;

import com.tpf.events.AbstractEvent;

public class AccountCreatedEvent extends AbstractEvent {
    private final String accountCreator;
    private final double balance;
    private final String username;
    private final String password;

    public AccountCreatedEvent(String id, String accountCreator, double balance, String username, String password) {
        super(id);
        this.accountCreator = accountCreator;
        this.balance = balance;
        this.username = username;
        this.password = password;
    }

    public String getAccountCreator() {
        return accountCreator;
    }

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
    public String toString() {
        return "AccountCreatedEvent{" +
                "id='" + super.getId() + '\'' +
                ", accountCreator='" + accountCreator + '\'' +
                ", balance=" + balance +
                '}';
    }
}
