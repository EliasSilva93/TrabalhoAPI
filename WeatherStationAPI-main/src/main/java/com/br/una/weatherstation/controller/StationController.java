package com.br.una.weatherstation.controller;

import com.br.una.weatherstation.dto.StationRequestDTO;
import com.br.una.weatherstation.dto.StationResponseDTO;
import com.br.una.weatherstation.service.StationService;
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
@RequestMapping(value = "/v1/estacoes")
public class StationController {

    private final StationService stationService;

    @GetMapping
    public ResponseEntity<Page<StationResponseDTO>> findAll(Pageable pageable) {

        Page<StationResponseDTO> stations = stationService.findAll(pageable);

        return ResponseEntity.ok().body(stations);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StationResponseDTO> findById(@PathVariable Long id) {

        StationResponseDTO stationDTO = stationService.findById(id);

        return ResponseEntity.ok().body(stationDTO);
    }

    @PostMapping
    public ResponseEntity<StationResponseDTO> save(@RequestBody @Valid StationRequestDTO stationDTO, UriComponentsBuilder uriBuilder) {

        System.out.println("------------------------------------------"+stationDTO.getUf());

        StationResponseDTO stationResponseDTO = stationService.save(stationDTO);

        URI uri = uriBuilder.path("/v1/estacoes/{id}").buildAndExpand(stationResponseDTO.getStationId()).toUri();

        return ResponseEntity.created(uri).body(stationResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StationResponseDTO> update(@RequestBody StationRequestDTO stationDTO , @PathVariable Long id) {

        StationResponseDTO stationResponseDTO = stationService.update(stationDTO , id);

        return ResponseEntity.ok().body(stationResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        String message = stationService.delete(id);

        return ResponseEntity.ok().body(message);
    }
}
