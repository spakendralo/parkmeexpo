package lu.pistache.parkme.parkmeexpo.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Floor {
    @Id
    public String id;
    private String name = "Ground floor";
    private List<Place> places;

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
