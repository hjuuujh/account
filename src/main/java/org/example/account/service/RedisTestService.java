package org.example.account.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisTestService {
    private final RedissonClient redissonClient; // 이름이 같으면 Bean 자동 주입

    public String getLock(){
        RLock lock = redissonClient.getLock("sampleLock");

        try {
            boolean isLock = lock.tryLock(1, 5, TimeUnit.SECONDS);
            if(!isLock){
                log.error("===Lock acquisition failed===");
                return "Lock failed";
            }
        }catch (Exception e){
            log.error("Redis lock failed");
        }

        return "get lock success";
    }
}
