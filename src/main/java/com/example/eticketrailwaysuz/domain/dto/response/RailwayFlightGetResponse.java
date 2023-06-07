package com.example.eticketrailwaysuz.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RailwayFlightGetResponse {

    private UUID id;

    private LocalDateTime created;

    private LocalDateTime updated;

    private boolean isDeleted;

    private String railwayFlightName;

    private LocalDate expirationDate;
}
