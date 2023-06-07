package com.example.eticketrailwaysuz.dao;

import com.example.eticketrailwaysuz.domain.entity.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TravelDao extends JpaRepository<TravelEntity, UUID> {
    Optional<LinkedList<TravelEntity>> findTravelEntitiesByRailwaysIdOrderByCreated(UUID railwayId);
}
