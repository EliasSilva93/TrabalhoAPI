package com.br.una.weatherstation.config;

import com.br.una.weatherstation.entity.Station;
import com.br.una.weatherstation.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//@Configuration
public class ExtraConfig implements CommandLineRunner {

    @Autowired
    private StationRepository stationRepository;

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(new Locale("pt", "BR"));


        String path = "D:\\eclipse\\spring\\Estacoes.csv";

        List<Station> stations = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();


            while(line!=null) {

                    String split[] = line.split(";");

                    String stationName = split[0];
                    String UF = split[1];
                    String regionCode = split[2];
                    String latitudeString = split[3];
                    String longitudeString = split[4];
                    String heightString = split[5];

                    latitudeString = latitudeString.replaceAll(",", ".");
                    longitudeString = longitudeString.replaceAll(",",".");
                    heightString = heightString.replaceAll("," , ".");

                    double latitude = Double.parseDouble(latitudeString);
                    double longitude = Double.parseDouble(longitudeString);
                    double height = Double.parseDouble(heightString);

                    String foundantionDate = split[6];
                    String wmoCode = split[7];

                    Station station = new Station();
                    station.setWmoCode(wmoCode);
                    station.setStationName(stationName);
                    station.setRegionCode(regionCode);
                    station.setUF(UF);
                    station.setLongitude(longitude);
                    station.setLatitude(latitude);
                    station.setHeight(height);
                    station.setFoundationDate(foundantionDate);

                    stations.add(station);

                    line = br.readLine();

                }


        }

        stationRepository.saveAll(stations);

    }
}
