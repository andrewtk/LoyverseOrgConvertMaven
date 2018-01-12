import DBnewLogrExtra.Tables;
import DBnewLogrExtra.tables.Votes;
import com.github.slugify.Slugify;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LoadDataToLorgJooq {

    public static void main(String[] args) throws IOException {
        loadDataToLorgJooq();
    }

    public static void loadDataToLorgJooq() throws IOException {
        String fileNameOfSlugs = "D:\\TempDir\\" + "slugs.csv";
        List<List<String>> listOfTopics = ReadDB.readFromFile("D:\\TempDir\\topic.csv", false, ",");
        List<List<String>> listOfUsers = ReadDB.readFromFile("D:\\TempDir\\users.csv", false, ",");
        List<List<String>> listOfQuestions = ReadDB.readFromFile("D:\\TempDir\\questions.csv", true, ",");
        List<List<String>> listOfAnswers = ReadDB.readFromFile("D:\\TempDir\\answers.csv", true, ",");
        List<List<String>> listOfComments = ReadDB.readFromFile("D:\\TempDir\\comments.csv", true, ",");
        List<List<String>> listOfOldVotes = ReadDB.readFromFile("D:\\TempDir\\votes.csv", false, ",");
        List<List<String>> listOfSlugs = ReadDB.readFromFile(fileNameOfSlugs, false, "/");

        List<List<String>> list_Of_Old_New_Id_Questions;
        List<List<String>> list_Of_Old_New_Id_Answers;
        List<List<String>> list_Of_Old_New_Id_Comments;
        List<List<String>> list_Of_Old_New_Id_Users;
        List<List<String>> list_Of_Old_New_Id_Votes;
        List<List<String>> list_Of_Old_New_Id_Favorites;

        String fileNameOfQuestionRel = "D:\\TempDir\\" + "old_New_Id_Questions";
        String fileNameOfAnswerRel = "D:\\TempDir\\" + "old_new_Id_Answers";
        String fileNameOfTopicRel = "D:\\TempDir\\" + "old_new_Id_Topics";
        String fileNameOfCommentRel = "D:\\TempDir\\" + "old_new_Id_Comments";
        String fileNameOfVoteRel = "D:\\TempDir\\" + "old_new_Id_Votes";
        String fileNameOfUserRel = "D:\\TempDir\\" + "old_new_Id_Users";


        // JDBC URL, username and password of MySQL server
        final String url = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";
        final String url2 = "jdbc:mysql://localhost:3306/newLogrExtra?autoReconnect=true&useSSL=false";
        final String userLORG2 = "root";
        final String passwordLORG2 = "root";
        final String userName = "root";
        final String password = "root";

        System.out.println("\nConnecting to a selected database...");
        try (Connection con2 = DriverManager.getConnection(url2, userLORG2, passwordLORG2)) {
            DSLContext dbNew = DSL.using(con2, SQLDialect.MYSQL);
            try (Connection con1 = DriverManager.getConnection(url, userName, password)) {
                DSLContext dbOld = DSL.using(con1, SQLDialect.MYSQL);
                System.out.println("Connected database successfully...");

                System.out.print("Очистить базу от тестовых данных? ( Y-очистить, любая другая клавина - продолжить) ->");
                Scanner in = new Scanner(System.in);
                String doClean = in.next();
                if (doClean.toLowerCase().contains("y")) {
                    ArrayList<Integer> dbIndex = new ArrayList<>();
                    List<TableImpl> dbName = new ArrayList();

                    dbName.add(Tables.VOTES);
                    dbIndex.add(0);
                    dbName.add(Tables.QS_TO_TOPIC);
                    dbIndex.add(0);
                    dbName.add(Tables.TOPICS);
                    dbIndex.add(0);
                    dbName.add(Tables.COMMENTS);
                    dbIndex.add(0);
                    dbName.add(Tables.ANSWERS);
                    dbIndex.add(0);
                    dbName.add(Tables.QUESTIONS);
                    dbIndex.add(0);
                    dbName.add(Tables.FOS_USER);
                    dbIndex.add(0);
                    dbName.add(Tables.USER_TO_VOTES);
                    dbIndex.add(0);

                    for (TableImpl db : dbName) {
                        dbNew.delete(db).execute();

                    }
                    //удаляем файлы сопостовланеия айдишников
                    ArrayList<String> listOfFiles = new ArrayList<>();

                    listOfFiles.add(fileNameOfQuestionRel);
                    listOfFiles.add(fileNameOfAnswerRel);
                    listOfFiles.add(fileNameOfTopicRel);
                    listOfFiles.add(fileNameOfCommentRel);
                    listOfFiles.add(fileNameOfVoteRel);
                    listOfFiles.add(fileNameOfUserRel);
                    for (String currFile : listOfFiles) {
                        File file = new File(currFile + ".csv");
                        if (file.delete()) {
                            System.out.println(currFile + " файл удален");
                        } else System.out.println("Файла " + currFile + " не обнаружено");
                    }
                }
                System.out.println("Start migration...");


                loadUsers(listOfUsers);
                loadQuestions();
                loadAnswers();
                loadComments();
                loadTopics();
                loadVotes();
                loadFavorites();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void loadUsers(List<List<String>> listOfUser) {
        // убираем дубликаты имен
        listOfUser = removeDuplicate(listOfUser);

        Slugify slg = new Slugify();
        int numberOfUser = 0;
        for (List<String> line : listOfUser) {
            String slug = slg.slugify(line.get(5)); // слаг для ю3ера
            String name_canonical = line.get(5).toLowerCase();
            String email = line.get(4).toLowerCase();
            String last_login = line.get(6);
            String userId = line.get(0);
            String owner_id = line.get(1);
            if (owner_id.contains("null")) {
                continue;
            }
            String is_owner = line.get(2);
            String enabled = "1";
            Random rnd = new Random();
            String password = String.valueOf(ReadDB.generateString(rnd, "QWERTYUIOPqwertyuiopASDDFGHJKLasdfghjkl", 40));
            String avatarblobid = line.get(8);
            String cropic = "default.jpeg";
            if (!avatarblobid.equals("null")) {
                cropic = avatarblobid + ".jpg";
            }


        }


    }

    private static List<List<String>> removeDuplicate(List<List<String>> listOfUsers) {

        for (int i = 0; i < listOfUsers.size(); i++) {
            List<String> lineOriginal = listOfUsers.get(i);
            for (int j = i + 1; j < listOfUsers.size(); j++) {
                List<String> line = listOfUsers.get(j);
                if (lineOriginal.get(5).equals(line.get(5))) {
                    listOfUsers.remove(j);
                    String name = line.get(5);
                    name += j;
                    line.set(5, name);
                    System.out.println(line);
                    listOfUsers.add(line);
                    j--;
                }
            }
        }
        return listOfUsers;
    }

    private static void loadQuestions() {
    }

    private static void loadAnswers() {
    }

    private static void loadComments() {
    }

    private static void loadTopics() {
    }

    private static void loadVotes() {
    }

    private static void loadFavorites() {
    }
}
