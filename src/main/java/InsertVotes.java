import com.github.slugify.Slugify;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
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

        String fileNameOfQuestionRel = "D:\\TempDir\\" + "old_New_Id_Questions";
        String fileNameOfAnswerRel = "D:\\TempDir\\" + "old_new_Id_Answers";
        String fileNameOfTopicRel = "D:\\TempDir\\" + "old_new_Id_Topics";
        String fileNameOfCommentRel = "D:\\TempDir\\" + "old_new_Id_Comments";
        String fileNameOfVoteRel = "D:\\TempDir\\" + "old_new_Id_Votes";
        String fileNameOfUserRel = "D:\\TempDir\\" + "old_new_Id_Users";
        String fileNameOfSlugs = "D:\\TempDir\\" + "slugs.txt";

        List<List<String>> list_Old_New_Id_Q = ReadDB.readFromFile(fileNameOfQuestionRel, false, ",");
        List<List<String>> list_Old_New_Id_A = ReadDB.readFromFile(fileNameOfAnswerRel, false, ",");
        List<List<String>> list_Old_New_Id_C = ReadDB.readFromFile(fileNameOfCommentRel, false, ",");
        List<List<String>> list_Old_New_Id_U = ReadDB.readFromFile(fileNameOfUserRel, false, ",");
        try {
            insertVote(
                    list_Old_New_Id_Q,
                    list_Old_New_Id_A,
                    list_Old_New_Id_C,
                    list_Old_New_Id_U
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*

        try {
            System.out.println("\nConnecting to a selected database...");
            con = DriverManager.getConnection(urlLORG2, userLORG2, passwordLORG2);
            System.out.println("Connected database successfully...");
            stmt = con.createStatement();
            System.out.println("Очищаем бд от старых данных");
            String deleteLines = "delete from topics Where id>76";
            stmt.executeUpdate(deleteLines);



        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { *//*can't do anything*//* }
            try {
                stmt.close();
            } catch (SQLException se) { *//*can't do anything*//* }
         *//* try {
                resultSetQueryPOST_TOPIC.close();
            } catch (SQLException se) { }*//*
        }*/
    }


    public static void insertVote(List<List<String>> listOfQuestions,
                                  List<List<String>> listOfAnswers,
                                  List<List<String>> listOfComments,
                                  List<List<String>> listOfUsers
    ) throws SQLException, IOException {

        int slugInc = 0;
        String query_old_VotesforUser = "SELECT vote.postid,post.type,vote.userid, vote.vote " +
                " FROM qa_uservotes vote " +
                "  LEFT JOIN qa_posts post ON vote.postid = post.postid " +
                " WHERE vote.postid=";
        String insertSQLVote = "INSERT INTO votes (qsid, answid, comid,balance,upvotes,downvotes)" +
                "VALUES (?,?,?,?,?,?)";
        String insertSQLUserToVote = "INSERT INTO user_to_votes (usid, qsid, answid, comid, type)" +
                "VALUES (?,?,?,?,?)";
        String queryUniqPostID = "SELECT DISTINCT\n" +
                "  votes.postid\n" +
                "FROM qa_uservotes";

        try {
            con = DriverManager.getConnection(url, user, password);
            con2 = DriverManager.getConnection(urlLORG2, userLORG2, passwordLORG2);
            stmt = con.createStatement();// опрос старой базы
            stmt2 = con2.createStatement(); // для записи в новую базу
            PreparedStatement insertStatement_Vote = con2.prepareStatement(insertSQLVote);
            PreparedStatement insertStatement_User_to_Vote = con2.prepareStatement(insertSQLUserToVote);
            resultSet = stmt.executeQuery(queryUniqPostID);
            List<String> listOfOldUserID = new ArrayList();

            while (resultSet.next()) {
                listOfOldUserID.add(resultSet.getString(1));
            }
            try {
                resultSet.close();
            } catch (SQLException se) {
            }
            for (String oldUserID : listOfOldUserID) {
                String queryOldPlusID = query_old_VotesforUser + oldUserID;
                resultSet = stmt.executeQuery(queryOldPlusID);// выборка списка по текущему старому userID
                int upVotes = 0, downVotes = 0, balance = upVotes + downVotes;
                String newQuestionID, newAnswerID, newCommentID;
                String typeOf_user_to_votes;
                while (resultSet.next()) {
                    newQuestionID = null;
                    newAnswerID = null;
                    newCommentID = null;
                    String typeOfPostID = resultSet.getString(2);
                    String oldUserId = resultSet.getString(3);

                    String newUserID = ReadDB.takeNewIdFromFile(oldUserId, listOfUsers);
                    int vote = resultSet.getInt(4);

                    if (vote > 0) {
                        upVotes += vote;
                        typeOf_user_to_votes = "upvote";
                    } else if (vote < 0) {
                        downVotes += Math.abs(vote);
                        typeOf_user_to_votes = "downvote";
                    } else {
                        typeOf_user_to_votes = "zero";
                    }
                    balance += (upVotes - downVotes);

                    if (typeOfPostID.contains("Q")) {
                        newQuestionID = ReadDB.takeNewIdFromFile(oldUserID, listOfQuestions);
                    } else if (typeOfPostID.contains("A")) {
                        newAnswerID = ReadDB.takeNewIdFromFile(oldUserID, listOfAnswers);
                    } else if (typeOfPostID.contains("C")) {
                        newCommentID = ReadDB.takeNewIdFromFile(oldUserID, listOfComments);
                    }

                    insertStatement_User_to_Vote.setString(1, newUserID);
                    insertStatement_User_to_Vote.setString(2, newQuestionID);
                    insertStatement_User_to_Vote.setString(3, newAnswerID);
                    insertStatement_User_to_Vote.setString(4, newCommentID);
                    insertStatement_User_to_Vote.setString(5, typeOf_user_to_votes);


                    insertStatement_Vote.setString(1, newQuestionID);
                    insertStatement_Vote.setString(2, newAnswerID);
                    insertStatement_Vote.setString(3, newCommentID);
                    insertStatement_Vote.setInt(4, balance);
                    insertStatement_Vote.setInt(5, upVotes);
                    insertStatement_Vote.setInt(6, downVotes);


                    int affectedRowNewTable = insertStatement_User_to_Vote.executeUpdate();
                    if (affectedRowNewTable == 0) {
                        System.out.println("Создание записи в таблице 'User_to_Votes' не удалось " + newQuestionID);
                    }
                    affectedRowNewTable = insertStatement_Vote.executeUpdate();
                    if (affectedRowNewTable == 0) {
                        System.out.println("Создание записи в таблице 'votes' не удалось " + newQuestionID);
                    }

                }
                try {
                    resultSet.close();
                } catch (SQLException se) {
                }
                ReadDB.progressBar(slugInc++, "");
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




