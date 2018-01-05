/*
 * This file is generated by jOOQ.
*/
package DBlorg.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import DBlorg.tables.QaAchievements;
import org.jooq.Field;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.TableRecordImpl;


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
public class QaAchievementsRecord extends TableRecordImpl<QaAchievementsRecord> implements Record8<Integer, Timestamp, Timestamp, Integer, Timestamp, Integer, Integer, Integer> {

    private static final long serialVersionUID = 499105909;

    /**
     * Setter for <code>DBlorg.qa_achievements.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>DBlorg.qa_achievements.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>DBlorg.qa_achievements.first_visit</code>.
     */
    public void setFirstVisit(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>DBlorg.qa_achievements.first_visit</code>.
     */
    public Timestamp getFirstVisit() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>DBlorg.qa_achievements.oldest_consec_visit</code>.
     */
    public void setOldestConsecVisit(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>DBlorg.qa_achievements.oldest_consec_visit</code>.
     */
    public Timestamp getOldestConsecVisit() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>DBlorg.qa_achievements.longest_consec_visit</code>.
     */
    public void setLongestConsecVisit(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>DBlorg.qa_achievements.longest_consec_visit</code>.
     */
    public Integer getLongestConsecVisit() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>DBlorg.qa_achievements.last_visit</code>.
     */
    public void setLastVisit(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>DBlorg.qa_achievements.last_visit</code>.
     */
    public Timestamp getLastVisit() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>DBlorg.qa_achievements.total_days_visited</code>.
     */
    public void setTotalDaysVisited(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>DBlorg.qa_achievements.total_days_visited</code>.
     */
    public Integer getTotalDaysVisited() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>DBlorg.qa_achievements.questions_read</code>.
     */
    public void setQuestionsRead(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>DBlorg.qa_achievements.questions_read</code>.
     */
    public Integer getQuestionsRead() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>DBlorg.qa_achievements.posts_edited</code>.
     */
    public void setPostsEdited(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>DBlorg.qa_achievements.posts_edited</code>.
     */
    public Integer getPostsEdited() {
        return (Integer) get(7);
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Timestamp, Timestamp, Integer, Timestamp, Integer, Integer, Integer> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Timestamp, Timestamp, Integer, Timestamp, Integer, Integer, Integer> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return QaAchievements.QA_ACHIEVEMENTS.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return QaAchievements.QA_ACHIEVEMENTS.FIRST_VISIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return QaAchievements.QA_ACHIEVEMENTS.OLDEST_CONSEC_VISIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return QaAchievements.QA_ACHIEVEMENTS.LONGEST_CONSEC_VISIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return QaAchievements.QA_ACHIEVEMENTS.LAST_VISIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return QaAchievements.QA_ACHIEVEMENTS.TOTAL_DAYS_VISITED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return QaAchievements.QA_ACHIEVEMENTS.QUESTIONS_READ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return QaAchievements.QA_ACHIEVEMENTS.POSTS_EDITED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component2() {
        return getFirstVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getOldestConsecVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getLongestConsecVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getLastVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getTotalDaysVisited();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getQuestionsRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getPostsEdited();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value2() {
        return getFirstVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getOldestConsecVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getLongestConsecVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getLastVisit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getTotalDaysVisited();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getQuestionsRead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getPostsEdited();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaAchievementsRecord value1(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaAchievementsRecord value2(Timestamp value) {
        setFirstVisit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaAchievementsRecord value3(Timestamp value) {
        setOldestConsecVisit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaAchievementsRecord value4(Integer value) {
        setLongestConsecVisit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaAchievementsRecord value5(Timestamp value) {
        setLastVisit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaAchievementsRecord value6(Integer value) {
        setTotalDaysVisited(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaAchievementsRecord value7(Integer value) {
        setQuestionsRead(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaAchievementsRecord value8(Integer value) {
        setPostsEdited(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QaAchievementsRecord values(Integer value1, Timestamp value2, Timestamp value3, Integer value4, Timestamp value5, Integer value6, Integer value7, Integer value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QaAchievementsRecord
     */
    public QaAchievementsRecord() {
        super(QaAchievements.QA_ACHIEVEMENTS);
    }

    /**
     * Create a detached, initialised QaAchievementsRecord
     */
    public QaAchievementsRecord(Integer userId, Timestamp firstVisit, Timestamp oldestConsecVisit, Integer longestConsecVisit, Timestamp lastVisit, Integer totalDaysVisited, Integer questionsRead, Integer postsEdited) {
        super(QaAchievements.QA_ACHIEVEMENTS);

        set(0, userId);
        set(1, firstVisit);
        set(2, oldestConsecVisit);
        set(3, longestConsecVisit);
        set(4, lastVisit);
        set(5, totalDaysVisited);
        set(6, questionsRead);
        set(7, postsEdited);
    }
}