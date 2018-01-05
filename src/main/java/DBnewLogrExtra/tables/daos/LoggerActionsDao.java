/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables.daos;


import DBnewLogrExtra.tables.pojos.LoggerActions;
import DBnewLogrExtra.tables.records.LoggerActionsRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import javax.annotation.Generated;
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
public class LoggerActionsDao extends DAOImpl<LoggerActionsRecord, LoggerActions, Integer> {

    /**
     * Create a new LoggerActionsDao without any configuration
     */
    public LoggerActionsDao() {
        super(DBnewLogrExtra.tables.LoggerActions.LOGGER_ACTIONS, LoggerActions.class);
    }

    /**
     * Create a new LoggerActionsDao with an attached configuration
     */
    public LoggerActionsDao(Configuration configuration) {
        super(DBnewLogrExtra.tables.LoggerActions.LOGGER_ACTIONS, LoggerActions.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(LoggerActions object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<LoggerActions> fetchById(Integer... values) {
        return fetch(DBnewLogrExtra.tables.LoggerActions.LOGGER_ACTIONS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public LoggerActions fetchOneById(Integer value) {
        return fetchOne(DBnewLogrExtra.tables.LoggerActions.LOGGER_ACTIONS.ID, value);
    }

    /**
     * Fetch records that have <code>action IN (values)</code>
     */
    public List<LoggerActions> fetchByAction(String... values) {
        return fetch(DBnewLogrExtra.tables.LoggerActions.LOGGER_ACTIONS.ACTION, values);
    }

    /**
     * Fetch records that have <code>title IN (values)</code>
     */
    public List<LoggerActions> fetchByTitle(String... values) {
        return fetch(DBnewLogrExtra.tables.LoggerActions.LOGGER_ACTIONS.TITLE, values);
    }
}