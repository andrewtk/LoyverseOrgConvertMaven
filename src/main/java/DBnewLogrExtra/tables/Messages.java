/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables;


import DBnewLogrExtra.Indexes;
import DBnewLogrExtra.Keys;
import DBnewLogrExtra.Newlogrextra;
import DBnewLogrExtra.tables.records.MessagesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


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
public class Messages extends TableImpl<MessagesRecord> {

    private static final long serialVersionUID = -1944083476;

    /**
     * The reference instance of <code>DBnewLogrExtra.messages</code>
     */
    public static final Messages MESSAGES = new Messages();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MessagesRecord> getRecordType() {
        return MessagesRecord.class;
    }

    /**
     * The column <code>DBnewLogrExtra.messages.id</code>.
     */
    public final TableField<MessagesRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>DBnewLogrExtra.messages.user_from</code>.
     */
    public final TableField<MessagesRecord, Integer> USER_FROM = createField("user_from", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>DBnewLogrExtra.messages.user_to</code>.
     */
    public final TableField<MessagesRecord, Integer> USER_TO = createField("user_to", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>DBnewLogrExtra.messages.message</code>.
     */
    public final TableField<MessagesRecord, String> MESSAGE = createField("message", org.jooq.impl.SQLDataType.VARCHAR(1000).nullable(false), this, "");

    /**
     * The column <code>DBnewLogrExtra.messages.title</code>.
     */
    public final TableField<MessagesRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(1000), this, "");

    /**
     * The column <code>DBnewLogrExtra.messages.status</code>.
     */
    public final TableField<MessagesRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR(1000).nullable(false), this, "");

    /**
     * The column <code>DBnewLogrExtra.messages.is_new</code>.
     */
    public final TableField<MessagesRecord, Byte> IS_NEW = createField("is_new", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>DBnewLogrExtra.messages.created</code>.
     */
    public final TableField<MessagesRecord, Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>DBnewLogrExtra.messages.updated</code>.
     */
    public final TableField<MessagesRecord, Timestamp> UPDATED = createField("updated", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>DBnewLogrExtra.messages</code> table reference
     */
    public Messages() {
        this(DSL.name("messages"), null);
    }

    /**
     * Create an aliased <code>DBnewLogrExtra.messages</code> table reference
     */
    public Messages(String alias) {
        this(DSL.name(alias), MESSAGES);
    }

    /**
     * Create an aliased <code>DBnewLogrExtra.messages</code> table reference
     */
    public Messages(Name alias) {
        this(alias, MESSAGES);
    }

    private Messages(Name alias, Table<MessagesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Messages(Name alias, Table<MessagesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Newlogrextra.NEWLOGREXTRA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.MESSAGES_IDX_DB021E96C39BEDB9, Indexes.MESSAGES_IDX_DB021E96CFD06601, Indexes.MESSAGES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MessagesRecord, Integer> getIdentity() {
        return Keys.IDENTITY_MESSAGES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MessagesRecord> getPrimaryKey() {
        return Keys.KEY_MESSAGES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MessagesRecord>> getKeys() {
        return Arrays.<UniqueKey<MessagesRecord>>asList(Keys.KEY_MESSAGES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Messages as(String alias) {
        return new Messages(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Messages as(Name alias) {
        return new Messages(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Messages rename(String name) {
        return new Messages(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Messages rename(Name name) {
        return new Messages(name, null);
    }
}
