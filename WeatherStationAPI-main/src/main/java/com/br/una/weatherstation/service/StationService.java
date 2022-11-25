package com.br.una.weatherstation.service;

import com.br.una.weatherstation.dto.StationRequestDTO;
import com.br.una.weatherstation.dto.StationResponseDTO;
import com.br.una.weatherstation.entity.Station;
import com.br.una.weatherstation.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;

    public Page<StationResponseDTO> findAll(Pageable pageable) {
        return stationRepository.findAll(pageable).map(StationResponseDTO::new);
    }

    public StationResponseDTO findById(Long id) {

        Station station = returnStationById(id);

        return new StationResponseDTO(station);
    }

    public StationResponseDTO save(StationRequestDTO stationDTO) {

        Station station = convertFromDTOToEntity(stationDTO);

        station = stationRepository.save(station);

        return new StationResponseDTO(station);
    }

    public StationResponseDTO update(StationRequestDTO stationDTO , Long id) {

        Station station = returnStationById(id);

        updateStation(station, stationDTO);

        station = stationRepository.save(station);

        return new StationResponseDTO(station);
    }

    public String delete(Long id) {

        stationRepository.deleteById(id);

        return "Station with id: "+id+" was deleted";
    }

    private Station returnStationById(Long id) {
        return  stationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Resource id: "+id+" not found!"));
    }

    private Station convertFromDTOToEntity(StationRequestDTO stationDTO) {
        Station station = new Station();
        station.setStationName(stationDTO.getStationName());
        station.setHeight(stationDTO.getHeight());
        station.setLatitude(stationDTO.getLatitude());
        station.setLongitude(stationDTO.getLongitude());
        station.setFoundationDate(stationDTO.getFoundationDate());
        station.setUF(stationDTO.getUf());
        station.setRegionCode(stationDTO.getRegionCode());
        station.setWmoCode(stationDTO.getWmoCode());

        return station;
    }

    private void updateStation(Station station, StationRequestDTO stationDTO) {

        if(stationDTO.getHeight()!=null) {
            station.setHeight(stationDTO.getHeight());
        }

        if (stationDTO.getStationName() != null) {
            station.setStationName(stationDTO.getStationName());
       }

        if(stationDTO.getLatitude()!=null) {
            station.setLatitude(stationDTO.getLatitude());
        }

        if(stationDTO.getLongitude()!=null) {
            station.setLongitude(stationDTO.getLongitude());
        }

        if(stationDTO.getUf()!=null) {
            station.setUF(stationDTO.getUf());
        }

        if(stationDTO.getRegionCode()!=null) {
            station.setRegionCode(stationDTO.getRegionCode());
        }

        if(stationDTO.getWmoCode()!=null) {
            station.setWmoCode(stationDTO.getWmoCode());
        }

    }


}
