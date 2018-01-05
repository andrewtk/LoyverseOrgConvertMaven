/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables.daos;


import DBnewLogrExtra.tables.pojos.Logger;
import DBnewLogrExtra.tables.records.LoggerRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
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
public class LoggerDao extends DAOImpl<LoggerRecord, Logger, Integer> {

    /**
     * Create a new LoggerDao without any configuration
     */
    public LoggerDao() {
        super(DBnewLogrExtra.tables.Logger.LOGGER, Logger.class);
    }

    /**
     * Create a new LoggerDao with an attached configuration
     */
    public LoggerDao(Configuration configuration) {
        super(DBnewLogrExtra.tables.Logger.LOGGER, Logger.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(Logger object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<Logger> fetchById(Integer... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Logger fetchOneById(Integer value) {
        return fetchOne(DBnewLogrExtra.tables.Logger.LOGGER.ID, value);
    }

    /**
     * Fetch records that have <code>action IN (values)</code>
     */
    public List<Logger> fetchByAction(Integer... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.ACTION, values);
    }

    /**
     * Fetch records that have <code>userid IN (values)</code>
     */
    public List<Logger> fetchByUserid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.USERID, values);
    }

    /**
     * Fetch records that have <code>answid IN (values)</code>
     */
    public List<Logger> fetchByAnswid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.ANSWID, values);
    }

    /**
     * Fetch records that have <code>qsid IN (values)</code>
     */
    public List<Logger> fetchByQsid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.QSID, values);
    }

    /**
     * Fetch records that have <code>comid IN (values)</code>
     */
    public List<Logger> fetchByComid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.COMID, values);
    }

    /**
     * Fetch records that have <code>user_susp_id IN (values)</code>
     */
    public List<Logger> fetchByUserSuspId(Integer... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.USER_SUSP_ID, values);
    }

    /**
     * Fetch records that have <code>permitid IN (values)</code>
     */
    public List<Logger> fetchByPermitid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.PERMITID, values);
    }

    /**
     * Fetch records that have <code>topicid IN (values)</code>
     */
    public List<Logger> fetchByTopicid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.TOPICID, values);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<Logger> fetchByStatus(String... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.STATUS, values);
    }

    /**
     * Fetch records that have <code>created IN (values)</code>
     */
    public List<Logger> fetchByCreated(Timestamp... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.CREATED, values);
    }

    /**
     * Fetch records that have <code>updated IN (values)</code>
     */
    public List<Logger> fetchByUpdated(Timestamp... values) {
        return fetch(DBnewLogrExtra.tables.Logger.LOGGER.UPDATED, values);
    }
}