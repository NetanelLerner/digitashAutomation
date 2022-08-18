package db.extraRequestData;

import db.connection.Column;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import net.bytebuddy.build.CachedReturnPlugin;

@Data
@Accessors(fluent = true)
@ToString
public class ExtraRequestDataModel {

    // מזהה
    @Column("id")
    private Integer id;

    // כל הנראה נשתמש רק בזה לשם קשרים
    @Column("black_id")
    private Integer requestId;

    // לא מעניין
    @Column("red_timestamp")
    private String red_timestamp;

    // שם מעסיק
    @Column("employer_name")
    private String employerName;

    @Column("employ_num")
    private String employ_num;

    // לא מעניין
    @Column("red_counter")
    private String red_counter;

    // סטטוס התתמשקות הבקשה עם הרשת האדומה
    @Column("send_to_red_status")
    private String send_to_red_status;

    // לא מעניין
    @Column("updated_time")
    private String updated_time;

    // תאריך תחילת עבודה
    @Column("work_begda")
    private String workBeginningDate;

    // תאריך סיום עבודה
    @Column("work_endda")
    private String workEndDate;

    // שם העסק
    @Column("work_name")
    private String workName;

    // מקצוע/עיסוק
    @Column("profession")
    private String profession;

    // כתובת העבודה
    @Column("work_address")
    private String workAddress;

    // שכר לשעה
    @Column("sachar")
    private String wage;

    // משעה
    @Column("work_from_hr")
    private String workFromHour;

    // עד שעה
    @Column("work_to_hr")
    private String workToHour;
}
