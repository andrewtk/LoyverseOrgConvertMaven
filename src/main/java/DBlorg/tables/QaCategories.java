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
import DBlorg.tables.records.QaCategoriesRecord;
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
import org.jooq.types.UShort;


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
public class QaCategories extends TableImpl<QaCategoriesRecord> {

    private static final long serialVersionUID = -1987913204;

    /**
     * The reference instance of <code>DBlorg.qa_categories</code>
     */
    public static final QaCategories QA_CATEGORIES = new QaCategories();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QaCategoriesRecord> getRecordType() {
        return QaCategoriesRecord.class;
    }

    /**
     * The column <code>DBlorg.qa_categories.categoryid</code>.
     */
    public final TableField<QaCategoriesRecord, UInteger> CATEGORYID = createField("categoryid", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>DBlorg.qa_categories.parentid</code>.
     */
    public final TableField<QaCategoriesRecord, UInteger> PARENTID = createField("parentid", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>DBlorg.qa_categories.title</code>.
     */
    public final TableField<QaCategoriesRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(80).nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_categories.tags</code>.
     */
    public final TableField<QaCategoriesRecord, String> TAGS = createField("tags", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_categories.content</code>.
     */
    public final TableField<QaCategoriesRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.VARCHAR(800).nullable(false).defaultValue(DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>DBlorg.qa_categories.qcount</code>.
     */
    public final TableField<QaCategoriesRecord, UInteger> QCOUNT = createField("qcount", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(DSL.inline("0", org.jooq.impl.SQLDataType.INTEGERUNSIGNED)), this, "");

    /**
     * The column <code>DBlorg.qa_categories.position</code>.
     */
    public final TableField<QaCategoriesRecord, UShort> POSITION = createField("position", org.jooq.impl.SQLDataType.SMALLINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>DBlorg.qa_categories.backpath</code>.
     */
    public final TableField<QaCategoriesRecord, String> BACKPATH = createField("backpath", org.jooq.impl.SQLDataType.VARCHAR(804).nullable(false).defaultValue(DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>DBlorg.qa_categories</code> table reference
     */
    public QaCategories() {
        this(DSL.name("qa_categories"), null);
    }

    /**
     * Create an aliased <code>DBlorg.qa_categories</code> table reference
     */
    public QaCategories(String alias) {
        this(DSL.name(alias), QA_CATEGORIES);
    }

    /**
     * Create an aliased <code>DBlorg.qa_categories</code> table reference
     */
    public QaCategories(Name alias) {
        this(alias, QA_CATEGORIES);
    }

    private QaCategories(Name alias, Table<QaCategoriesRecord> aliased) {
        this(alias, aliased, null);
    }

    private QaCategories(Name alias, Table<QaCategoriesRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.QA_CATEGORIES_BACKPATH, Indexes.QA_CATEGORIES_PARENTID, Indexes.QA_CATEGORIES_PARENTID_2, Indexes.QA_CATEGORIES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<QaCategoriesRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_QA_CATEGORIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<QaCategoriesRecord> getPrimaryKey() {
        return Keys.KEY_QA_CATEGORIES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<QaCategoriesRecord>> getKeys() {
        return Arrays.<UniqueKey<QaCategoriesRecord>>asList(Keys.KEY_QA_CATEGORIES_PRIMARY, Keys.KEY_QA_CATEGORIES_PARENTID, Keys.KEY_QA_CATEGORIES_PARENTID_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaCategories as(String alias) {
        return new QaCategories(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaCategories as(Name alias) {
        return new QaCategories(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public QaCategories rename(String name) {
        return new QaCategories(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QaCategories rename(Name name) {
        return new QaCategories(name, null);
    }
}