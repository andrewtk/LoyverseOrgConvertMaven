import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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
        String queryUsers = "SELECT * FROM for_user";
        String insertTopics = "";
        List listOfTopic = readFromFile("D:\\Tempdir\\topic.csv");


        try {
            System.out.println("Connecting to a selected database...");
            con = DriverManager.getConnection(url2, user, password);
            System.out.println("Connected database successfully...");
            stmt = con.createStatement();

            String insertSQLTopic = "INSERT INTO topics (topic, content, slug, cropic, segment)" +
                    "VALUES ('testTopic','проверяем как вставка происходит','bla-bla','default_topic.jpeg', 'eng')";
            stmt.executeUpdate(insertSQLTopic);
            rs = stmt.executeQuery(queryTopic);

            while (rs.next()) {
                String topic = rs.getString(2);
                int id = rs.getInt(1);
                System.out.println("index is  : " + id + " название: " + topic);

            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything*/  }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything*/  }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything*/  }
        }
    }

    private static List readFromFile(String fileName) throws IOException {
        List<List<String>> listOfItems = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).map(ReadDB::parseLine).collect(toList());
        return listOfItems;
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


                 /*
            postid
        	type
        	parentid
        	categoryid
        	catidpath1
        	catidpath2
        	catidpath3
        	acount
        	amaxvote
        	selchildid
        	closedbyid
        	userid
        	cookieid
        	createip
        	lastuserid
        	lastip
        	upvotes
        	downvotes
        	netvotes
        	lastviewip
        	views
        	hotness
        	flagcount
        	format
        	created
        	updated
        	updatetype
        	title
        	content
        	tags
        	name
        	notify

         */


        String queryUsers = "SELECT " +
                "userid," +
                "sellerid," +
                "owner," +
                "created," +
                "email," +
                "handle," +
                "loggedin," +
                "written" +
                " FROM qa_users";
        /*
       userid
       sellerid
       owner
       created
       createip
       email
       handle
       avatarblobid
       avatarwidth
       avatarheight
       passsalt
       passcheck
       level
       loggedin
       loginip
       written
       writeip
       emailcode
       sessioncode
       sessionsource
       flags
       wallposts
       oemail
               */

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
