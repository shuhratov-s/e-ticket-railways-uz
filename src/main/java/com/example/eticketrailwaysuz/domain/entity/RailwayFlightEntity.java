package com.example.eticketrailwaysuz.domain.entity;

import com.example.eticketrailwaysuz.domain.entity.TrainCarriageEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "railways")
public class RailwayFlightEntity extends BaseEntity {
    @Column(name = "railway_flight_name")
    private String railwayFlightName;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @OneToMany(mappedBy = "railways")
    private List<TravelEntity> travels;

    @OneToMany(mappedBy = "railways")
    private List<TrainCarriageEntity> trainCarriages;
}
