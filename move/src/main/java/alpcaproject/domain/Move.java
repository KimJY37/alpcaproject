package alpcaproject.domain;

import alpcaproject.MoveApplication;
import alpcaproject.domain.MoveCancelled;
import alpcaproject.domain.MoveEnded;
import alpcaproject.domain.MoveStarted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Move_table")
@Data
//<<< DDD / Aggregate Root
public class Move {

    @Id
    private String moveId;

    private String familyId;

    private String role;

    private String startRdnAddr;

    private Double startLocX;

    private Double startLocY;

    private Double goalLocX;

    private Double goalLocY;

    private Integer distance;

    private Integer duration;

    private String path;

    private String status;

    private String customerId;

    @PostPersist
    public void onPostPersist() {
        MoveStarted moveStarted = new MoveStarted(this);
        moveStarted.publishAfterCommit();

        MoveCancelled moveCancelled = new MoveCancelled(this);
        moveCancelled.publishAfterCommit();

        MoveEnded moveEnded = new MoveEnded(this);
        moveEnded.publishAfterCommit();
    }

    public static MoveRepository repository() {
        MoveRepository moveRepository = MoveApplication.applicationContext.getBean(
            MoveRepository.class
        );
        return moveRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateGoalLoc(LocRegistered locRegistered) {
        //implement business logic here: 목적지 좌표 업데이트
        repository().findById(locRegistered.getLocId()).ifPresent(move->{
            move.setGoalLocX(locRegistered.getLocX());
            move.setGoalLocY(locRegistered.getLocY());
            repository().save(move);
        });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void removeGoalLoc(LocRemoved locRemoved) {

        //implement business logic here: 목적지 삭제
        repository().findById(locRemoved.getLocId()).ifPresent(move->{
            repository().delete(move);
        });
    }

}
//>>> DDD / Aggregate Root
