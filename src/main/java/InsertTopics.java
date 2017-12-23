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



    public static void main(String args[]) throws IOException, SQLException {
        String queryTopic = " ";
        List<List<String>> listOfTopic = ReadDB.readFromFile("D:\\Tempdir\\topic.csv", false);
        String fileNameOfTopicRel = "D:\\Tempdir\\" + "oldnewIdTopic";
        insertTopics(queryTopic,listOfTopic,fileNameOfTopicRel);
    }

    /**
     * метод вставки тем в новую базу со связками
     * @param queryTopic SQL запрос в старую базу в таблицу топиков
     * @param listOfTopic список тем в массиве
     * @param fileNameOfTopicRel название файла в котором храниться база соответсвия
     * @throws SQLException
     */

    public static void insertTopics(String queryTopic, List<List<String>> listOfTopic, String fileNameOfTopicRel) throws SQLException {
        Slugify slg = new Slugify();
        int slugInc=0;
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
            ReadDB.progressBar(slugInc++,slug);
            ReadDB.receiveIDinNewDB(line, statement);
        }
        rs = stmt.executeQuery(queryTopic);
        while (rs.next()) {
            String topic = rs.getString(2);
            int id = rs.getInt(1);
            System.out.println("index is  : " + id + " название: " + topic);
        }

    }
}




