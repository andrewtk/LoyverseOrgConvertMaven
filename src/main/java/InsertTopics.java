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
        List<List<String>> listOfTopic = ReadDB.readFromFile("D:\\Tempdir\\topic.csv", false);
        insertTopics("testquery",listOfTopic);
    }

    private static void insertTopics(String queryTopic, List<List<String>> listOfTopic) throws SQLException {
        Slugify slg = new Slugify();
        int slugInc=0;
        for (List<String> line : listOfTopic) {
            String slug = slg.slugify(line.get(1));// слаг для топика
            String insertSQLTopic = "INSERT INTO topics (topic, content, slug, cropic, segment)" +
                    "VALUES (?,'short explanation about topic',?,'default_topic.jpeg', 'eng')";
            //stmt.executeUpdate(insertSQLTopic);
            PreparedStatement statement = con.prepareStatement(insertSQLTopic, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, line.get(1));
            statement.setString(2, slug);
            int affectedRow = statement.executeUpdate();
            if (affectedRow == 0) {
                System.out.println("Создание строки не удалось - topic " + line.get(1));
            } else {
                ReadDB.receiveIDinNewDB(line, statement);
                //saveToFileTableOfRelation(line.get(0), line.get(line.size() - 1), fileNameOfAnswerRel);
            }

            try {
                String data = "\r" + "|-+".charAt(slugInc % "|-+".length()) + " " + slugInc++;
                System.out.write(data.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

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




