package com.example.eticketrailwaysuz.domain.dto.response;

import com.example.eticketrailwaysuz.domain.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CardGetResponse {
    private UUID id;

    private LocalDateTime created;

    private LocalDateTime updated;

    private boolean isDeleted;

    private String cardNumber;

    private double balance;

    private UserEntity users;
}
