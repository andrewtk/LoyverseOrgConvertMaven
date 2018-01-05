/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.daos;


import java.util.List;

import javax.annotation.Generated;

import DBlorg.tables.pojos.QaOptions;
import DBlorg.tables.records.QaOptionsRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class QaOptionsDao extends DAOImpl<QaOptionsRecord, QaOptions, String> {

    /**
     * Create a new QaOptionsDao without any configuration
     */
    public QaOptionsDao() {
        super(DBlorg.tables.QaOptions.QA_OPTIONS, QaOptions.class);
    }

    /**
     * Create a new QaOptionsDao with an attached configuration
     */
    public QaOptionsDao(Configuration configuration) {
        super(DBlorg.tables.QaOptions.QA_OPTIONS, QaOptions.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(QaOptions object) {
        return object.getTitle();
    }

    /**
     * Fetch records that have <code>title IN (values)</code>
     */
    public List<QaOptions> fetchByTitle(String... values) {
        return fetch(DBlorg.tables.QaOptions.QA_OPTIONS.TITLE, values);
    }

    /**
     * Fetch a unique record that has <code>title = value</code>
     */
    public QaOptions fetchOneByTitle(String value) {
        return fetchOne(DBlorg.tables.QaOptions.QA_OPTIONS.TITLE, value);
    }

    /**
     * Fetch records that have <code>content IN (values)</code>
     */
    public List<QaOptions> fetchByContent(String... values) {
        return fetch(DBlorg.tables.QaOptions.QA_OPTIONS.CONTENT, values);
    }
}