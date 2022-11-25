package com.br.una.weatherstation.dto;

import com.br.una.weatherstation.entity.Station;
import lombok.Getter;

@Getter
public class StationResponseDTO extends StationRequestDTO {

    private Long stationId;

    public StationResponseDTO(Station station) {
        super(station);
        this.stationId = station.getStationId();
    }
}
