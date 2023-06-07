package com.example.eticketrailwaysuz.domain.dto.response;

import com.example.eticketrailwaysuz.domain.entity.SeatEntity;
import com.example.eticketrailwaysuz.domain.enums.CityName;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TicketGetResponse {

    private SeatEntity seats;

    private CityName cityFrom;

    private CityName cityTo;

    private Double travelPrice;

    private String travelDuration;

    private LocalDateTime dateBegin;

    private LocalDateTime dateEnd;
}
