package com.example.eticketrailwaysuz.service;

import com.example.eticketrailwaysuz.dao.RailwayFlightDao;
import com.example.eticketrailwaysuz.dao.TrainCarriageDao;
import com.example.eticketrailwaysuz.dao.TravelDao;
import com.example.eticketrailwaysuz.domain.dto.BaseResponse;
import com.example.eticketrailwaysuz.domain.dto.request.CarriagePostRequest;
import com.example.eticketrailwaysuz.domain.dto.request.SearchingPostRequest;
import com.example.eticketrailwaysuz.domain.dto.response.CarriageGetResponse;
import com.example.eticketrailwaysuz.domain.dto.response.CarriageSearchGetResponse;
import com.example.eticketrailwaysuz.domain.entity.TrainCarriageEntity;
import com.example.eticketrailwaysuz.domain.entity.RailwayFlightEntity;
import com.example.eticketrailwaysuz.domain.entity.SeatEntity;
import com.example.eticketrailwaysuz.domain.entity.TravelEntity;
import com.example.eticketrailwaysuz.domain.enums.CarriageType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TrainCarriageService implements BaseService<CarriagePostRequest, BaseResponse<CarriageGetResponse>> {

    private final ModelMapper modelMapper;
    private final TrainCarriageDao carriageDao;
    private final RailwayFlightDao railwayFlightDao;
    private final TravelService travelService;
    private final TravelDao travelDao;

    @Override
    public BaseResponse<CarriageGetResponse> create(CarriagePostRequest carriagePostRequest) {
        TrainCarriageEntity carriageEntity = modelMapper.map(carriagePostRequest, TrainCarriageEntity.class);

        UUID railwayId = carriagePostRequest.getRailwayId();

        RailwayFlightEntity railwayFlightEntity = railwayFlightDao.findById(railwayId).get();
        carriageEntity.setRailways(railwayFlightEntity);

        Optional<List<TrainCarriageEntity>> optionalTrainCarriageEntityList = carriageDao
                .findTrainCarriageEntitiesByRailwaysIdOrderByCreated(railwayId);
        if (optionalTrainCarriageEntityList.isEmpty()) {
            carriageEntity.setCarriageNumber(1);
        } else {
            carriageEntity.setCarriageNumber(optionalTrainCarriageEntityList.get().size() + 1);
        }

        List<SeatEntity> seatEntities = createSeatEntitiesByCarriageType(carriageEntity);
        carriageEntity.setSeats(seatEntities);


        carriageDao.save(carriageEntity);


        return BaseResponse.<CarriageGetResponse>builder()
                .status(200)
                .message(carriageEntity.getCarriageType() + " carriage type has been added")
                .data(modelMapper.map(carriageEntity, CarriageGetResponse.class))
                .build();
    }


    private List<SeatEntity> createSeatEntitiesByCarriageType(TrainCarriageEntity carriageEntity) {
        CarriageType carriageType = carriageEntity.getCarriageType();
        int amountOfSeats;
        switch (carriageType) {
            case PLASCARD -> amountOfSeats = 15;
            case KUPE -> amountOfSeats = 10;
            default -> amountOfSeats = 5;
        }
        List<SeatEntity> seatEntities = new LinkedList<>();
        for (int i = 1; i <= amountOfSeats; i++) {
            seatEntities.add(new SeatEntity(i, carriageEntity));
        }
        return seatEntities;
    }

    public BaseResponse<List<CarriageSearchGetResponse>> searchCarriages(SearchingPostRequest searchingPostRequest,
                                                                         UUID railwayId) {

        List<TrainCarriageEntity> trainCarriageEntities = carriageDao
                .findTrainCarriageEntitiesByRailwaysIdOrderByCreated(railwayId).get();

        LinkedList<TravelEntity> travelEntities = travelDao
                .findTravelEntitiesByRailwaysIdOrderByCreated(railwayId).get();


        Map<String, Object> travelInfo = travelService
                .existsRailwayFlightTravelBySearching(searchingPostRequest, travelEntities);

        List<CarriageSearchGetResponse> carriageSearchGetResponses = new LinkedList<>();

        for (TrainCarriageEntity trainCarriage : trainCarriageEntities) {
            List<SeatEntity> availableSeats = travelService.findAvailableSeats(travelInfo, trainCarriage.getId());
            if (availableSeats.size()!=0){
                carriageSearchGetResponses.add(CarriageSearchGetResponse.builder()
                                .railwayId(railwayId)
                                .searchingInfo(searchingPostRequest)
                                .carriageType(trainCarriage.getCarriageType())
                                .carriageNumber(trainCarriage.getCarriageNumber())
                                .travelPrice(getPriceByCarriageType(travelInfo, trainCarriage.getCarriageType()))
                                .seats(availableSeats)
                        .build());
            }
        }

        return BaseResponse.<List<CarriageSearchGetResponse>>builder()
                .status(200)
                .message(carriageSearchGetResponses.size() + " result(s) found")
                .data(carriageSearchGetResponses)
                .build();
    }

    private Double getPriceByCarriageType(Map<String, Object> travelInfo, CarriageType carriageType) {
        Object price;
        switch (carriageType){
            case PLASCARD -> price = travelInfo.get("plascardPrice");
            case KUPE -> price = travelInfo.get("kupePrice");
            default -> price = travelInfo.get("vipPrice");
        }
        return (Double) price;
    }

    @Override
    public BaseResponse<CarriageGetResponse> getById(UUID id) {
        return null;
    }

    @Override
    public BaseResponse<CarriageGetResponse> deleteById(UUID id) {
        return null;
    }

    public List<CarriageGetResponse> findCarriagesByRailwayFlightId(UUID railwayFlightId) {
        Optional<List<TrainCarriageEntity>> carriages = carriageDao
                .findTrainCarriageEntitiesByRailwaysIdOrderByCreated(railwayFlightId);

        if (carriages.isEmpty()){
            return Collections.emptyList();
        }
        return modelMapper.map(carriages.get(), new TypeToken<List<CarriageGetResponse>>(){}
                .getType());
    }
}
