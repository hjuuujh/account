package org.example.account.controller;

import lombok.RequiredArgsConstructor;
import org.example.account.domain.Account;
import org.example.account.dto.AccountDto;
import org.example.account.dto.CreateAccount;
import org.example.account.dto.DeleteAccount;
import org.example.account.repository.AccountRepository;
import org.example.account.service.AccountService;
import org.example.account.service.RedisTestService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {
    // 외부에서 컨트롤러로 접속 -> 컨트롤러는 서비스로 -> 서비스는 레포지토리로 접속 : layer 구조
    private final AccountService accountService;
    private final RedisTestService redisTestService;

    @PostMapping("/account")
    public CreateAccount.Response createAccount(@RequestBody @Valid CreateAccount.Request request) {
        return CreateAccount.Response.from(accountService.createAccount(request.getUserId(), request.getInitialBalance()));
    }

    @DeleteMapping("/account")
    public DeleteAccount.Response deleteAccount(@RequestBody @Valid DeleteAccount.Request request) {
        return DeleteAccount.Response.from(accountService.deleteAccount(request.getUserId(), request.getAccountNumber()));
    }

    @GetMapping("/get-lock")
    public String getLock() {
        return redisTestService.getLock();
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}
