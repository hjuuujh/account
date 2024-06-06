package org.example.account.controller;

import lombok.RequiredArgsConstructor;
import org.example.account.domain.Account;
import org.example.account.repository.AccountRepository;
import org.example.account.service.AccountService;
import org.example.account.service.RedisTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    // 외부에서 컨트롤러로 접속 -> 컨트롤러는 서비스로 -> 서비스는 레포지토리로 접속 : layer 구조
    private final AccountService accountService;
    private final RedisTestService redisTestService;

    @GetMapping("/get-lock")
    public String getLock() {
        return redisTestService.getLock();
    }
    
    @GetMapping("/create-account")
    public String createAccount() {
        accountService.createAccount();
        return "Account created";
    }

    @GetMapping("/acount/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}
