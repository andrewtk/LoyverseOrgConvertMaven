/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import DBlorg.tables.pojos.QaBlogComments;
import DBlorg.tables.records.QaBlogCommentsRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.jooq.types.UInteger;


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
public class QaBlogCommentsDao extends DAOImpl<QaBlogCommentsRecord, QaBlogComments, UInteger> {

    /**
     * Create a new QaBlogCommentsDao without any configuration
     */
    public QaBlogCommentsDao() {
        super(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS, QaBlogComments.class);
    }

    /**
     * Create a new QaBlogCommentsDao with an attached configuration
     */
    public QaBlogCommentsDao(Configuration configuration) {
        super(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS, QaBlogComments.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected UInteger getId(QaBlogComments object) {
        return object.getPostid();
    }

    /**
     * Fetch records that have <code>postid IN (values)</code>
     */
    public List<QaBlogComments> fetchByPostid(UInteger... values) {
        return fetch(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS.POSTID, values);
    }

    /**
     * Fetch a unique record that has <code>postid = value</code>
     */
    public QaBlogComments fetchOneByPostid(UInteger value) {
        return fetchOne(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS.POSTID, value);
    }

    /**
     * Fetch records that have <code>parentid IN (values)</code>
     */
    public List<QaBlogComments> fetchByParentid(UInteger... values) {
        return fetch(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS.PARENTID, values);
    }

    /**
     * Fetch records that have <code>posted IN (values)</code>
     */
    public List<QaBlogComments> fetchByPosted(Timestamp... values) {
        return fetch(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS.POSTED, values);
    }

    /**
     * Fetch records that have <code>comment IN (values)</code>
     */
    public List<QaBlogComments> fetchByComment(String... values) {
        return fetch(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS.COMMENT, values);
    }

    /**
     * Fetch records that have <code>userid IN (values)</code>
     */
    public List<QaBlogComments> fetchByUserid(UInteger... values) {
        return fetch(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS.USERID, values);
    }

    /**
     * Fetch records that have <code>updated IN (values)</code>
     */
    public List<QaBlogComments> fetchByUpdated(Timestamp... values) {
        return fetch(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS.UPDATED, values);
    }

    /**
     * Fetch records that have <code>format IN (values)</code>
     */
    public List<QaBlogComments> fetchByFormat(String... values) {
        return fetch(DBlorg.tables.QaBlogComments.QA_BLOG_COMMENTS.FORMAT, values);
    }
}
