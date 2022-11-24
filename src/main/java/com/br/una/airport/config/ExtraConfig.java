package com.br.una.airport.config;

import com.br.una.airport.entity.Airport;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//@Configuration
public class ExtraConfig implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

    List<Airport> airports = new ArrayList<>();

    String path = "C:\\temp\\airports.csv";

    try(BufferedReader br = new BufferedReader(new FileReader(path))) {

       String line = br.readLine();

       while(line!=null) {

           String split [] = line.split(";");

           String nomeAeroporto = split[1];
           String codigoIata = split[4];
           String city = split[2];

           //String codigoPaisIso =

           double latitude = Double.parseDouble(split[6].replace(",","."));
           double longitude = Double.parseDouble(split[7].replace(",","."));
           double altitude = Double.parseDouble(split[8].replace(",","."));

           line = br.readLine();

       }


    }


    }


}
