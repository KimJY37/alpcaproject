package alpcaproject.domain;

import alpcaproject.LocationApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Location_table")
@Data
//<<< DDD / Aggregate Root
public class Location {

    @Id
    private String locId;

    private String customerId;

<<<<<<< HEAD
    private Double locX;

    private Double locY;
=======
    private String familyId;

    private String loc1;

    private String loc2;

    private String loc3;

    private String loc4;

    private String loc5;
>>>>>>> 536b31b (commit)

    public static LocationRepository repository() {
        LocationRepository locationRepository = LocationApplication.applicationContext.getBean(
            LocationRepository.class
        );
        return locationRepository;
    }
}
//>>> DDD / Aggregate Root
