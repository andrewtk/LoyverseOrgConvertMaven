/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.records;


import javax.annotation.Generated;

import DBlorg.tables.QaUserlogins;
import org.jooq.Field;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.TableRecordImpl;
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
public class QaUserloginsRecord extends TableRecordImpl<QaUserloginsRecord> implements Record6<UInteger, String, byte[], byte[], String, String> {

    private static final long serialVersionUID = -1228444619;

    /**
     * Setter for <code>DBlorg.qa_userlogins.userid</code>.
     */
    public void setUserid(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlogins.userid</code>.
     */
    public UInteger getUserid() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>DBlorg.qa_userlogins.source</code>.
     */
    public void setSource(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlogins.source</code>.
     */
    public String getSource() {
        return (String) get(1);
    }

    /**
     * Setter for <code>DBlorg.qa_userlogins.identifier</code>.
     */
    public void setIdentifier(byte... value) {
        set(2, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlogins.identifier</code>.
     */
    public byte[] getIdentifier() {
        return (byte[]) get(2);
    }

    /**
     * Setter for <code>DBlorg.qa_userlogins.identifiermd5</code>.
     */
    public void setIdentifiermd5(byte... value) {
        set(3, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlogins.identifiermd5</code>.
     */
    public byte[] getIdentifiermd5() {
        return (byte[]) get(3);
    }

    /**
     * Setter for <code>DBlorg.qa_userlogins.oemail</code>.
     */
    public void setOemail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlogins.oemail</code>.
     */
    public String getOemail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>DBlorg.qa_userlogins.ohandle</code>.
     */
    public void setOhandle(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>DBlorg.qa_userlogins.ohandle</code>.
     */
    public String getOhandle() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<UInteger, String, byte[], byte[], String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<UInteger, String, byte[], byte[], String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return QaUserlogins.QA_USERLOGINS.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return QaUserlogins.QA_USERLOGINS.SOURCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field3() {
        return QaUserlogins.QA_USERLOGINS.IDENTIFIER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field4() {
        return QaUserlogins.QA_USERLOGINS.IDENTIFIERMD5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return QaUserlogins.QA_USERLOGINS.OEMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return QaUserlogins.QA_USERLOGINS.OHANDLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getSource();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component3() {
        return getIdentifier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component4() {
        return getIdentifiermd5();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getOemail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getOhandle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSource();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value3() {
        return getIdentifier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value4() {
        return getIdentifiermd5();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getOemail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getOhandle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserloginsRecord value1(UInteger value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserloginsRecord value2(String value) {
        setSource(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserloginsRecord value3(byte... value) {
        setIdentifier(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserloginsRecord value4(byte... value) {
        setIdentifiermd5(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserloginsRecord value5(String value) {
        setOemail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserloginsRecord value6(String value) {
        setOhandle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUserloginsRecord values(UInteger value1, String value2, byte[] value3, byte[] value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QaUserloginsRecord
     */
    public QaUserloginsRecord() {
        super(QaUserlogins.QA_USERLOGINS);
    }

    /**
     * Create a detached, initialised QaUserloginsRecord
     */
    public QaUserloginsRecord(UInteger userid, String source, byte[] identifier, byte[] identifiermd5, String oemail, String ohandle) {
        super(QaUserlogins.QA_USERLOGINS);

        set(0, userid);
        set(1, source);
        set(2, identifier);
        set(3, identifiermd5);
        set(4, oemail);
        set(5, ohandle);
    }
}
