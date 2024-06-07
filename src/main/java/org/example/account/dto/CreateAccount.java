package org.example.account.dto;

import lombok.*;

import java.time.LocalDateTime;

public class CreatedAccount {

    @Getter
    @Setter
    public static class Reuest {
        private Long userId;
        private Long initialBalance;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long userId;
        private String accountNumber;
        private LocalDateTime registeredAt;
    }
}
