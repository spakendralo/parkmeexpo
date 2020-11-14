package lu.pistache.parkme.parkmeexpo.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Structure {
    @Id
    public String id;
    private List<Floor> floors;

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
