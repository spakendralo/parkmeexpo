package lu.pistache.parkme.parkmeexpo;

import lu.pistache.parkme.parkmeexpo.db.ParkingRepository;
import lu.pistache.parkme.parkmeexpo.model.ParkingLot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class FindNearPointsTest {



    @Autowired
    private ParkingRepository repository;


    @Test
    void getFileAndTransformToLocations() throws IOException {
            double x = -97.68895376;
        double y = 30.37739489;
        List<ParkingLot> result1 = repository.findAllLocationsNear(x, y, 1000);
        System.out.println(result1.size());

    }

}
