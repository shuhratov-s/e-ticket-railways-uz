package com.example.eticketrailwaysuz.domain.entity;

import com.example.eticketrailwaysuz.domain.enums.CarriageType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "trains")
public class TrainCarriageEntity extends BaseEntity {

    @Column(name = "carriage_number")
    private int carriageNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "carriage_type")
    private CarriageType carriageType;

    @ManyToOne
    @JoinColumn(name = "railway_id")
    private RailwayFlightEntity railways;

    @OneToMany(mappedBy = "carriages", cascade = CascadeType.ALL)
    private List<SeatEntity> seats;
}
