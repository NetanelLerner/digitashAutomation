package db.requeststypes;

import db.connection.Column;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@ToString
public class RequestTypeModel {

    //  מזהה בקשה
    @Column("id")
    private Integer subTypeId;

    // שם הבקשה
    @Column("name")
    private String RequestName;

    //  תיאור הבקשה
    @Column("desc")
    private String description;

    //  מספר קטגוריה
    @Column("catId")
    private Integer categoryId;

    //  מזהה בקשה
    @Column("steps")
    private String steps;

    //  מזהה בקשה
    @Column("parentInd")
    private Boolean parentInd;

    //  מזהה בקשה
    @Column("entitleDesc")
    private String entitleDesc;

    //  האם הבקשה נתמכת
    @Column("isSupported")
    private Boolean isSupported;

    //  מזהה בקשה
    @Column("isSupportedUnderCategory")
    private Boolean isSupportedUnderCategory;

    //  מזהה בקשה
    @Column("applyId")
    private Integer applyId;
}
