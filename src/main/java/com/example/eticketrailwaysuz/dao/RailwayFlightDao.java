package com.example.eticketrailwaysuz.dao;

import com.example.eticketrailwaysuz.domain.entity.RailwayFlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RailwayFlightDao extends JpaRepository<RailwayFlightEntity, UUID> {
    boolean existsRailwayFlightEntityByRailwayFlightName(String name);

}
