package alpcaproject.domain;

import alpcaproject.domain.*;
import alpcaproject.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class LocRegistered extends AbstractEvent {

    private String locId;
    private String customerId;
    private String familyId;
    private String loc1;
    private String loc2;
    private String loc3;
    private String loc4;
    private String loc5;
}
