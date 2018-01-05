/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

import org.jooq.types.UByte;
import org.jooq.types.UShort;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QaUserfields implements Serializable {

    private static final long serialVersionUID = 1687403899;

    private UShort fieldid;
    private String title;
    private String content;
    private UShort position;
    private UByte  flags;
    private UByte  permit;

    public QaUserfields() {}

    public QaUserfields(QaUserfields value) {
        this.fieldid = value.fieldid;
        this.title = value.title;
        this.content = value.content;
        this.position = value.position;
        this.flags = value.flags;
        this.permit = value.permit;
    }

    public QaUserfields(
        UShort fieldid,
        String title,
        String content,
        UShort position,
        UByte  flags,
        UByte  permit
    ) {
        this.fieldid = fieldid;
        this.title = title;
        this.content = content;
        this.position = position;
        this.flags = flags;
        this.permit = permit;
    }

    public UShort getFieldid() {
        return this.fieldid;
    }

    public void setFieldid(UShort fieldid) {
        this.fieldid = fieldid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UShort getPosition() {
        return this.position;
    }

    public void setPosition(UShort position) {
        this.position = position;
    }

    public UByte getFlags() {
        return this.flags;
    }

    public void setFlags(UByte flags) {
        this.flags = flags;
    }

    public UByte getPermit() {
        return this.permit;
    }

    public void setPermit(UByte permit) {
        this.permit = permit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("QaUserfields (");

        sb.append(fieldid);
        sb.append(", ").append(title);
        sb.append(", ").append(content);
        sb.append(", ").append(position);
        sb.append(", ").append(flags);
        sb.append(", ").append(permit);

        sb.append(")");
        return sb.toString();
    }
}
