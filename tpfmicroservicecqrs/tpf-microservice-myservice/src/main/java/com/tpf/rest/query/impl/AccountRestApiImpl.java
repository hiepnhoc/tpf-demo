package com.tpf.rest.query.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tpf.entity.AccountEntity;
import com.tpf.repository.AccountEntityRepository;
import com.tpf.rest.query.AccountRestApi;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
public class AccountRestApiImpl implements AccountRestApi {
    private final AccountEntityRepository repository;

    public AccountRestApiImpl(AccountEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public CompletableFuture<Page<AccountEntity>> findAll(Pageable pageable) {
        try {
            return CompletableFuture.supplyAsync(() -> repository.findAll(pageable));
        } catch (AssertionError | IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public CompletableFuture<AccountEntity> findById(String id) {
        try {
            Assert.hasLength(id, "Missing account id");
            return CompletableFuture.supplyAsync(() -> {
                AccountEntity entity = repository.findOne(id);
                if (Optional.ofNullable(entity).isPresent()) {
                    return entity;
                } else {
                    throw new AccountEntityNotFoundException(id);
                }
            });
        } catch (AssertionError | IllegalArgumentException e) {
            throw e;
        }
    }

    @ExceptionHandler({
            AssertionError.class,
            IllegalArgumentException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handle(HttpServletRequest request, Throwable e) {
        String badRequestContent = String.format("Request api call {} is bad request", request.getRequestURL());
        return ResponseEntity.badRequest().body(badRequestContent);
    }

    @ExceptionHandler(AccountEntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFound(){}

    @SuppressWarnings("serial")
	private class AccountEntityNotFoundException extends RuntimeException {
        public AccountEntityNotFoundException(String id) {
            super(String.format("Account %s not found", id));
        }
        
		public AccountEntityNotFoundException(String username, String password) {
            super(String.format("Account username : %s not found", username));
        }
    }

	@Override
	public CompletableFuture<AccountEntity> findByUsernameAndPassword(String username, String password) {
		try {
            Assert.hasLength(username, "Missing account username");
            Assert.hasLength(password, "Missing account password");
            return CompletableFuture.supplyAsync(() -> {
                AccountEntity entity = repository.findOneByUserNameAndPassword(username, password);
                if (Optional.ofNullable(entity).isPresent()) {
                    return entity;
                } else {
                    throw new AccountEntityNotFoundException(username);
                }
            });
        } catch (AssertionError | IllegalArgumentException e) {
            throw e;
        }
	}
	
}
