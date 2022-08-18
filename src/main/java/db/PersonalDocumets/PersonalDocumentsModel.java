package db.PersonalDocumets;

import db.connection.Column;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@ToString
public class PersonalDocumentsModel {

    //מזהה
    @Column("id")
    private Integer id;

    // מספר אישי
    @Column("pernr")
    private String personalNumber;

    // סוג מסמך
    @Column("type")
    private Integer Type;

    // כתובת
    @Column("path")
    private String path;

    // תאריך התחלה
    @Column("begda")
    private String beginningDate;

    // תאריך סיום
    @Column("endda")
    private String endDate;

    // שעה
    @Column("hour")
    private String hour;

    //  סטטוס ההעלאה ברשת האדומה
    @Column("red_status")
    private String redStatus;

    //  סטטוס ההעלאה ברשת השחורה
    @Column("status")
    private String blackStatus;

    // סיבת סטטוס
    @Column("status_reason")
    private String StatusReason;

    // לא מעניין
    @Column("red_timestamp")
    private String red_timestamp;

    // לא מעניין
    @Column("red_counter")
    private String red_counter;

    // מזהה בקשה
    @Column("subty")
    private Integer subType;

    //מזהה מסמך
    @Column("black_id")
    private Integer blackId;

    // סטטוס התתמשקות הבקשה עם הרשת האדומה
    @Column("send_to_red_status")
    private String send_to_red_status;

    // לא מעניין
    @Column("updated_time")
    private String updated_time;

}
