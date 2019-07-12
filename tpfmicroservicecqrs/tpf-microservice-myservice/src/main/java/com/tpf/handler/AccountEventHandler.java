package com.tpf.handler;

import com.tpf.entity.AccountEntity;
import com.tpf.events.account.AccountCreatedEvent;
import com.tpf.repository.AccountEntityRepository;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("accountEvents")
public class AccountEventHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final AccountEntityRepository repository;

    public AccountEventHandler(AccountEntityRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(AccountCreatedEvent event) {
        AccountEntity createdAccount = repository.save(new AccountEntity(
                event.getId(),
                event.getBalance(),
                event.getAccountCreator(),
                event.getUsername(),
                event.getPassword()));

        logger.info("Account {} is saved", createdAccount);
    }

}
