package com.example.eticketrailwaysuz.domain.dto.response;

import com.example.eticketrailwaysuz.domain.dto.request.SearchingPostRequest;
import com.example.eticketrailwaysuz.domain.entity.SeatEntity;
import com.example.eticketrailwaysuz.domain.enums.CarriageType;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarriageSearchGetResponse {

    private SearchingPostRequest searchingInfo;

    private int carriageNumber;

    private CarriageType carriageType;

    private List<SeatEntity> seats;

    private Double travelPrice;

    private UUID railwayId;
}
