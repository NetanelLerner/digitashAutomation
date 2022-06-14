package pages;

import db.Column;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@ToString
public class ApplyingStatusCodes {
    @Column("id")
    private String id;

    @Column("value")
    private String value;

}
