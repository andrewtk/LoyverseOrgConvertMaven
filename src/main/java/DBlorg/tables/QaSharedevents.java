/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import DBlorg.Indexes;
import DBlorg.Lorg;
import DBlorg.tables.records.QaSharedeventsRecord;
import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
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
public class QaSharedevents extends TableImpl<QaSharedeventsRecord> {

    private static final long serialVersionUID = 1588235178;

    /**
     * The reference instance of <code>DBlorg.qa_sharedevents</code>
     */
    public static final QaSharedevents QA_SHAREDEVENTS = new QaSharedevents();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QaSharedeventsRecord> getRecordType() {
        return QaSharedeventsRecord.class;
    }

    /**
     * The column <code>DBlorg.qa_sharedevents.entitytype</code>.
     */
    public final TableField<QaSharedeventsRecord, String> ENTITYTYPE = createField("entitytype", org.jooq.impl.SQLDataType.CHAR(1).nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_sharedevents.entityid</code>.
     */
    public final TableField<QaSharedeventsRecord, UInteger> ENTITYID = createField("entityid", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_sharedevents.questionid</code>.
     */
    public final TableField<QaSharedeventsRecord, UInteger> QUESTIONID = createField("questionid", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_sharedevents.lastpostid</code>.
     */
    public final TableField<QaSharedeventsRecord, UInteger> LASTPOSTID = createField("lastpostid", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_sharedevents.updatetype</code>.
     */
    public final TableField<QaSharedeventsRecord, String> UPDATETYPE = createField("updatetype", org.jooq.impl.SQLDataType.CHAR(1), this, "");

    /**
     * The column <code>DBlorg.qa_sharedevents.lastuserid</code>.
     */
    public final TableField<QaSharedeventsRecord, String> LASTUSERID = createField("lastuserid", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>DBlorg.qa_sharedevents.updated</code>.
     */
    public final TableField<QaSharedeventsRecord, Timestamp> UPDATED = createField("updated", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>DBlorg.qa_sharedevents</code> table reference
     */
    public QaSharedevents() {
        this(DSL.name("qa_sharedevents"), null);
    }

    /**
     * Create an aliased <code>DBlorg.qa_sharedevents</code> table reference
     */
    public QaSharedevents(String alias) {
        this(DSL.name(alias), QA_SHAREDEVENTS);
    }

    /**
     * Create an aliased <code>DBlorg.qa_sharedevents</code> table reference
     */
    public QaSharedevents(Name alias) {
        this(alias, QA_SHAREDEVENTS);
    }

    private QaSharedevents(Name alias, Table<QaSharedeventsRecord> aliased) {
        this(alias, aliased, null);
    }

    private QaSharedevents(Name alias, Table<QaSharedeventsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Lorg.LORG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.QA_SHAREDEVENTS_ENTITYTYPE, Indexes.QA_SHAREDEVENTS_QUESTIONID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaSharedevents as(String alias) {
        return new QaSharedevents(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaSharedevents as(Name alias) {
        return new QaSharedevents(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QaSharedevents rename(String name) {
        return new QaSharedevents(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QaSharedevents rename(Name name) {
        return new QaSharedevents(name, null);
    }
}
