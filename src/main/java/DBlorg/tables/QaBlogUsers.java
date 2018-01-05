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
import DBlorg.tables.records.QaBlogUsersRecord;
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
public class QaBlogUsers extends TableImpl<QaBlogUsersRecord> {

    private static final long serialVersionUID = -1362783063;

    /**
     * The reference instance of <code>DBlorg.qa_blog_users</code>
     */
    public static final QaBlogUsers QA_BLOG_USERS = new QaBlogUsers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QaBlogUsersRecord> getRecordType() {
        return QaBlogUsersRecord.class;
    }

    /**
     * The column <code>DBlorg.qa_blog_users.userid</code>.
     */
    public final TableField<QaBlogUsersRecord, UInteger> USERID = createField("userid", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_blog_users.lastposted</code>.
     */
    public final TableField<QaBlogUsersRecord, Timestamp> LASTPOSTED = createField("lastposted", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_blog_users.lastpolled</code>.
     */
    public final TableField<QaBlogUsersRecord, Timestamp> LASTPOLLED = createField("lastpolled", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_blog_users.kickeduntil</code>.
     */
    public final TableField<QaBlogUsersRecord, Timestamp> KICKEDUNTIL = createField("kickeduntil", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(DSL.inline("2012-01-01 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>DBlorg.qa_blog_users</code> table reference
     */
    public QaBlogUsers() {
        this(DSL.name("qa_blog_users"), null);
    }

    /**
     * Create an aliased <code>DBlorg.qa_blog_users</code> table reference
     */
    public QaBlogUsers(String alias) {
        this(DSL.name(alias), QA_BLOG_USERS);
    }

    /**
     * Create an aliased <code>DBlorg.qa_blog_users</code> table reference
     */
    public QaBlogUsers(Name alias) {
        this(alias, QA_BLOG_USERS);
    }

    private QaBlogUsers(Name alias, Table<QaBlogUsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private QaBlogUsers(Name alias, Table<QaBlogUsersRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.QA_BLOG_USERS_ACTIVE, Indexes.QA_BLOG_USERS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<QaBlogUsersRecord> getPrimaryKey() {
        return Keys.KEY_QA_BLOG_USERS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<QaBlogUsersRecord>> getKeys() {
        return Arrays.<UniqueKey<QaBlogUsersRecord>>asList(Keys.KEY_QA_BLOG_USERS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaBlogUsers as(String alias) {
        return new QaBlogUsers(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaBlogUsers as(Name alias) {
        return new QaBlogUsers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QaBlogUsers rename(String name) {
        return new QaBlogUsers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QaBlogUsers rename(Name name) {
        return new QaBlogUsers(name, null);
    }
}