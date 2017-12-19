import com.github.slugify.Slugify;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;


import static java.util.stream.Collectors.toList;

public class ReadDB {


    /**
     * Simple Java program to connect to MySQL database running on localhost and
     * running SELECT and INSERT query to retrieve and add data.
     * <p>
     * author Javin Paul
     */


    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/lorg";
    private static final String user = "root";
    private static final String password = "root";

    private static final String url2 = "jdbc:mysql://localhost:3306/newLogrExtra?autoReconnect=true&useSSL=false";
    private static final String userLORG2 = "root";
    private static final String passwordLORG2 = "root";


    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) throws IOException {
        //saveDataFromLorg1();
        loadDataToLorg2();

    }

    //==========================================================================
    private static void loadDataToLorg2() throws IOException {

        String queryTopic = "SELECT * FROM topics";
        String queryQu = "SELECT * FROM questions";
        String queryUsers = "SELECT * FROM for_user Where sellerid is not null";
        String insertTopics = "";

        //List<List<String>> listOfTopic = readFromFile("D:\\Tempdir\\topic.csv", false);
        //List<List<String>> listOfUsers = readFromFile("D:\\Tempdir\\users.csv", false);
        List<List<String>> listOfQuestions = readFromFile("D:\\Tempdir\\questions.csv", true);
        //listOfTopic.forEach(System.out::println);
        //listOfUsers.forEach(System.out::println);


        try {
            System.out.println("Connecting to a selected database...");
            con = DriverManager.getConnection(url2, userLORG2, passwordLORG2);
            System.out.println("Connected database successfully...");
            stmt = con.createStatement();
/*            String insertSQLUsers = "INSERT INTO fos_user " +
                    *//*1*//*      "(username," +
                    *//*2*//*      "username_canonical," +
                    *//*3*//*      "email," +
                    *//*4*//*      "email_canonical," +
                    *//*5*//*      "enabled," +
                    *//*6*//*      "last_login, " +
                    *//*7*//*      "userId," +
                    *//*8*//*      "owner_id," +
                    *//*9*//*      "localize," +
                    *//*10*//*     "slug," +
                    *//*11*//*     "segment," +
                    *//*12*//*     "status," +
                    *//*13*//*     "cropic," +
                    *//*14*//*     "roles," +
                    *//*15*//*     "is_owner," +
                    *//*16*//*     "password)" +

                    "VALUES (" +
                    *//*1  username*//*  "?," + //1
                    *//*2  usm_cncl*//*  "?," + //2
                    *//*3  email*//*     "?," + //3
                    *//*4  eml_cnncl*//* "?," + //4
                    *//*5  enabled*//*   "?," + //5
                    *//*6  last_lgn*//*  "?," + //6
                    *//*7  userid*//*    "?," + //7
                    *//*8  owner_id*//*  "?," + //8
                    *//*9  localize*//*  "'en'," +
                    *//*10 slug*//*      "?," + //9
                    *//*11 segment*//*   "'eng'," +
                    *//*12 status*//*    "'Active'," +
                    *//*13 cropic*//*    "'default.jpeg'," +
                    *//*14 roles *//*    "'a:0:{}'," +
                    *//*15 is Owner*//*  "?," + //10
                    *//*16 password*//*  "?" +   //11
                    " )";*/
            Slugify slg = new Slugify();
     /*       for (List<String> line : listOfUsers) {
                String slug = slg.slugify(line.get(5));// слаг для ю3ера
                PreparedStatement statement = con.prepareStatement(insertSQLUsers, Statement.RETURN_GENERATED_KEYS);
                String name_canonical = line.get(5).toLowerCase();
                String email = line.get(4).toLowerCase();
                String last_login = line.get(6);
                String userId = line.get(0);
                String owner_id = line.get(1);
                if (owner_id.contains("null")) {
                    owner_id = "0000";
                } else {
                    owner_id = line.get(1);
                }
                String is_owner = line.get(2);
                String enabled = "1";
                Random rng = new Random();
                String password = String.valueOf(generateString(rng, "QWERTYUIOPqwertyuiopASDDFGHJKLasdfghjkl", 40));
                statement.setString(1, line.get(5));
                statement.setString(2, name_canonical);
                statement.setString(3, email);
                statement.setString(4, email);
                statement.setString(5, enabled);
                statement.setString(6, last_login);
                statement.setString(7, userId);
                statement.setString(8, owner_id);
                statement.setString(9, slug);
                statement.setString(10, is_owner);
                statement.setString(11, password);
                int affectedRow = statement.executeUpdate();
                if (affectedRow == 0) {
                    System.out.println("Создание строки не удалось - " + email);
                } else {
                    receiveIDinNewDB(line, statement);
                }*/
               /* if (affectedRow == 0) {
                    throw new SQLException("Создание строки не удалось");
                }
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long id = generatedKeys.getLong(1);
                        String idStr = String.valueOf(id);
                        line.add(idStr);
                    } else {
                        throw new SQLException("Creating line failed, no ID obtained.");
                    }
                }*/
                //System.out.println(line);

            //}
//вставка вопросов
        for (List<String> line : listOfQuestions) {
            String slug = slg.slugify(line.get(1));// слаг для топика
            String insertSQLTopic = "INSERT INTO topics (topic, content, slug, cropic, segment)" +
                    "VALUES (?,'short explanation about topic',?,'default_topic.jpeg', 'eng')";
            //stmt.executeUpdate(insertSQLTopic);
            PreparedStatement statement = con.prepareStatement(insertSQLTopic, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, line.get(1));
            statement.setString(2, slug);
            int affectedRow = statement.executeUpdate();
               /* if (affectedRow == 0) {
                    throw new SQLException("Создание строки не удалось");
                }*/
            receiveIDinNewDB(line, statement);
            System.out.println(line);
        }
//вставка тем - топиков
/*            for (List<String> line : listOfTopic) {
                String slug = slg.slugify(line.get(1));// слаг для топика
                String insertSQLTopic = "INSERT INTO topics (topic, content, slug, cropic, segment)" +
                        "VALUES (?,'short explanation about topic',?,'default_topic.jpeg', 'eng')";
                //stmt.executeUpdate(insertSQLTopic);
                PreparedStatement statement = con.prepareStatement(insertSQLTopic, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, line.get(1));
                statement.setString(2, slug);
                int affectedRow = statement.executeUpdate();
 */
               /* if (affectedRow == 0) {
                    throw new SQLException("Создание строки не удалось");
                }*/
/*                receiveIDinNewDB(line, statement);
                System.out.println(line);
            }*/
/*

            rs = stmt.executeQuery(queryTopic);

            while (rs.next()) {
                String topic = rs.getString(2);
                int id = rs.getInt(1);
                System.out.println("index is  : " + id + " название: " + topic);


            }
*/
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
            //    try {
            //        rs.close();
            //    } catch (SQLException se) { /*can't do anything*/ }
        }
    }

    private static List<List<String>> readFromFileCoded(String fileName) throws IOException {
        List<List<String>> listOfItems = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).map(ReadDB::parseLine).collect(toList());
        return listOfItems;
    }

    private static void receiveIDinNewDB(List<String> line, PreparedStatement statement) throws SQLException {
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                long a = generatedKeys.getLong(1);
                String aStr = String.valueOf(a);
                line.add(aStr);
            } else {
                throw new SQLException("Creating line failed, no ID obtained.");
            }
        }
    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    private static List<List<String>> readFromFile(String fileName, Boolean isEncoded) throws IOException {
        List<List<String>> listOfItems;
        if (isEncoded) {
            listOfItems = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).map(ReadDB::parseEncodedLine).collect(toList());
        } else {
            listOfItems = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).map(ReadDB::parseLine).collect(toList());
        }
        return listOfItems;
    }

    private static List<String> parseEncodedLine(String line)  {
        List list = new ArrayList();
        String[] subStr;
        String delimeter = ","; // Разделитель
        subStr = line.split(delimeter);
        // Вывод результата на экран
        for (String str : subStr) {
            /*byte[] lineCoded = str.getBytes("UTF-8");
            String encoded = Base64.getEncoder().encodeToString(str);*/
            byte[] decoded = Base64.getDecoder().decode(str);
            String encoded = Base64.getEncoder().encodeToString(decoded);
            list.add(str);
        }
        return list;
    }

    private static List<String> parseLine(String line) {
        List list = new ArrayList();
        String[] subStr;
        String delimeter = ","; // Разделитель
        subStr = line.split(delimeter);
        // Вывод результата на экран
        for (String str : subStr) {
            list.add(str);
        }
        return list;

    }


    //==============================================================================================
    private static void saveDataFromLorg1() {
        String queryTopic = "SELECT id,topic FROM qa_topics";
        String queryPost = "SELECT " +
                "postid," +
                "type," +
                "parentid," +
                "categoryid," +
                "catidpath1," +
                "catidpath2," +
                "catidpath3," +
                "acount," +
                "amaxvote," +
                "selchildid," +
                "closedbyid," +
                "userid," +
                "cookieid," +
                "createip," +
                "lastuserid," +
                "lastip," +
                "upvotes," +
                "downvotes," +
                "netvotes," +
                "lastviewip," +
                "views," +
                "hotness," +
                "flagcount," +
                "format," +
                "created," +
                "updated," +
                "updatetype," +
                "title," +
                "content," +
                "name," +
                "notify" +
                " FROM qa_posts";

        String queryUsers = "SELECT " +
                "userid," +
                "sellerid," +
                "owner," +
                "created," +
                "email," +
                "handle," +
                "loggedin," +
                "written" +
                " FROM qa_users WHERE sellerid IS NOT NULL ";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(queryTopic);
            while (rs.next()) {
                String topic = rs.getString(2);
                int id = rs.getInt(1);
                System.out.println("index is  : " + id + " название: " + topic);
                saveToFile(id, topic);
            }
// выгрузка таблицы юзеров
            rs = stmt.executeQuery(queryUsers);
            while (rs.next()) {
                //String topic = rs.getString(2);
                //int id = rs.getInt(1);
                //System.out.println("index is  : " + id + " название: " + topic);
                saveToFileUsers(rs);
            }
//выгрузка таблицы сообщений
            rs = stmt.executeQuery(queryPost);
            while (rs.next()) {
                saveToFilePost(rs);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    private static void saveToFilePost(ResultSet rs) throws SQLException {
        int columnsTotal = rs.getMetaData().getColumnCount();
        // определяем объект для каталога
        File dir = new File("D:\\TempDir\\");
        if (!dir.exists()) {
            dir.mkdir();
        }
        //определяем вопрос, ответ или комментарий
        String quAnCm = rs.getString(2);
        String fileNameQAC;
        if (quAnCm.contains("Q")) {
            fileNameQAC = "questions";

        } else if (quAnCm.contains("A")) {
            fileNameQAC = "answers";
        } else if (quAnCm.contains("C")) {
            fileNameQAC = "comments";
        } else return;
        File fileName = new File(fileNameQAC);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir + File.separator + fileName.getName() + ".csv", true))) {
            String line = "";
            for (int i = 1; i <= columnsTotal; i++) {
                String essence = rs.getString(i);
                if (essence == null) {
                    essence = "null";
                }
                byte[] lineCoded = essence.getBytes("UTF-8");
                String encoded = Base64.getEncoder().encodeToString(lineCoded);
                if (i < columnsTotal) {
                    line = line + encoded + ",";
                } else {
                    line = line + encoded;
                }
            }
            line = line + "\n";
            // запись всей строки в файл
            /*byte[] lineCoded = line.getBytes("UTF-8");
            String encoded = Base64.getEncoder().encodeToString(lineCoded);
            byte[] decoded = Base64.getDecoder().decode(encoded);
            */
            writer.write(line);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void saveToFileUsers(ResultSet rs) throws SQLException {
        int columnsTotal = rs.getMetaData().getColumnCount();
        // определяем объект для каталога
        File dir = new File("D:\\TempDir\\");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File fileName = new File("users");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir + File.separator + fileName.getName() + ".csv", true))) {
            String line = "";
            for (int i = 1; i < columnsTotal; i++) {
                String essence = rs.getString(i);
                line = line + essence + ",";
                System.out.println(line);
            }
            line = line + rs.getString(columnsTotal) + "\n";
            // запись всей строки в файл
            writer.write(line);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void saveToFile(int id, String topic) {
        // определяем объект для каталога
        File dir = new File("D:\\TempDir\\");

        if (!dir.exists()) {
            dir.mkdir();
        }
        File fileName = new File("topic");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir + File.separator + fileName.getName() + ".csv", true))) {
            // запись всей строки
            String line = id + "," + topic + "\n";
            writer.write(line);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}



