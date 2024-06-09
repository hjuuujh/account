package org.example.account.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.account.exception.AccountException;
import org.example.account.type.ErrorCode;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class LockService {
    private final RedissonClient redissonClient; // 이름이 같으면 Bean 자동 주입

    public void lock(String accountNumber) {
        RLock lock = redissonClient.getLock(getLockKey(accountNumber));
        log.debug("Trying lock for accountNumber : {}", accountNumber);

        try {
            boolean isLock = lock.tryLock(1, 5, TimeUnit.SECONDS);
            if (!isLock) {
                log.error("===Lock acquisition failed===");
                throw new AccountException(ErrorCode.ACCOUNT_NOT_FOUND);
            }
        } catch (AccountException e) {
            throw e;
        } catch (Exception e) {
            log.error("Redis lock failed", e);
        }

    }

    public void unlock(String accountNumber) {
        log.debug("Unlockfor accountNumber : {}", accountNumber);
        redissonClient.getLock(getLockKey(accountNumber)).unlock();

    }

    private static String getLockKey(String accountNumber) {
        return "ACLK" + accountNumber;
    }
}
