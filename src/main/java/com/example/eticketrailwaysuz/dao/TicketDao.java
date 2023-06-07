package com.example.eticketrailwaysuz.dao;

import com.example.eticketrailwaysuz.domain.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketDao extends JpaRepository<TicketEntity, UUID> {
    Optional<List<TicketEntity>> findTicketEntitiesByUsersId(UUID userId);
    Optional<List<TicketEntity>> findTicketEntitiesBySeatsId(UUID seatId);
}
