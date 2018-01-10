import com.github.slugify.Slugify;

import java.io.IOException;
import java.sql.*;

import java.util.List;


public class InsertTopics {
    private static final String url = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    private static final String urlLORG2 = "jdbc:mysql://localhost:3306/newLogrExtra?autoReconnect=true&useSSL=false";
    private static final String userLORG2 = "root";
    private static final String passwordLORG2 = "root";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet resultSetQueryPOST_TOPIC;
    private static Connection con2;
    private static Statement stmt2;

    public static void main(String args[]) throws IOException {
        String fileNameOfQuestionRel = "D:\\Tempdir\\" + "old_New_Id_Questions";
        String fileNameOfAnswerRel = "D:\\Tempdir\\" + "old_new_Id_Answers";
        String fileNameOfTopicRel = "D:\\Tempdir\\" + "old_new_Id_Topic";
        String fileNameOfVoteRel = "D:\\Tempdir\\" + "old_new_Id_Votes";

        List<List<String>> listOfTopic = ReadDB.readFromFile("D:\\Tempdir\\topic.csv", false, ",");
        List<List<String>> listOfIDQuestions = ReadDB.readFromFile(fileNameOfQuestionRel, false, ",");

        try {
            System.out.println("\nConnecting to a selected database...");
            con = DriverManager.getConnection(urlLORG2, userLORG2, passwordLORG2);
            System.out.println("Connected database successfully...");
            stmt = con.createStatement();
            System.out.println("Очищаем бд от старых данных");
            String deleteLines = "delete from qs_to_topic Where id>=0";
            stmt.executeUpdate(deleteLines);
            deleteLines = "delete from topics Where id>=0";
            stmt.executeUpdate(deleteLines);

            insertTopics(listOfTopic, listOfIDQuestions, fileNameOfTopicRel);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything*/ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything*/ }
           /* try {
                resultSetQueryPOST_TOPIC.close();
            } catch (SQLException se) { }*/
        }
    }
    /**
     * метод вставки тем в новую базу со связками
     *
     * @param listOfTopic        список тем в массиве
     * @param fileNameOfTopicRel название файла в котором храниться база соответсвия
     * @throws SQLException
     */

    public static void insertTopics(List<List<String>> listOfTopic, List<List<String>> listOfIDQuestions, String fileNameOfTopicRel) throws SQLException {
        Slugify slg = new Slugify();
        int slugInc = 0;
        String query_qaPostTags = "SELECT" +
                "  qa_posts.postid AS qid," +
                "  qa_topics.topic AS topic" +
                " FROM qa_words" +
                "  LEFT JOIN qa_topics ON topic = word" +
                "  LEFT JOIN qa_posttags ON qa_words.wordid = qa_posttags.wordid" +
                "  LEFT JOIN qa_posts ON qa_posttags.postid = qa_posts.postid" +
                " WHERE topic IS NOT NULL and qa_posts.postid is not NULL and qa_posts.type like \"Q\" AND qa_topics.id=";
        String insertSQL_qs_to_topic = "INSERT INTO qs_to_topic (tpid, qsid) VALUES (?,?)";
        try {
            con = DriverManager.getConnection(url, user, password);
            con2 = DriverManager.getConnection(urlLORG2, userLORG2, passwordLORG2);
            stmt = con.createStatement();
            stmt2 = con2.createStatement();
            for (List<String> line : listOfTopic) {
                String insertSQLTopic = "INSERT IGNORE INTO topics (topic, content, slug, cropic, segment,created,updated,status)" +
                        "VALUES (?,'here need short explanation about topic',?,'default_topic.jpeg', 'en','2017-11-11 11:11:11','2017-11-11 11:11:11','active')";
                PreparedStatement statement = con2.prepareStatement(insertSQLTopic, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement insertStatement = con2.prepareStatement(insertSQL_qs_to_topic);
                String topic = line.get(1);
                String slug = slg.slugify(topic);// слаг для топика
                statement.setString(1, topic);
                statement.setString(2, slug);
                int affectedRow = statement.executeUpdate();
                if (affectedRow == 0) {
                    System.out.println("\nСоздание строки не удалось - topic: " + topic);
                    continue;
                }
                ReadDB.receiveIDinNewDB(line, statement);
                String oldTopicID = line.get(0);
                String newTopicID = line.get(line.size() - 1);
                ReadDB.saveToFileTableOfRelation(oldTopicID, newTopicID, fileNameOfTopicRel);

                String query_qaPostTags_plusID = query_qaPostTags + oldTopicID;
                // выборка из таблиц старой базы связки топиков с вопросами со старыми айди
                resultSetQueryPOST_TOPIC = stmt.executeQuery(query_qaPostTags_plusID);
                while (resultSetQueryPOST_TOPIC.next()) {
                    String postID = resultSetQueryPOST_TOPIC.getString(1);
                    String newQuestionID = ReadDB.takeNewIdFromFile(postID, listOfIDQuestions);
                    insertStatement.setString(1, newTopicID);
                    insertStatement.setString(2, newQuestionID);
                    ReadDB.progressBar(Integer.valueOf(newTopicID), " топик " + topic );
                    int affectedRowNewTable = insertStatement.executeUpdate();
                    if (affectedRowNewTable == 0) {
                        System.out.println("/nСоздание записи в таблице 'qs_to_topic' не удалось " + newTopicID + " " + topic);
                    }
                }
                try {
                    resultSetQueryPOST_TOPIC.close();
                } catch (SQLException se) {}
                ReadDB.progressBar(slugInc++, slug);
            }
        } finally {
            //close connection ,stmt and ResultSet here
            try {
                con.close();
                con2.close();
            } catch (SQLException se) {
            }
            try {
                stmt.close();
                stmt2.close();
            } catch (SQLException se) {
            }
        }
        System.out.println("\n Работа программы окончена");
    }
}




