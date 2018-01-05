/*
 * This file is generated by jOOQ.
*/
package DBnewLogrExtra.tables.daos;


import DBnewLogrExtra.tables.pojos.UserToFavorites;
import DBnewLogrExtra.tables.records.UserToFavoritesRecord;
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
public class UserToFavoritesDao extends DAOImpl<UserToFavoritesRecord, UserToFavorites, Integer> {

    /**
     * Create a new UserToFavoritesDao without any configuration
     */
    public UserToFavoritesDao() {
        super(DBnewLogrExtra.tables.UserToFavorites.USER_TO_FAVORITES, UserToFavorites.class);
    }

    /**
     * Create a new UserToFavoritesDao with an attached configuration
     */
    public UserToFavoritesDao(Configuration configuration) {
        super(DBnewLogrExtra.tables.UserToFavorites.USER_TO_FAVORITES, UserToFavorites.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(UserToFavorites object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<UserToFavorites> fetchById(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToFavorites.USER_TO_FAVORITES.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public UserToFavorites fetchOneById(Integer value) {
        return fetchOne(DBnewLogrExtra.tables.UserToFavorites.USER_TO_FAVORITES.ID, value);
    }

    /**
     * Fetch records that have <code>usid IN (values)</code>
     */
    public List<UserToFavorites> fetchByUsid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToFavorites.USER_TO_FAVORITES.USID, values);
    }

    /**
     * Fetch records that have <code>qsid IN (values)</code>
     */
    public List<UserToFavorites> fetchByQsid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToFavorites.USER_TO_FAVORITES.QSID, values);
    }

    /**
     * Fetch records that have <code>answid IN (values)</code>
     */
    public List<UserToFavorites> fetchByAnswid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToFavorites.USER_TO_FAVORITES.ANSWID, values);
    }

    /**
     * Fetch records that have <code>usidfav IN (values)</code>
     */
    public List<UserToFavorites> fetchByUsidfav(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToFavorites.USER_TO_FAVORITES.USIDFAV, values);
    }

    /**
     * Fetch records that have <code>topid IN (values)</code>
     */
    public List<UserToFavorites> fetchByTopid(Integer... values) {
        return fetch(DBnewLogrExtra.tables.UserToFavorites.USER_TO_FAVORITES.TOPID, values);
    }
}