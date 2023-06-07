package com.example.eticketrailwaysuz.domain.entity;

import com.example.eticketrailwaysuz.domain.enums.CityName;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tickets")
public class TicketEntity extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatEntity seats;

    @Column(name = "travel_price")
    private Double travelPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "city_from")
    private CityName cityFrom;

    @Column(name = "city_from_number")
    private int cityFromNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "city_to")
    private CityName cityTo;

    @Column(name = "city_to_number")
    private int cityToNumber;

    @Column(name = "travel_duration")
    private String travelDuration;

    @Column(name = "date_begin")
    private LocalDateTime dateBegin;

    @Column(name = "date_end")
    private LocalDateTime dateEnd;
}
