import com.github.slugify.Slugify;

import java.io.IOException;
import java.sql.*;
import java.util.List;


public class InsertVotes {
    private static final String url = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    private static final String urlLORG2 = "jdbc:mysql://localhost:3306/newLogrExtra?autoReconnect=true&useSSL=false";
    private static final String userLORG2 = "root";
    private static final String passwordLORG2 = "root";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet resultSet;

    private static Connection con2;
    private static Statement stmt2;


    public static void main(String args[]) throws IOException {

        String fileNameOfQuestionRel = "D:\\Tempdir\\" + "old_New_Id_Questions";
        String fileNameOfAnswerRel = "D:\\Tempdir\\" + "old_new_Id_Answers";
        String fileNameOfTopicRel = "D:\\Tempdir\\" + "old_new_Id_Topic";
        String fileNameOfVoteRel = "D:\\Tempdir\\" + "old_new_Id_Votes";

        List<List<String>> listOfTopic = ReadDB.readFromFile("D:\\Tempdir\\topic.csv", false);
        List<List<String>> listOfIDQuestions = ReadDB.readFromFile(fileNameOfQuestionRel, false);

        try {
            System.out.println("\nConnecting to a selected database...");
            con = DriverManager.getConnection(urlLORG2, userLORG2, passwordLORG2);
            System.out.println("Connected database successfully...");
            stmt = con.createStatement();
            System.out.println("Очищаем бд от старых данных");
            //String deleteLines = "delete from topics Where id>76";
            //stmt.executeUpdate(deleteLines);

            insertVote(listOfTopic, listOfIDQuestions, fileNameOfTopicRel);

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
     * @param         список тем в массиве
     * @param fileNameOfTopicRel название файла в котором храниться база соответсвия
     * @throws SQLException
     */

    public static void insertVote(List<List<String>> listOfQuestions,
                                  List<List<String>> listOfAnswers,
                                  List<List<String>> listOfComments,
                                  List<List<String>> listOfUsers,
                                  String fileNameOfVoteRel) throws SQLException, IOException {
        Slugify slg = new Slugify();
        int slugInc = 0;
        String query_old_VotesforUser = "SELECT vote.postid,post.type,vote.userid\n" +
                "FROM qa_uservotes vote\n" +
                "  LEFT JOIN qa_posts post ON vote.postid = post.postid\n" +
                "WHERE vote.postid=";
        String insertSQLVote = "INSERT INTO votes (qsid, answid, comid,balance,upvotes,downvotes)" +
                "VALUES (?,?,?,?,?,?)";
        String insertSQLUserToVote = "INSERT INTO user_to_votes (usid, qsid, answid, comid, type)" +
                "VALUES (?,?,?,?,?)";
        List<List<String>> listOfVotes = ReadDB.readFromFile(fileNameOfVoteRel,false);
        try {
            con = DriverManager.getConnection(url, user, password);
            con2 = DriverManager.getConnection(urlLORG2, userLORG2, passwordLORG2);
            stmt = con.createStatement();// опрос старой базы
            stmt2 = con2.createStatement(); // для записи в новую базу

            for (List<String> line : listOfVotes) {
                PreparedStatement insertStatement_Vote = con2.prepareStatement(insertSQLVote);
                PreparedStatement insertStatement_User_to_Vote = con2.prepareStatement(insertSQLVote);
                String oldPostID = line.get(1);
                String queryOldPlusID = query_old_VotesforUser+oldPostID;
                resultSet = stmt.executeQuery(queryOldPlusID);
                int upvotes=0,downvotes=0, balance = upvotes+downvotes;

                while (resultSet.next()) {
                    String type = resultSet.getString(2);
                    String oldUserId = resultSet.getString(3);
                    String newUserID = ReadDB.takeNewIdFromFile(oldUserId, listOfUsers);
                    int vote = resultSet.getInt(4);

                    if (vote>=0){
                        upvotes=vote;
                    } else {
                        downvotes=vote;
                    }

                    insertStatement_User_to_Vote.setString(1, newTopicID);
                    insertStatement_User_to_Vote.setString(2, newQuestionID);
                    int affectedRowNewTable = insertStatement_User_to_Vote.executeUpdate();
                    if (affectedRowNewTable == 0) {
                        System.out.println("Создание записи в таблице 'qs_to_topic' не удалось " + newTopicID + topic);
                    }
                }
                try {
                    resultSet.close();
                } catch (SQLException se) {}
                insertStatement_Vote.setString(1, );
                insertStatement_Vote.setString(2, );
                insertStatement_Vote.setString(3, );
                insertStatement_Vote.setString(4, );
                insertStatement_Vote.setString(5, );
                insertStatement_Vote.setString(6, );

                int affectedRow = insertStatement_Vote.executeUpdate();
                if (affectedRow == 0) {
                    System.out.println("\nСоздание строки не удалось - topic: " + topic);
                    continue;
                }
                ReadDB.receiveIDinNewDB(line, insertStatement_Vote);
                String oldPostID = line.get(0);
                String newTopicID = line.get(line.size() - 1);
                //ReadDB.saveToFileTableOfRelation(oldTopicID, newTopicID, fileNameOfTopicRel);

                String query_qaPostTags_plusID = query_old_VotesforUser + oldPostID;
                // выборка из таблиц старой базы связки топиков с вопросами со старыми айди
                resultSet = stmt.executeQuery(query_qaPostTags_plusID);
                while (resultSet.next()) {
                    String postID = resultSet.getString(1);
                    String newQuestionID = ReadDB.takeNewIdFromFile(postID, listOfIDQuestions);
                    insertStatement_User_to_Vote.setString(1, newTopicID);
                    insertStatement_User_to_Vote.setString(2, newQuestionID);
                    int affectedRowNewTable = insertStatement_User_to_Vote.executeUpdate();
                    if (affectedRowNewTable == 0) {
                        System.out.println("Создание записи в таблице 'qs_to_topic' не удалось " + newTopicID + topic);
                    }
                }
                try {
                    resultSet.close();
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




