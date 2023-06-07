package com.example.eticketrailwaysuz.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "cards")
public class CardEntity extends BaseEntity{

    private String cardNumber;

    private double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;

}
