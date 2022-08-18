package db.personalRequests;

import db.connection.Column;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@ToString
public class PersonalRequestsModel {

    //מזהה בקשה
    @Column("black_id")
    private Integer id;

    // לא מעניין
    @Column("req_id")
    private String req_id;

    // מספר אישי
    @Column("pernr")
    private String personalNumber;

    // מזהה בקשה
    @Column("subty")
    private Integer subType;

    // תאריך התחלה
    @Column("begda")
    private String beginningDate;

    // מהות הבקשה
    @Column("req_kind")
    private String essenceRequest;

    // סטטוס הבקשה
    @Column("req_stat")
    private String requestStatus;

    // סיבת סטטוס הבקשה
    @Column("req_stat_res")
    private String requestStatusReason;

    // סיבת הגשת הבקשה
    @Column("req_class")
    private String requestReasonSubmitting;

    // סטטוס הבקשה ברשת השחורה
    @Column("black_status")
    private String black_status;

    // שעה
    @Column("hour")
    private String hour;

    // לא מעניין
    @Column("red_timestamp")
    private String red_timestamp;

    // לא מעניין
    @Column("red_counter")
    private String red_counter;

    // סטטוס התתמשקות הבקשה עם הרשת האדומה
    @Column("send_to_red_status")
    private String send_to_red_status;

    //???
    @Column("updated_time")
    private String updated_time;
}
