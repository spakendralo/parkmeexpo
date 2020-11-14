package lu.pistache.parkme.parkmeexpo.model;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;


import java.util.Date;

public class Status {
    private int freePlaces;
    @CreatedDate
    private Date createdDate;
    private int tendency;

    public Status(int freePlaces, int tendency) {
        this.freePlaces = freePlaces;
        this.tendency = tendency;
        createdDate = new Date();
    }

    public int getFreeSpaces() {
        return freePlaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freePlaces = freeSpaces;
    }

    public int getTendency() {
        return tendency;
    }

    public void setTendency(int tendency) {
        this.tendency = tendency;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
