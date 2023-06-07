package com.example.eticketrailwaysuz.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RailwayFlightPostRequest {

    private String railwayFlightName;

    private int duration;
}
