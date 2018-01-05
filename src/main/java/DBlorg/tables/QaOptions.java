/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import DBlorg.Indexes;
import DBlorg.Keys;
import DBlorg.Lorg;
import DBlorg.tables.records.QaOptionsRecord;
import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class QaOptions extends TableImpl<QaOptionsRecord> {

    private static final long serialVersionUID = -923776634;

    /**
     * The reference instance of <code>DBlorg.qa_options</code>
     */
    public static final QaOptions QA_OPTIONS = new QaOptions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QaOptionsRecord> getRecordType() {
        return QaOptionsRecord.class;
    }

    /**
     * The column <code>DBlorg.qa_options.title</code>.
     */
    public final TableField<QaOptionsRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(40).nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_options.content</code>.
     */
    public final TableField<QaOptionsRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.VARCHAR(8000).nullable(false), this, "");

    /**
     * Create a <code>DBlorg.qa_options</code> table reference
     */
    public QaOptions() {
        this(DSL.name("qa_options"), null);
    }

    /**
     * Create an aliased <code>DBlorg.qa_options</code> table reference
     */
    public QaOptions(String alias) {
        this(DSL.name(alias), QA_OPTIONS);
    }

    /**
     * Create an aliased <code>DBlorg.qa_options</code> table reference
     */
    public QaOptions(Name alias) {
        this(alias, QA_OPTIONS);
    }

    private QaOptions(Name alias, Table<QaOptionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private QaOptions(Name alias, Table<QaOptionsRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.QA_OPTIONS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<QaOptionsRecord> getPrimaryKey() {
        return Keys.KEY_QA_OPTIONS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<QaOptionsRecord>> getKeys() {
        return Arrays.<UniqueKey<QaOptionsRecord>>asList(Keys.KEY_QA_OPTIONS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaOptions as(String alias) {
        return new QaOptions(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaOptions as(Name alias) {
        return new QaOptions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QaOptions rename(String name) {
        return new QaOptions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QaOptions rename(Name name) {
        return new QaOptions(name, null);
    }
}
