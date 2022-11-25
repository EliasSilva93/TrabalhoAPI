package com.br.una.weatherstation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_stations")
@Getter
@Setter
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacao")
    private Long stationId;

    @Column(name = "nome_estacao")
    private String stationName;

    @Column(name = "cod_regiao")
    private String regionCode;

    @Column(name = "uf")
    private String UF;

    @Column(name = "codigo_wmo")
    private String wmoCode;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "altitude")
    private Double height;

    @Column(name = "data_fundacao")
    private String foundationDate;

}
