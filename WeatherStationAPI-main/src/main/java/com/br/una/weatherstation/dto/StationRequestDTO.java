package com.br.una.weatherstation.dto;

import com.br.una.weatherstation.entity.Station;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class StationRequestDTO {

    @NotNull
    private String stationName;

    @NotNull
    private String regionCode;

    @NotNull
    private String uf;

    @NotNull
    private String wmoCode;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    private Double height;

    @NotNull
    private String foundationDate;

    public StationRequestDTO(Station station) {
        this.stationName = station.getStationName();
        this.regionCode = station.getRegionCode();
        this.uf = station.getUF();
        this.wmoCode = station.getWmoCode();
        this.latitude = station.getLatitude();
        this.longitude = station.getLongitude();
        this.height = station.getHeight();
        this.foundationDate = station.getFoundationDate();
    }

}
