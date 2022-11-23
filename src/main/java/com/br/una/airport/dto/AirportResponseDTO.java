package com.br.una.airport.dto;

import com.br.una.airport.entity.Airport;
import lombok.Getter;

@Getter
public class AirportResponseDTO extends AirportRequestDTO {

    private Long airportId;

    public AirportResponseDTO(Airport airport) {
        super(airport);
        this.airportId = airport.getAirportId();
    }

}
