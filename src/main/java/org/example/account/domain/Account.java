package org.example.account.domain;

import lombok.*;
import org.example.account.exception.AccountException;
import org.example.account.type.AccountStatus;
import org.example.account.type.ErrorCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AccountUser accountUser;

    private String accountNumber;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    @Enumerated(EnumType.STRING) // 없으면 0,1,2 값으로 저장되어 실제 값을 알기 어려움
    private AccountStatus accountStatus;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;


    public void useBalance(Long amount){
        if(amount > balance){
            throw  new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
        }

        balance -= amount;
    }

    public void cancelBalance(Long amount){
        if(amount < 0){
            throw  new AccountException(ErrorCode.INVALID_REQUEST);
        }

        balance += amount;
    }

}
