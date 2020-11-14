package lu.pistache.parkme.parkmeexpo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Polygon;

public class Place {
    @Id
    public String id;
    private Polygon location;
    private boolean free;
}
