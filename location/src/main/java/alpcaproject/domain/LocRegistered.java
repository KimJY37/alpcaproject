package alpcaproject.domain;

import alpcaproject.domain.*;
import alpcaproject.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LocRegistered extends AbstractEvent {

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

    public LocRegistered(Location aggregate) {
        super(aggregate);
    }

    public LocRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
