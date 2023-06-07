package com.example.eticketrailwaysuz.domain.entity;

import com.example.eticketrailwaysuz.domain.entity.CardEntity;
import com.example.eticketrailwaysuz.domain.entity.TicketEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "users")
public class UserEntity extends BaseEntity {

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "users")
    private List<CardEntity> cards;

    @OneToMany(mappedBy = "users")
    private List<TicketEntity> tickets;

}