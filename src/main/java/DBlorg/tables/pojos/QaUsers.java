/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
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
public class QaUsers implements Serializable {

    private static final long serialVersionUID = 172505882;

    private UInteger  userid;
    private Integer   sellerid;
    private Byte      owner;
    private Timestamp created;
    private UInteger  createip;
    private String    email;
    private String    handle;
    private ULong     avatarblobid;
    private UShort    avatarwidth;
    private UShort    avatarheight;
    private byte[]    passsalt;
    private byte[]    passcheck;
    private UByte     level;
    private Timestamp loggedin;
    private UInteger  loginip;
    private Timestamp written;
    private UInteger  writeip;
    private String    emailcode;
    private String    sessioncode;
    private String    sessionsource;
    private UShort    flags;
    private Integer   wallposts;
    private String    oemail;

    public QaUsers() {}

    public QaUsers(QaUsers value) {
        this.userid = value.userid;
        this.sellerid = value.sellerid;
        this.owner = value.owner;
        this.created = value.created;
        this.createip = value.createip;
        this.email = value.email;
        this.handle = value.handle;
        this.avatarblobid = value.avatarblobid;
        this.avatarwidth = value.avatarwidth;
        this.avatarheight = value.avatarheight;
        this.passsalt = value.passsalt;
        this.passcheck = value.passcheck;
        this.level = value.level;
        this.loggedin = value.loggedin;
        this.loginip = value.loginip;
        this.written = value.written;
        this.writeip = value.writeip;
        this.emailcode = value.emailcode;
        this.sessioncode = value.sessioncode;
        this.sessionsource = value.sessionsource;
        this.flags = value.flags;
        this.wallposts = value.wallposts;
        this.oemail = value.oemail;
    }

    public QaUsers(
        UInteger  userid,
        Integer   sellerid,
        Byte      owner,
        Timestamp created,
        UInteger  createip,
        String    email,
        String    handle,
        ULong     avatarblobid,
        UShort    avatarwidth,
        UShort    avatarheight,
        byte[]    passsalt,
        byte[]    passcheck,
        UByte     level,
        Timestamp loggedin,
        UInteger  loginip,
        Timestamp written,
        UInteger  writeip,
        String    emailcode,
        String    sessioncode,
        String    sessionsource,
        UShort    flags,
        Integer   wallposts,
        String    oemail
    ) {
        this.userid = userid;
        this.sellerid = sellerid;
        this.owner = owner;
        this.created = created;
        this.createip = createip;
        this.email = email;
        this.handle = handle;
        this.avatarblobid = avatarblobid;
        this.avatarwidth = avatarwidth;
        this.avatarheight = avatarheight;
        this.passsalt = passsalt;
        this.passcheck = passcheck;
        this.level = level;
        this.loggedin = loggedin;
        this.loginip = loginip;
        this.written = written;
        this.writeip = writeip;
        this.emailcode = emailcode;
        this.sessioncode = sessioncode;
        this.sessionsource = sessionsource;
        this.flags = flags;
        this.wallposts = wallposts;
        this.oemail = oemail;
    }

    public UInteger getUserid() {
        return this.userid;
    }

    public void setUserid(UInteger userid) {
        this.userid = userid;
    }

    public Integer getSellerid() {
        return this.sellerid;
    }

    public void setSellerid(Integer sellerid) {
        this.sellerid = sellerid;
    }

    public Byte getOwner() {
        return this.owner;
    }

    public void setOwner(Byte owner) {
        this.owner = owner;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public UInteger getCreateip() {
        return this.createip;
    }

    public void setCreateip(UInteger createip) {
        this.createip = createip;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHandle() {
        return this.handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public ULong getAvatarblobid() {
        return this.avatarblobid;
    }

    public void setAvatarblobid(ULong avatarblobid) {
        this.avatarblobid = avatarblobid;
    }

    public UShort getAvatarwidth() {
        return this.avatarwidth;
    }

    public void setAvatarwidth(UShort avatarwidth) {
        this.avatarwidth = avatarwidth;
    }

    public UShort getAvatarheight() {
        return this.avatarheight;
    }

    public void setAvatarheight(UShort avatarheight) {
        this.avatarheight = avatarheight;
    }

    public byte[] getPasssalt() {
        return this.passsalt;
    }

    public void setPasssalt(byte... passsalt) {
        this.passsalt = passsalt;
    }

    public byte[] getPasscheck() {
        return this.passcheck;
    }

    public void setPasscheck(byte... passcheck) {
        this.passcheck = passcheck;
    }

    public UByte getLevel() {
        return this.level;
    }

    public void setLevel(UByte level) {
        this.level = level;
    }

    public Timestamp getLoggedin() {
        return this.loggedin;
    }

    public void setLoggedin(Timestamp loggedin) {
        this.loggedin = loggedin;
    }

    public UInteger getLoginip() {
        return this.loginip;
    }

    public void setLoginip(UInteger loginip) {
        this.loginip = loginip;
    }

    public Timestamp getWritten() {
        return this.written;
    }

    public void setWritten(Timestamp written) {
        this.written = written;
    }

    public UInteger getWriteip() {
        return this.writeip;
    }

    public void setWriteip(UInteger writeip) {
        this.writeip = writeip;
    }

    public String getEmailcode() {
        return this.emailcode;
    }

    public void setEmailcode(String emailcode) {
        this.emailcode = emailcode;
    }

    public String getSessioncode() {
        return this.sessioncode;
    }

    public void setSessioncode(String sessioncode) {
        this.sessioncode = sessioncode;
    }

    public String getSessionsource() {
        return this.sessionsource;
    }

    public void setSessionsource(String sessionsource) {
        this.sessionsource = sessionsource;
    }

    public UShort getFlags() {
        return this.flags;
    }

    public void setFlags(UShort flags) {
        this.flags = flags;
    }

    public Integer getWallposts() {
        return this.wallposts;
    }

    public void setWallposts(Integer wallposts) {
        this.wallposts = wallposts;
    }

    public String getOemail() {
        return this.oemail;
    }

    public void setOemail(String oemail) {
        this.oemail = oemail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("QaUsers (");

        sb.append(userid);
        sb.append(", ").append(sellerid);
        sb.append(", ").append(owner);
        sb.append(", ").append(created);
        sb.append(", ").append(createip);
        sb.append(", ").append(email);
        sb.append(", ").append(handle);
        sb.append(", ").append(avatarblobid);
        sb.append(", ").append(avatarwidth);
        sb.append(", ").append(avatarheight);
        sb.append(", ").append("[binary...]");
        sb.append(", ").append("[binary...]");
        sb.append(", ").append(level);
        sb.append(", ").append(loggedin);
        sb.append(", ").append(loginip);
        sb.append(", ").append(written);
        sb.append(", ").append(writeip);
        sb.append(", ").append(emailcode);
        sb.append(", ").append(sessioncode);
        sb.append(", ").append(sessionsource);
        sb.append(", ").append(flags);
        sb.append(", ").append(wallposts);
        sb.append(", ").append(oemail);

        sb.append(")");
        return sb.toString();
    }
}
