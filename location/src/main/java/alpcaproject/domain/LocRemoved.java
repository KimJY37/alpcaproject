package alpcaproject.domain;

import alpcaproject.domain.*;
import alpcaproject.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LocRemoved extends AbstractEvent {

    private String locId;
    private String customerId;
    private String familyId;
    private String loc1;
    private String loc2;
    private String loc3;
    private String loc4;
    private String loc5;

    public LocRemoved(Location aggregate) {
        super(aggregate);
    }

    public LocRemoved() {
        super();
    }
}
//>>> DDD / Domain Event
