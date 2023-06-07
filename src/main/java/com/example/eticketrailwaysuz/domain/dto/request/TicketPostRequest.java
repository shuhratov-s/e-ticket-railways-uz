package com.example.eticketrailwaysuz.domain.dto.request;

import com.example.eticketrailwaysuz.domain.enums.CityName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketPostRequest {

    private CityName cityFrom;

    private CityName cityTo;

    private LocalDate localDate;

    private UUID cardId;

    private UUID seatId;

    private Double travelPrice;
}
