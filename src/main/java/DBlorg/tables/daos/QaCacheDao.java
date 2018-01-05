/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import DBlorg.tables.pojos.QaCache;
import DBlorg.tables.records.QaCacheRecord;
import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;
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
public class QaCacheDao extends DAOImpl<QaCacheRecord, QaCache, Record2<String, ULong>> {

    /**
     * Create a new QaCacheDao without any configuration
     */
    public QaCacheDao() {
        super(DBlorg.tables.QaCache.QA_CACHE, QaCache.class);
    }

    /**
     * Create a new QaCacheDao with an attached configuration
     */
    public QaCacheDao(Configuration configuration) {
        super(DBlorg.tables.QaCache.QA_CACHE, QaCache.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Record2<String, ULong> getId(QaCache object) {
        return compositeKeyRecord(object.getType(), object.getCacheid());
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<QaCache> fetchByType(String... values) {
        return fetch(DBlorg.tables.QaCache.QA_CACHE.TYPE, values);
    }

    /**
     * Fetch records that have <code>cacheid IN (values)</code>
     */
    public List<QaCache> fetchByCacheid(ULong... values) {
        return fetch(DBlorg.tables.QaCache.QA_CACHE.CACHEID, values);
    }

    /**
     * Fetch records that have <code>content IN (values)</code>
     */
    public List<QaCache> fetchByContent(byte[]... values) {
        return fetch(DBlorg.tables.QaCache.QA_CACHE.CONTENT, values);
    }

    /**
     * Fetch records that have <code>created IN (values)</code>
     */
    public List<QaCache> fetchByCreated(Timestamp... values) {
        return fetch(DBlorg.tables.QaCache.QA_CACHE.CREATED, values);
    }

    /**
     * Fetch records that have <code>lastread IN (values)</code>
     */
    public List<QaCache> fetchByLastread(Timestamp... values) {
        return fetch(DBlorg.tables.QaCache.QA_CACHE.LASTREAD, values);
    }
}
