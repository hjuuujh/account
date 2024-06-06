package org.example.account.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.example.account.domain.Account;
import org.example.account.domain.AccountStatus;
import org.example.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
    //    @Autowired : 예전에는 맍이썼지만 테스트할 때 의존성 담아주기 어려워서 생성자 삽입을 사용
//    => @RequiredArgsConstructor사용 : final type 만 있는 생성자 만들어줌
    private final AccountRepository accountRepository;

    @Transactional
    public void createAccount() {
        Account account = Account.builder()
                .accountNumber("40000")
                .accountStatus(AccountStatus.IN_USE)
                .build();
        accountRepository.save(account);
    }

    @Transactional
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

}
