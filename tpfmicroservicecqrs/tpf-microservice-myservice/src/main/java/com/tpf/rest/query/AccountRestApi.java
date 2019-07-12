package com.tpf.rest.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tpf.entity.AccountEntity;

import java.util.concurrent.CompletableFuture;

@RequestMapping(value = "/accounts")
public interface AccountRestApi {
    @GetMapping
    CompletableFuture<Page<AccountEntity>> findAll(Pageable pageable);

    @GetMapping(path = "{id}")
    CompletableFuture<AccountEntity> findById(@PathVariable("id") String id);
    
    @RequestMapping(value = "/doLogin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    CompletableFuture<AccountEntity> findByUsernameAndPassword(@RequestParam String username, @RequestParam String password);
}
