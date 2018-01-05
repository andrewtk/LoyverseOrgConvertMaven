/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.records;


import javax.annotation.Generated;

import DBlorg.tables.QaUserlevels;
import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.UByte;
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
public class QaUserlevelsRecord extends TableRecordImpl<QaUserlevelsRecord> implements Record4<String, String, UInteger, UByte> {

    private static final long serialVersionUID = -1842812656;

    /**
     * Setter for <code>DBlorg.qa_userlevels.userid</code>.
     */
    public void setUserid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlevels.userid</code>.
     */
    public String getUserid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>DBlorg.qa_userlevels.entitytype</code>.
     */
    public void setEntitytype(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlevels.entitytype</code>.
     */
    public String getEntitytype() {
        return (String) get(1);
    }

    /**
     * Setter for <code>DBlorg.qa_userlevels.entityid</code>.
     */
    public void setEntityid(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlevels.entityid</code>.
     */
    public UInteger getEntityid() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>DBlorg.qa_userlevels.level</code>.
     */
    public void setLevel(UByte value) {
        set(3, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlevels.level</code>.
     */
    public UByte getLevel() {
        return (UByte) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, UInteger, UByte> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, UInteger, UByte> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return QaUserlevels.QA_USERLEVELS.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return QaUserlevels.QA_USERLEVELS.ENTITYTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field3() {
        return QaUserlevels.QA_USERLEVELS.ENTITYID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UByte> field4() {
        return QaUserlevels.QA_USERLEVELS.LEVEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getEntitytype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component3() {
        return getEntityid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte component4() {
        return getLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getEntitytype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value3() {
        return getEntityid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UByte value4() {
        return getLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserlevelsRecord value1(String value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserlevelsRecord value2(String value) {
        setEntitytype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserlevelsRecord value3(UInteger value) {
        setEntityid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserlevelsRecord value4(UByte value) {
        setLevel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserlevelsRecord values(String value1, String value2, UInteger value3, UByte value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QaUserlevelsRecord
     */
    public QaUserlevelsRecord() {
        super(QaUserlevels.QA_USERLEVELS);
    }

    /**
     * Create a detached, initialised QaUserlevelsRecord
     */
    public QaUserlevelsRecord(String userid, String entitytype, UInteger entityid, UByte level) {
        super(QaUserlevels.QA_USERLEVELS);

        set(0, userid);
        set(1, entitytype);
        set(2, entityid);
        set(3, level);
    }
}