package com.example.eticketrailwaysuz.domain.entity;

import com.example.eticketrailwaysuz.domain.entity.TrainCarriageEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "seats")
public class SeatEntity extends BaseEntity {

    @Column(name = "seat_number")
    private int seatNumber;

    @OneToMany(mappedBy = "seats")
    private List<TicketEntity> tickets;

    @ManyToOne
    @JoinColumn(name = "carriage_id")
    private TrainCarriageEntity carriages;

    public SeatEntity(int seatNumber, TrainCarriageEntity carriages){
        this.seatNumber = seatNumber;
        this.carriages = carriages;
    }

}
