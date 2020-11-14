package lu.pistache.parkme.parkmeexpo.controller;

import lu.pistache.parkme.parkmeexpo.db.ParkingRepository;
import lu.pistache.parkme.parkmeexpo.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingController {

    @Autowired
    private ParkingRepository repository;

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping("/parkings")
    List<ParkingLot> closeTo(@RequestParam(required = true) String latitude, @RequestParam(required = true) String longitude, @RequestParam(required = true) String distance, @RequestParam(required = false) String freeplaces) {
        List<ParkingLot> parkingLots;

        double distanceD = 0;
        if ((distance != null && !distance.trim().isEmpty())) {
            distanceD = Double.parseDouble(distance);
        }

        if (freeplaces != null && !freeplaces.trim().isEmpty()) {
            int freePlacesInt = Integer.parseInt(freeplaces);
            parkingLots = repository.findFreeLocationsNear(Double.parseDouble(longitude), Double.parseDouble(latitude), distanceD, freePlacesInt);
        } else {
            parkingLots = repository.findAllLocationsNear(Double.parseDouble(longitude), Double.parseDouble(latitude), distanceD);
        }



        return parkingLots;
    }
}
