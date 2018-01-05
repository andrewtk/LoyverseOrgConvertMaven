/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables.pojos;


import javax.annotation.Generated;
import java.io.Serializable;
import java.sql.Timestamp;


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
public class Comments implements Serializable {

    private static final long serialVersionUID = -370236884;

    private Integer   id;
    private Integer   answid;
    private Integer   qsid;
    private Integer   comid;
    private Integer   userid;
    private String    content;
    private Integer   depth;
    private Byte      mailme;
    private Timestamp created;
    private Timestamp updated;

    public Comments() {}

    public Comments(Comments value) {
        this.id = value.id;
        this.answid = value.answid;
        this.qsid = value.qsid;
        this.comid = value.comid;
        this.userid = value.userid;
        this.content = value.content;
        this.depth = value.depth;
        this.mailme = value.mailme;
        this.created = value.created;
        this.updated = value.updated;
    }

    public Comments(
        Integer   id,
        Integer   answid,
        Integer   qsid,
        Integer   comid,
        Integer   userid,
        String    content,
        Integer   depth,
        Byte      mailme,
        Timestamp created,
        Timestamp updated
    ) {
        this.id = id;
        this.answid = answid;
        this.qsid = qsid;
        this.comid = comid;
        this.userid = userid;
        this.content = content;
        this.depth = depth;
        this.mailme = mailme;
        this.created = created;
        this.updated = updated;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnswid() {
        return this.answid;
    }

    public void setAnswid(Integer answid) {
        this.answid = answid;
    }

    public Integer getQsid() {
        return this.qsid;
    }

    public void setQsid(Integer qsid) {
        this.qsid = qsid;
    }

    public Integer getComid() {
        return this.comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDepth() {
        return this.depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Byte getMailme() {
        return this.mailme;
    }

    public void setMailme(Byte mailme) {
        this.mailme = mailme;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return this.updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Comments (");

        sb.append(id);
        sb.append(", ").append(answid);
        sb.append(", ").append(qsid);
        sb.append(", ").append(comid);
        sb.append(", ").append(userid);
        sb.append(", ").append(content);
        sb.append(", ").append(depth);
        sb.append(", ").append(mailme);
        sb.append(", ").append(created);
        sb.append(", ").append(updated);

        sb.append(")");
        return sb.toString();
    }
}
