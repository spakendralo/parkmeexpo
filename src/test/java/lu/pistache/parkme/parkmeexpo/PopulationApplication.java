package lu.pistache.parkme.parkmeexpo;

import lu.pistache.parkme.parkmeexpo.db.ParkingRepository;
import lu.pistache.parkme.parkmeexpo.model.ParkingLot;
import lu.pistache.parkme.parkmeexpo.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

@SpringBootTest
class PopulationApplication {

    @Value("classpath:setup/austin_addresses_partial.csv")
    //@Value("classpath:setup/austin_addresses.csv")
    Resource resourceFile;

    @Autowired
    private ParkingRepository repository;


    @Test
    void getFileAndTransformToLocations() throws IOException {

        repository.deleteAll();

        try (BufferedReader br = new BufferedReader(new FileReader(resourceFile.getFile()))) {
            String line;
            Random random = new Random();
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");

                int places = getPlaces(random);
                ParkingLot parkingLot = new ParkingLot(
                        getName(split[1]),
                        places,
                        getGeoJsonPoint(split),
                        new Status(
                                getFreeSpaces(random, places),
                                getTendency(random)));
                repository.save(parkingLot);
            }
        }

    }

    private String getName(String name1) {
        String name = name1;
        name = name.split("\"")[1];
        return name;
    }

    private GeoJsonPoint getGeoJsonPoint(String[] split) {
        double latitude = Double.parseDouble(split[2]);
        double longitude = Double.parseDouble(split[3]);
        return new GeoJsonPoint(new Point(longitude, latitude));
    }

    private int getTendency(Random random) {
        return random.nextInt(10);
    }

    private int getPlaces(Random random) {
        return random.nextInt(100);
    }

    private int getFreeSpaces(Random random, int max) {
        double randomDouble = Math.pow(random.nextGaussian() * 2, 2);
        int randomDoubleInt = ((int) randomDouble) / 1;
        if (randomDoubleInt > max) {
            randomDoubleInt = max;
        }
        return randomDoubleInt;
    }

}
