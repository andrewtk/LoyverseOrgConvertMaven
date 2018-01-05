/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.types.UInteger;


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
public class QaBlogComments implements Serializable {

    private static final long serialVersionUID = -579676351;

    private UInteger  postid;
    private UInteger  parentid;
    private Timestamp posted;
    private String    comment;
    private UInteger  userid;
    private Timestamp updated;
    private String    format;

    public QaBlogComments() {}

    public QaBlogComments(QaBlogComments value) {
        this.postid = value.postid;
        this.parentid = value.parentid;
        this.posted = value.posted;
        this.comment = value.comment;
        this.userid = value.userid;
        this.updated = value.updated;
        this.format = value.format;
    }

    public QaBlogComments(
        UInteger  postid,
        UInteger  parentid,
        Timestamp posted,
        String    comment,
        UInteger  userid,
        Timestamp updated,
        String    format
    ) {
        this.postid = postid;
        this.parentid = parentid;
        this.posted = posted;
        this.comment = comment;
        this.userid = userid;
        this.updated = updated;
        this.format = format;
    }

    public UInteger getPostid() {
        return this.postid;
    }

    public void setPostid(UInteger postid) {
        this.postid = postid;
    }

    public UInteger getParentid() {
        return this.parentid;
    }

    public void setParentid(UInteger parentid) {
        this.parentid = parentid;
    }

    public Timestamp getPosted() {
        return this.posted;
    }

    public void setPosted(Timestamp posted) {
        this.posted = posted;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UInteger getUserid() {
        return this.userid;
    }

    public void setUserid(UInteger userid) {
        this.userid = userid;
    }

    public Timestamp getUpdated() {
        return this.updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("QaBlogComments (");

        sb.append(postid);
        sb.append(", ").append(parentid);
        sb.append(", ").append(posted);
        sb.append(", ").append(comment);
        sb.append(", ").append(userid);
        sb.append(", ").append(updated);
        sb.append(", ").append(format);

        sb.append(")");
        return sb.toString();
    }
}