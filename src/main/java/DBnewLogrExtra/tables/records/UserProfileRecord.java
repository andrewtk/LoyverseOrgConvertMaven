/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables.records;


import DBnewLogrExtra.tables.UserProfile;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
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
public class UserProfileRecord extends UpdatableRecordImpl<UserProfileRecord> implements Record12<Integer, Integer, String, String, String, String, String, String, String, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = -447840032;

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.userid</code>.
     */
    public void setUserid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.userid</code>.
     */
    public Integer getUserid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.username</code>.
     */
    public void setUsername(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.username</code>.
     */
    public String getUsername() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.fullname</code>.
     */
    public void setFullname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.fullname</code>.
     */
    public String getFullname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.location</code>.
     */
    public void setLocation(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.location</code>.
     */
    public String getLocation() {
        return (String) get(4);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.website</code>.
     */
    public void setWebsite(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.website</code>.
     */
    public String getWebsite() {
        return (String) get(5);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.email</code>.
     */
    public void setEmail(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.email</code>.
     */
    public String getEmail() {
        return (String) get(6);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.business_status</code>.
     */
    public void setBusinessStatus(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.business_status</code>.
     */
    public String getBusinessStatus() {
        return (String) get(7);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.bonus_points</code>.
     */
    public void setBonusPoints(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.bonus_points</code>.
     */
    public String getBonusPoints() {
        return (String) get(8);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.about</code>.
     */
    public void setAbout(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.about</code>.
     */
    public String getAbout() {
        return (String) get(9);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.created</code>.
     */
    public void setCreated(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.created</code>.
     */
    public Timestamp getCreated() {
        return (Timestamp) get(10);
    }

    /**
     * Setter for <code>DBnewLogrExtra.user_profile.updated</code>.
     */
    public void setUpdated(Timestamp value) {
        set(11, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.user_profile.updated</code>.
     */
    public Timestamp getUpdated() {
        return (Timestamp) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Integer, Integer, String, String, String, String, String, String, String, String, Timestamp, Timestamp> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Integer, Integer, String, String, String, String, String, String, String, String, Timestamp, Timestamp> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return UserProfile.USER_PROFILE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return UserProfile.USER_PROFILE.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return UserProfile.USER_PROFILE.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return UserProfile.USER_PROFILE.FULLNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return UserProfile.USER_PROFILE.LOCATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return UserProfile.USER_PROFILE.WEBSITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return UserProfile.USER_PROFILE.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return UserProfile.USER_PROFILE.BUSINESS_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return UserProfile.USER_PROFILE.BONUS_POINTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return UserProfile.USER_PROFILE.ABOUT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return UserProfile.USER_PROFILE.CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field12() {
        return UserProfile.USER_PROFILE.UPDATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getFullname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getWebsite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getBusinessStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getBonusPoints();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getAbout();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component11() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component12() {
        return getUpdated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getFullname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getWebsite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getBusinessStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getBonusPoints();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getAbout();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value12() {
        return getUpdated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value2(Integer value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value3(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value4(String value) {
        setFullname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value5(String value) {
        setLocation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value6(String value) {
        setWebsite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value7(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value8(String value) {
        setBusinessStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value9(String value) {
        setBonusPoints(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value10(String value) {
        setAbout(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value11(Timestamp value) {
        setCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord value12(Timestamp value) {
        setUpdated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserProfileRecord values(Integer value1, Integer value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, Timestamp value11, Timestamp value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserProfileRecord
     */
    public UserProfileRecord() {
        super(UserProfile.USER_PROFILE);
    }

    /**
     * Create a detached, initialised UserProfileRecord
     */
    public UserProfileRecord(Integer id, Integer userid, String username, String fullname, String location, String website, String email, String businessStatus, String bonusPoints, String about, Timestamp created, Timestamp updated) {
        super(UserProfile.USER_PROFILE);

        set(0, id);
        set(1, userid);
        set(2, username);
        set(3, fullname);
        set(4, location);
        set(5, website);
        set(6, email);
        set(7, businessStatus);
        set(8, bonusPoints);
        set(9, about);
        set(10, created);
        set(11, updated);
    }
}
