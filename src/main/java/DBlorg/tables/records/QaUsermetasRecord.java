/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.records;


import javax.annotation.Generated;

import DBlorg.tables.QaUsermetas;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class QaUsermetasRecord extends UpdatableRecordImpl<QaUsermetasRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 547842157;

    /**
     * Setter for <code>DBlorg.qa_usermetas.userid</code>.
     */
    public void setUserid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>DBlorg.qa_usermetas.userid</code>.
     */
    public String getUserid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>DBlorg.qa_usermetas.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>DBlorg.qa_usermetas.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>DBlorg.qa_usermetas.content</code>.
     */
    public void setContent(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DBlorg.qa_usermetas.content</code>.
     */
    public String getContent() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return QaUsermetas.QA_USERMETAS.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return QaUsermetas.QA_USERMETAS.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return QaUsermetas.QA_USERMETAS.CONTENT;
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
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getContent();
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
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUsermetasRecord value1(String value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUsermetasRecord value2(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUsermetasRecord value3(String value) {
        setContent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUsermetasRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QaUsermetasRecord
     */
    public QaUsermetasRecord() {
        super(QaUsermetas.QA_USERMETAS);
    }

    /**
     * Create a detached, initialised QaUsermetasRecord
     */
    public QaUsermetasRecord(String userid, String title, String content) {
        super(QaUsermetas.QA_USERMETAS);

        set(0, userid);
        set(1, title);
        set(2, content);
    }
}