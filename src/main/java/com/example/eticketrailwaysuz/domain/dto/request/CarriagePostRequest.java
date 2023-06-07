package com.example.eticketrailwaysuz.domain.dto.request;

import com.example.eticketrailwaysuz.domain.enums.CarriageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarriagePostRequest {

    private CarriageType carriageType;

    private UUID railwayId;
}
