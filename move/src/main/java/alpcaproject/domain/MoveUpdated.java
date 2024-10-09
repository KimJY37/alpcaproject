package alpcaproject.domain;

import alpcaproject.domain.*;
import alpcaproject.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MoveUpdated extends AbstractEvent {

    private Long id;

    public MoveUpdated(Move aggregate) {
        super(aggregate);
    }

    public MoveUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
