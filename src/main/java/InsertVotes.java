import static DBnewLogrExtra.Tables.*;
import static DBlorg.Tables.*;
import DBlorg.tables.records.QaUservotesRecord;
import DBnewLogrExtra.tables.records.UserToVotesRecord;
import DBnewLogrExtra.tables.records.VotesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
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


    public static void main(String args[]) {
        insertVote();
    }

    public static void insertVote(List<List<String>> list_Old_New_Id_Q,
                                  List<List<String>> list_Old_New_Id_A,
                                  List<List<String>> list_Old_New_Id_C,
                                  List<List<String>> list_Old_New_Id_U) {

// learn Jooq -------------------------------------------------------------------------------------------------------
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";
        String urlNew = "jdbc:mysql://localhost:3306/newlogrExtra?autoReconnect=true&useSSL=false";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext db = DSL.using(conn, SQLDialect.MYSQL);
            try (Connection conn2 = DriverManager.getConnection(urlNew, userName, password)) {
                DSLContext dbNew = DSL.using(conn2, SQLDialect.MYSQL);
                Result<DBlorg.tables.records.QaPostsRecord> posts = db.selectFrom(DBlorg.tables.QaPosts.QA_POSTS).fetch();
                for (DBlorg.tables.records.QaPostsRecord post : posts) {
                    String newQsId = "", newAnwId = "", newComId = "";
                    UInteger postId = post.getPostid();
                    String type = post.getType().toString();

                    //заполняем таблицы votes
                    VotesRecord newRecord = new VotesRecord();
                    if (type.equals("Q")) {
                        newQsId = ReadDB.takeNewIdFromFile(postId.toString(), list_Old_New_Id_Q);
                        newRecord.setQsid(Integer.valueOf(newQsId));
                    } else if (type.equals("A")) {
                        newAnwId = ReadDB.takeNewIdFromFile(postId.toString(), list_Old_New_Id_A);
                        newRecord.setAnswid(Integer.valueOf(newAnwId));
                    } else if (type.equals("C")) {
                        newComId = ReadDB.takeNewIdFromFile(postId.toString(), list_Old_New_Id_C);
                        newRecord.setComid(Integer.valueOf(newComId));
                    } else continue;
                    newRecord.setUpvotes(post.getUpvotes().intValue());
                    newRecord.setDownvotes(post.getDownvotes().intValue());
                    newRecord.setBalance(post.getNetvotes().intValue());
                    dbNew.insertInto(VOTES).set(newRecord).execute();
                    ReadDB.progressBar(postId.intValue(), " votes ");

                    ArrayList<UserToVotesRecord> listFor_user_to_votes = new ArrayList<>();
                    //выбрать все голоса по данному посту от всех юзеров
                    Result<QaUservotesRecord> useridForPost = db.selectFrom(QA_USERVOTES).where(QA_USERVOTES.POSTID.eq(postId)).fetch();
                    //заполнение новой таблицы для текущего postID
                    for (QaUservotesRecord uTVRecord : useridForPost) {
                        //заполняем таблицы votes u user_to_votes
                        UserToVotesRecord userToVotesRecord = new UserToVotesRecord();
                        String userID = uTVRecord.getUserid();
                        Byte vote = uTVRecord.getVote();
                        userToVotesRecord.setType("zero");
                        if (vote == 1) {
                            userToVotesRecord.setType("upvote");
                        } else if (vote == -1) {
                            userToVotesRecord.setType("downvote");
                        }
                        String newUsId = ReadDB.takeNewIdFromFile(userID, list_Old_New_Id_U);
                        if (newUsId.equals("-1")) {
                            newUsId = ReadDB.takeNewIdFromFile("207394", list_Old_New_Id_U); //эккаунт userid 207394 - mustafasethalilov@gmail.com искусственный экаунт созданный для подмены
                        }
                        userToVotesRecord.setUsid(Integer.valueOf(newUsId));
                        if (type.equals("Q")) {
                            userToVotesRecord.setQsid(Integer.valueOf(newQsId));
                        } else if (type.equals("A")) {
                            userToVotesRecord.setAnswid(Integer.valueOf(newAnwId));
                        } else if (type.equals("C")) {
                            userToVotesRecord.setComid(Integer.valueOf(newComId));
                        } else continue;
                        listFor_user_to_votes.add(userToVotesRecord);

                    }
                    dbNew.batchInsert(listFor_user_to_votes).execute();
                }
                //выгрузка голосов в таблицу votes из qa_uservotes
            }
            // For the sake of this tutorial, let's keep exception handling simple
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
        //----------------------------------------------------------------------------------------------------------
    }


  /*  public static void insertVote(List<List<String>> listOfQuestions,
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

    }*/
}




