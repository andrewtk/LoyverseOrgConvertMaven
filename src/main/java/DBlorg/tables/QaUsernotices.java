/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import DBlorg.Indexes;
import DBlorg.Keys;
import DBlorg.Lorg;
import DBlorg.tables.records.QaUsernoticesRecord;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class QaUsernotices extends TableImpl<QaUsernoticesRecord> {

    private static final long serialVersionUID = 1876803792;

    /**
     * The reference instance of <code>DBlorg.qa_usernotices</code>
     */
    public static final QaUsernotices QA_USERNOTICES = new QaUsernotices();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QaUsernoticesRecord> getRecordType() {
        return QaUsernoticesRecord.class;
    }

    /**
     * The column <code>DBlorg.qa_usernotices.noticeid</code>.
     */
    public final TableField<QaUsernoticesRecord, UInteger> NOTICEID = createField("noticeid", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>DBlorg.qa_usernotices.userid</code>.
     */
    public final TableField<QaUsernoticesRecord, String> USERID = createField("userid", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_usernotices.content</code>.
     */
    public final TableField<QaUsernoticesRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.VARCHAR(8000).nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_usernotices.format</code>.
     */
    public final TableField<QaUsernoticesRecord, String> FORMAT = createField("format", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_usernotices.tags</code>.
     */
    public final TableField<QaUsernoticesRecord, String> TAGS = createField("tags", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>DBlorg.qa_usernotices.created</code>.
     */
    public final TableField<QaUsernoticesRecord, Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>DBlorg.qa_usernotices</code> table reference
     */
    public QaUsernotices() {
        this(DSL.name("qa_usernotices"), null);
    }

    /**
     * Create an aliased <code>DBlorg.qa_usernotices</code> table reference
     */
    public QaUsernotices(String alias) {
        this(DSL.name(alias), QA_USERNOTICES);
    }

    /**
     * Create an aliased <code>DBlorg.qa_usernotices</code> table reference
     */
    public QaUsernotices(Name alias) {
        this(alias, QA_USERNOTICES);
    }

    private QaUsernotices(Name alias, Table<QaUsernoticesRecord> aliased) {
        this(alias, aliased, null);
    }

    private QaUsernotices(Name alias, Table<QaUsernoticesRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.QA_USERNOTICES_PRIMARY, Indexes.QA_USERNOTICES_USERID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<QaUsernoticesRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_QA_USERNOTICES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<QaUsernoticesRecord> getPrimaryKey() {
        return Keys.KEY_QA_USERNOTICES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<QaUsernoticesRecord>> getKeys() {
        return Arrays.<UniqueKey<QaUsernoticesRecord>>asList(Keys.KEY_QA_USERNOTICES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUsernotices as(String alias) {
        return new QaUsernotices(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaUsernotices as(Name alias) {
        return new QaUsernotices(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QaUsernotices rename(String name) {
        return new QaUsernotices(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QaUsernotices rename(Name name) {
        return new QaUsernotices(name, null);
    }
}
