import com.github.slugify.Slugify;

import java.io.IOException;
import java.sql.*;

import java.util.List;


public class InsertTopics {
    private static final String url = "jdbc:mysql://localhost:3306/lorg";
    private static final String user = "root";
    private static final String password = "root";

    private static final String url2 = "jdbc:mysql://localhost:3306/newLogrExtra?autoReconnect=true&useSSL=false";
    private static final String userLORG2 = "root";
    private static final String passwordLORG2 = "root";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    public static void main(String args[]) throws IOException {
        String queryTopic = "SELECT * FROM topics";
        List<List<String>> listOfTopic = ReadDB.readFromFile("D:\\Tempdir\\topic.csv", false);
        String fileNameOfTopicRel = "D:\\Tempdir\\" + "oldnewIdTopic";
        try {
            System.out.println("\nConnecting to a selected database...");
            con = DriverManager.getConnection(url2, userLORG2, passwordLORG2);
            System.out.println("Connected database successfully...");
            stmt = con.createStatement();

            insertTopics(queryTopic, listOfTopic, fileNameOfTopicRel);

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
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything*/ }
        }
    }

    /**
     * метод вставки тем в новую базу со связками
     *
     * @param queryTopic         SQL запрос в старую базу в таблицу топиков
     * @param listOfTopic        список тем в массиве
     * @param fileNameOfTopicRel название файла в котором храниться база соответсвия
     * @throws SQLException
     */

    public static void insertTopics(String queryTopic, List<List<String>> listOfTopic, String fileNameOfTopicRel) throws SQLException {
        Slugify slg = new Slugify();
        int slugInc = 0;
        String query_qaPostTags = "SELECT" +
                "  qa_posts.postid AS qid," +
                "  qa_words.wordid AS wid," +
                "  qa_topics.id AS tid," +
                "  qa_topics.topic AS topic" +
                " FROM qa_words" +
                "  LEFT JOIN qa_topics ON topic = word" +
                "  LEFT JOIN qa_posttags ON qa_words.wordid = qa_posttags.wordid" +
                "  LEFT JOIN qa_posts ON qa_posttags.postid = qa_posts.postid" +
                " WHERE topic IS NOT NULL and qa_posts.postid is not NULL and qa_posts.type like \"%Q%\" AND qa_topics.id=";

        for (List<String> line : listOfTopic) {
            String insertSQLTopic = "INSERT INTO topics (topic, content, slug, cropic, segment)" +
                    "VALUES (?,'here need short explanation about topic',?,'default_topic.jpeg', 'eng')";
            PreparedStatement statement = con.prepareStatement(insertSQLTopic, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, line.get(1));
            String slug = slg.slugify(line.get(1));// слаг для топика
            statement.setString(2, slug);

            int affectedRow = statement.executeUpdate();
            if (affectedRow == 0) {
                System.out.println("Создание строки не удалось - topic " + line.get(1));
            } else {
                ReadDB.receiveIDinNewDB(line, statement);
                ReadDB.saveToFileTableOfRelation(line.get(0), line.get(line.size() - 1), fileNameOfTopicRel);
            }
            //todo сделать запись в таблицу связки айдишники
            ReadDB.progressBar(slugInc++, slug);

        }

        //создание таблицы связки
        String insertSQL_qs_to_topic = "INSERT INTO qs_to_topic (tpid, qsid) VALUES (?,?)";

        //String topicId = ReadDB.takeNewIdFromFile(oldTopicId,listOfTopic);

        //


        System.out.println("вывод актуальной таблицы топиков - временное решение");
        rs = stmt.executeQuery(queryTopic);
        while (rs.next()) {
            String topic = rs.getString(2);
            int id = rs.getInt(1);
            System.out.println("index is  : " + id + " название: " + topic);
        }

    }
}




