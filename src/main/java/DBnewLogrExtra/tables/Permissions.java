/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables;


import DBnewLogrExtra.Indexes;
import DBnewLogrExtra.Keys;
import DBnewLogrExtra.Newlogrextra;
import DBnewLogrExtra.tables.records.PermissionsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
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
public class Permissions extends TableImpl<PermissionsRecord> {

    private static final long serialVersionUID = 1312050217;

    /**
     * The reference instance of <code>DBnewLogrExtra.permissions</code>
     */
    public static final Permissions PERMISSIONS = new Permissions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PermissionsRecord> getRecordType() {
        return PermissionsRecord.class;
    }

    /**
     * The column <code>DBnewLogrExtra.permissions.id</code>.
     */
    public final TableField<PermissionsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>DBnewLogrExtra.permissions.roleid</code>.
     */
    public final TableField<PermissionsRecord, Integer> ROLEID = createField("roleid", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>DBnewLogrExtra.permissions.routeid</code>.
     */
    public final TableField<PermissionsRecord, Integer> ROUTEID = createField("routeid", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>DBnewLogrExtra.permissions.permit</code>.
     */
    public final TableField<PermissionsRecord, Byte> PERMIT = createField("permit", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * Create a <code>DBnewLogrExtra.permissions</code> table reference
     */
    public Permissions() {
        this(DSL.name("permissions"), null);
    }

    /**
     * Create an aliased <code>DBnewLogrExtra.permissions</code> table reference
     */
    public Permissions(String alias) {
        this(DSL.name(alias), PERMISSIONS);
    }

    /**
     * Create an aliased <code>DBnewLogrExtra.permissions</code> table reference
     */
    public Permissions(Name alias) {
        this(alias, PERMISSIONS);
    }

    private Permissions(Name alias, Table<PermissionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Permissions(Name alias, Table<PermissionsRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.PERMISSIONS_IDX_2DEDCC6F2D46D92A, Indexes.PERMISSIONS_IDX_2DEDCC6F7AAA87E3, Indexes.PERMISSIONS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PermissionsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PERMISSIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PermissionsRecord> getPrimaryKey() {
        return Keys.KEY_PERMISSIONS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PermissionsRecord>> getKeys() {
        return Arrays.<UniqueKey<PermissionsRecord>>asList(Keys.KEY_PERMISSIONS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Permissions as(String alias) {
        return new Permissions(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Permissions as(Name alias) {
        return new Permissions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Permissions rename(String name) {
        return new Permissions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Permissions rename(Name name) {
        return new Permissions(name, null);
    }
}