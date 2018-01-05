/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables;


import DBnewLogrExtra.Indexes;
import DBnewLogrExtra.Keys;
import DBnewLogrExtra.Newlogrextra;
import DBnewLogrExtra.tables.records.CommentsRecord;
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
public class Comments extends TableImpl<CommentsRecord> {

    private static final long serialVersionUID = -1196468862;

    /**
     * The reference instance of <code>DBnewLogrExtra.comments</code>
     */
    public static final Comments COMMENTS = new Comments();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CommentsRecord> getRecordType() {
        return CommentsRecord.class;
    }

    /**
     * The column <code>DBnewLogrExtra.comments.id</code>.
     */
    public final TableField<CommentsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>DBnewLogrExtra.comments.answid</code>.
     */
    public final TableField<CommentsRecord, Integer> ANSWID = createField("answid", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>DBnewLogrExtra.comments.qsid</code>.
     */
    public final TableField<CommentsRecord, Integer> QSID = createField("qsid", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>DBnewLogrExtra.comments.comid</code>.
     */
    public final TableField<CommentsRecord, Integer> COMID = createField("comid", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>DBnewLogrExtra.comments.userid</code>.
     */
    public final TableField<CommentsRecord, Integer> USERID = createField("userid", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>DBnewLogrExtra.comments.content</code>.
     */
    public final TableField<CommentsRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.VARCHAR(3072).nullable(false), this, "");

    /**
     * The column <code>DBnewLogrExtra.comments.depth</code>.
     */
    public final TableField<CommentsRecord, Integer> DEPTH = createField("depth", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DBnewLogrExtra.comments.mailme</code>.
     */
    public final TableField<CommentsRecord, Byte> MAILME = createField("mailme", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>DBnewLogrExtra.comments.created</code>.
     */
    public final TableField<CommentsRecord, Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>DBnewLogrExtra.comments.updated</code>.
     */
    public final TableField<CommentsRecord, Timestamp> UPDATED = createField("updated", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>DBnewLogrExtra.comments</code> table reference
     */
    public Comments() {
        this(DSL.name("comments"), null);
    }

    /**
     * Create an aliased <code>DBnewLogrExtra.comments</code> table reference
     */
    public Comments(String alias) {
        this(DSL.name(alias), COMMENTS);
    }

    /**
     * Create an aliased <code>DBnewLogrExtra.comments</code> table reference
     */
    public Comments(Name alias) {
        this(alias, COMMENTS);
    }

    private Comments(Name alias, Table<CommentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Comments(Name alias, Table<CommentsRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.COMMENTS_IDX_5F9E962A5A90BB43, Indexes.COMMENTS_IDX_5F9E962A82BCB078, Indexes.COMMENTS_IDX_5F9E962AC51A3009, Indexes.COMMENTS_IDX_5F9E962AF132696E, Indexes.COMMENTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CommentsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_COMMENTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CommentsRecord> getPrimaryKey() {
        return Keys.KEY_COMMENTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CommentsRecord>> getKeys() {
        return Arrays.<UniqueKey<CommentsRecord>>asList(Keys.KEY_COMMENTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Comments as(String alias) {
        return new Comments(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Comments as(Name alias) {
        return new Comments(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Comments rename(String name) {
        return new Comments(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Comments rename(Name name) {
        return new Comments(name, null);
    }
}