package lu.pistache.parkme.parkmeexpo.db;


import lu.pistache.parkme.parkmeexpo.model.ParkingLot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ParkingRepository extends MongoRepository<ParkingLot, String> {

    public ParkingLot findByName(String name);
    public List<ParkingLot> findAll();

    @Query("{location:\n" +
            "   { " +
            "         $near :\n" +
            "                {\n" +
            "                    $geometry: { type: \"Point\",  coordinates: [ ?0, ?1 ] },\n" +
            "                    $minDistance: 0,\n" +
            "                    $maxDistance: ?2\n" +
            "                }\n" +
            "        }\n" +
            "   }")
    public List<ParkingLot> findAllLocationsNear(double longitude, double latitude, double distance);

    @Query("{\n" +
            "    \"location\":\n" +
            "    {\n" +
            "        $near :\n" +
            "        {\n" +
            "            $geometry: { type: \"Point\",  coordinates: [ ?0, ?1 ] },\n" +
            "            $minDistance: 0,\n" +
            "                $maxDistance: ?2\n" +
            "        }\n" +
            "    },\n" +
            "    \"status.freePlaces\": { $gte: ?3 }\n" +
            "\n" +
            "}\n")
    public List<ParkingLot> findFreeLocationsNear(double longitude, double latitude, double distance, int freePlaces);

}



