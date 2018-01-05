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
import DBlorg.tables.records.QaCookiesRecord;
import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;


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
public class QaCookies extends TableImpl<QaCookiesRecord> {

    private static final long serialVersionUID = 1092634145;

    /**
     * The reference instance of <code>DBlorg.qa_cookies</code>
     */
    public static final QaCookies QA_COOKIES = new QaCookies();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QaCookiesRecord> getRecordType() {
        return QaCookiesRecord.class;
    }

    /**
     * The column <code>DBlorg.qa_cookies.cookieid</code>.
     */
    public final TableField<QaCookiesRecord, ULong> COOKIEID = createField("cookieid", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_cookies.created</code>.
     */
    public final TableField<QaCookiesRecord, Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_cookies.createip</code>.
     */
    public final TableField<QaCookiesRecord, UInteger> CREATEIP = createField("createip", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_cookies.written</code>.
     */
    public final TableField<QaCookiesRecord, Timestamp> WRITTEN = createField("written", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>DBlorg.qa_cookies.writeip</code>.
     */
    public final TableField<QaCookiesRecord, UInteger> WRITEIP = createField("writeip", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * Create a <code>DBlorg.qa_cookies</code> table reference
     */
    public QaCookies() {
        this(DSL.name("qa_cookies"), null);
    }

    /**
     * Create an aliased <code>DBlorg.qa_cookies</code> table reference
     */
    public QaCookies(String alias) {
        this(DSL.name(alias), QA_COOKIES);
    }

    /**
     * Create an aliased <code>DBlorg.qa_cookies</code> table reference
     */
    public QaCookies(Name alias) {
        this(alias, QA_COOKIES);
    }

    private QaCookies(Name alias, Table<QaCookiesRecord> aliased) {
        this(alias, aliased, null);
    }

    private QaCookies(Name alias, Table<QaCookiesRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.QA_COOKIES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<QaCookiesRecord> getPrimaryKey() {
        return Keys.KEY_QA_COOKIES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<QaCookiesRecord>> getKeys() {
        return Arrays.<UniqueKey<QaCookiesRecord>>asList(Keys.KEY_QA_COOKIES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaCookies as(String alias) {
        return new QaCookies(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaCookies as(Name alias) {
        return new QaCookies(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QaCookies rename(String name) {
        return new QaCookies(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QaCookies rename(Name name) {
        return new QaCookies(name, null);
    }
}
