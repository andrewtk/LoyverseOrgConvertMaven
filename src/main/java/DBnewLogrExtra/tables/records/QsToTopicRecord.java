/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables.records;


import DBnewLogrExtra.tables.QsToTopic;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


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
public class QsToTopicRecord extends UpdatableRecordImpl<QsToTopicRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 1719094468;

    /**
     * Setter for <code>DBnewLogrExtra.qs_to_topic.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.qs_to_topic.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>DBnewLogrExtra.qs_to_topic.tpid</code>.
     */
    public void setTpid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.qs_to_topic.tpid</code>.
     */
    public Integer getTpid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>DBnewLogrExtra.qs_to_topic.qsid</code>.
     */
    public void setQsid(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>DBnewLogrExtra.qs_to_topic.qsid</code>.
     */
    public Integer getQsid() {
        return (Integer) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return QsToTopic.QS_TO_TOPIC.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return QsToTopic.QS_TO_TOPIC.TPID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return QsToTopic.QS_TO_TOPIC.QSID;
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
        return getTpid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getQsid();
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
        return getTpid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getQsid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QsToTopicRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QsToTopicRecord value2(Integer value) {
        setTpid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QsToTopicRecord value3(Integer value) {
        setQsid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QsToTopicRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QsToTopicRecord
     */
    public QsToTopicRecord() {
        super(QsToTopic.QS_TO_TOPIC);
    }

    /**
     * Create a detached, initialised QsToTopicRecord
     */
    public QsToTopicRecord(Integer id, Integer tpid, Integer qsid) {
        super(QsToTopic.QS_TO_TOPIC);

        set(0, id);
        set(1, tpid);
        set(2, qsid);
    }
}
