package com.br.una.airport.controller;

import com.br.una.airport.dto.AirportResponseDTO;
import com.br.una.airport.dto.AirportRequestDTO;
import com.br.una.airport.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/aeroportos")
public class AirportController {

   private final AirportService airportService;

   @GetMapping
   public ResponseEntity<Page<AirportResponseDTO>> findAll(Pageable pageable) {

       Page<AirportResponseDTO> airports = airportService.findAll(pageable);

       return ResponseEntity.ok().body(airports);
   }

   @GetMapping(value = "/{iata}")
    public ResponseEntity<AirportResponseDTO> findByIataCode(@PathVariable String iata) {

       AirportResponseDTO airportDTO = airportService.findByIataCode(iata);

       return ResponseEntity.ok().body(airportDTO);
   }

    @PostMapping
    public ResponseEntity<AirportResponseDTO> save(@RequestBody @Valid AirportRequestDTO airportDTO, UriComponentsBuilder uriBuilder) {

       AirportResponseDTO airportResponseDTO = airportService.save(airportDTO);

        URI uri = uriBuilder.path("/v1/aeroportos/{iata}").buildAndExpand(airportResponseDTO.getAirportId()).toUri();

        return ResponseEntity.created(uri).body(airportResponseDTO);
    }

    @PutMapping(value = "/{iata}")
    public ResponseEntity<AirportResponseDTO> update(@RequestBody AirportRequestDTO airportDTO, @PathVariable String iata) {

       AirportResponseDTO airportResponseDTO = airportService.update(airportDTO, iata);

       return ResponseEntity.ok().body(airportResponseDTO);
    }

    @DeleteMapping(value = "/{iata}")
    public ResponseEntity<String> delete(@PathVariable String iata) {

       String message = airportService.delete(iata);

       return ResponseEntity.ok().body(message);
    }

}
