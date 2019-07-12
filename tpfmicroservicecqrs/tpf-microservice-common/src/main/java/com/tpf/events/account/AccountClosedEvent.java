package com.tpf.events.account;

import com.tpf.events.AbstractEvent;

public class AccountClosedEvent extends AbstractEvent {
    public AccountClosedEvent(String id) {
        super(id);
    }
}
