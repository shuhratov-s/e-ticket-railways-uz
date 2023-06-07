package com.example.eticketrailwaysuz.domain.dto.response;

import com.example.eticketrailwaysuz.domain.entity.RailwayFlightEntity;
import com.example.eticketrailwaysuz.domain.entity.SeatEntity;
import com.example.eticketrailwaysuz.domain.enums.CarriageType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarriageGetResponse {

    private UUID id;

    private LocalDateTime created;

    private LocalDateTime updated;

    private boolean isDeleted;

    private int carriageNumber;

    private CarriageType carriageType;

    private RailwayFlightEntity railways;

    private List<SeatEntity> seats;
}
