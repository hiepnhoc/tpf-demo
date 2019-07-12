package com.tpf.rest.command;

import org.springframework.web.bind.annotation.*;

import com.tpf.aggregate.AccountOwner;

import java.util.concurrent.CompletableFuture;

@RequestMapping(value = "/accounts")
public interface AccountCommandApi {
    @PostMapping
    CompletableFuture<String> createAccount(@RequestBody AccountOwner user);

    @PostMapping(path = "{accountId}/balance")
    CompletableFuture deposit(@PathVariable("accountId") String accountId, @RequestBody double amount);

    @DeleteMapping(path = "{accountId}")
    CompletableFuture delete(@PathVariable("accountId") String accountId);
}
