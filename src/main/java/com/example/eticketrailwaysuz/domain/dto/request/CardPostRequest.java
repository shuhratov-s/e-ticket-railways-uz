package com.example.eticketrailwaysuz.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardPostRequest {

    private String cardNumber;

    private double balance;

    private UUID userId;
}
