package lu.pistache.parkme.parkmeexpo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parking")
public class ParkingLot {
    @Id
    public String id;
    private String name;
    private int places;
    GeoJsonPoint location;
    private Status status;

    public ParkingLot() {
    }

    public ParkingLot(String name, int places, GeoJsonPoint location) {
        this.name = name;
        this.places = places;
        this.location = location;
    }

    public ParkingLot(String name, int places, GeoJsonPoint location, Status status) {
        this.name = name;
        this.places = places;
        this.location = location;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public int getPlaces() {
        return places;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
