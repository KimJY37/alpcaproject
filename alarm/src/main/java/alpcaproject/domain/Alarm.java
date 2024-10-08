package alpcaproject.domain;

import alpcaproject.AlarmApplication;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

@Entity
@Table(name = "Alarm_table")
@Data
//<<< DDD / Aggregate Root
public class Alarm {

    @Id
    private String msgId;

    private String customerId;

    private String familyId;

    private String content;

    private String moveStatus;

    private String moveId;

    public static AlarmRepository repository() {
        AlarmRepository alarmRepository = AlarmApplication.applicationContext.getBean(
            AlarmRepository.class
        );
        return alarmRepository;
    }

    //<<< Clean Arch / Port Method
    public static void sendAlarmMsg(MoveStarted moveStarted) {
        //implement business logic here: 알람 발행
        Alarm alarm = new Alarm();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddsssss");
        alarm.setMsgId("msg-" + LocalDateTime.now().format(formatter));
        alarm.setContent("출발");
        alarm.setFamilyId(moveStarted.getFamilyId());
        alarm.setCustomerId(moveStarted.getCustomerId());
        alarm.setMoveStatus("start");
        repository().save(alarm);
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelAlarmMsg(MoveCancelled moveCancelled) {
        //implement business logic here: alarm의 moveStatus를 cancel로 변경
        repository().findById(moveCancelled.getMoveId()).ifPresent(alarm->{
            repository().save(alarm);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void endAlarmMsg(MoveEnded moveEnded) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        */

        /** Example 2:  finding and process
        
        repository().findById(moveEnded.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
