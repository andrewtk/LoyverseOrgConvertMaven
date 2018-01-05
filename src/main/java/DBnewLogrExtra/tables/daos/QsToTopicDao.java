/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables.daos;


import DBnewLogrExtra.tables.pojos.QsToTopic;
import DBnewLogrExtra.tables.records.QsToTopicRecord;
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
public class QsToTopicDao extends DAOImpl<QsToTopicRecord, QsToTopic, Integer> {

    /**
     * Create a new QsToTopicDao without any configuration
     */
    public QsToTopicDao() {
        super(DBnewLogrExtra.tables.QsToTopic.QS_TO_TOPIC, QsToTopic.class);
    }

    /**
     * Create a new QsToTopicDao with an attached configuration
     */
    public QsToTopicDao(Configuration configuration) {
        super(DBnewLogrExtra.tables.QsToTopic.QS_TO_TOPIC, QsToTopic.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(QsToTopic object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<QsToTopic> fetchById(Integer... values) {
        return fetch(DBnewLogrExtra.tables.QsToTopic.QS_TO_TOPIC.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public QsToTopic fetchOneById(Integer value) {
        return fetchOne(DBnewLogrExtra.tables.QsToTopic.QS_TO_TOPIC.ID, value);
    }

    /**
     * Fetch records that have <code>tpid IN (values)</code>
     */
    public List<QsToTopic> fetchByTpid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.QsToTopic.QS_TO_TOPIC.TPID, values);
    }

    /**
     * Fetch records that have <code>qsid IN (values)</code>
     */
    public List<QsToTopic> fetchByQsid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.QsToTopic.QS_TO_TOPIC.QSID, values);
    }
}