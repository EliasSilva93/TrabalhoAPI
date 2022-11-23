package com.br.una.airport.repository;

import com.br.una.airport.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findByIataCode(String iata);

    @Transactional
    @Modifying
    @Query(value = "DELETE from tb_airports where codigo_iata = :iata", nativeQuery = true)
    void deleteByIataCode(String iata); // Caso o método de cima não funcione.

}