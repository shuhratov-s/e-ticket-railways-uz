package com.example.eticketrailwaysuz.dao;

import com.example.eticketrailwaysuz.domain.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SeatDao extends JpaRepository<SeatEntity, UUID> {
    Optional<List<SeatEntity>> findSeatEntitiesByCarriagesId(UUID carriageId);
}
