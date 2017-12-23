import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Base64;

public class SaveDataFromLorg {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) throws IOException {
        saveDataFromLorg1();
    }

    public static void saveDataFromLorg1() {
        String queryTopic = "SELECT id,topic FROM qa_topics";
        String queryPost = "SELECT " +
                "postid," +         //0
                "type," +           //1
                "parentid," +       //2
                "categoryid," +     //3
                "catidpath1," +     //4
                "catidpath2," +     //5
                "catidpath3," +     //6
                "acount," +         //7
                "amaxvote," +       //8
                "selchildid," +     //9
                "closedbyid," +     //10
                "userid," +         //11
                "cookieid," +       //12
                "createip," +       //13
                "lastuserid," +     //14
                "lastip," +         //15
                "upvotes," +        //16
                "downvotes," +      //17
                "netvotes," +       //18
                "lastviewip," +     //19
                "views," +          //20
                "hotness," +        //21
                "flagcount," +      //22
                "format," +         //23
                "created," +        //24
                "updated," +        //25
                "updatetype," +     //26
                "title," +          //27
                "content," +        //28
                "name," +           //29
                "notify" +          //30
                " FROM qa_posts WHERE userid IS NOT NULL";

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

// выгрузка таблицы топиков
            rs = stmt.executeQuery(queryTopic);
            System.out.println("Записываем данные в файл c topic");
            while (rs.next()) {
                String topic = rs.getString(2);
                int id = rs.getInt(1);
                saveToFile(id, topic);
                progressBar(id);
            }
            System.out.println("File is saved");

// выгрузка таблицы юзеров
            rs = stmt.executeQuery(queryUsers);
            System.out.println("Save data of Users in file about Users...");
            int i=0;
            while (rs.next()) {
                 saveToFileUsers(rs);
                progressBar(i);
                i++;
            }
            System.out.println("\nЗапись данных о пользователях завершена");

//выгрузка таблицы сообщений
            rs = stmt.executeQuery(queryPost);
            System.out.println("Начинаем записть данных в файл сообщений");
            i=1;
            while (rs.next()) {
                saveToFilePost(rs);
                progressBar(i);
                i++;
            }
            System.out.println("\nДанные успешно записаные в файлы");
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

    public static void progressBar(int i) {
        try {
            String data = "\r" + "|/-\\".charAt(i % "|/-\\".length()) + " записываем данные в файл... " ;
            System.out.write(data.getBytes());
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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