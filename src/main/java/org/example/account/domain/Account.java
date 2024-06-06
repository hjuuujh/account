package org.example.account.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String accountNumber;

    @Enumerated(EnumType.STRING) // 없으면 0,1,2 값으로 저장되어 실제 값을 알기 어려움
    private AccountStatus accountStatus;
}
