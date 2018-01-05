/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables.daos;


import DBnewLogrExtra.tables.pojos.UserToVotes;
import DBnewLogrExtra.tables.records.UserToVotesRecord;
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
public class UserToVotesDao extends DAOImpl<UserToVotesRecord, UserToVotes, Integer> {

    /**
     * Create a new UserToVotesDao without any configuration
     */
    public UserToVotesDao() {
        super(DBnewLogrExtra.tables.UserToVotes.USER_TO_VOTES, UserToVotes.class);
    }

    /**
     * Create a new UserToVotesDao with an attached configuration
     */
    public UserToVotesDao(Configuration configuration) {
        super(DBnewLogrExtra.tables.UserToVotes.USER_TO_VOTES, UserToVotes.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(UserToVotes object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<UserToVotes> fetchById(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToVotes.USER_TO_VOTES.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public UserToVotes fetchOneById(Integer value) {
        return fetchOne(DBnewLogrExtra.tables.UserToVotes.USER_TO_VOTES.ID, value);
    }

    /**
     * Fetch records that have <code>usid IN (values)</code>
     */
    public List<UserToVotes> fetchByUsid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToVotes.USER_TO_VOTES.USID, values);
    }

    /**
     * Fetch records that have <code>qsid IN (values)</code>
     */
    public List<UserToVotes> fetchByQsid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToVotes.USER_TO_VOTES.QSID, values);
    }

    /**
     * Fetch records that have <code>answid IN (values)</code>
     */
    public List<UserToVotes> fetchByAnswid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToVotes.USER_TO_VOTES.ANSWID, values);
    }

    /**
     * Fetch records that have <code>comid IN (values)</code>
     */
    public List<UserToVotes> fetchByComid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToVotes.USER_TO_VOTES.COMID, values);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<UserToVotes> fetchByType(String... values) {
        return fetch(DBnewLogrExtra.tables.UserToVotes.USER_TO_VOTES.TYPE, values);
    }
}