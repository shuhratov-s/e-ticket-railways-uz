package com.example.eticketrailwaysuz.domain.dto.request;

import com.example.eticketrailwaysuz.domain.enums.CityName;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SearchingPostRequest {

    private CityName cityFrom;

    private CityName cityTo;

    private LocalDate localDate;
}
