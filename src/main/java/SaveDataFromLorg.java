import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Base64;

public class SaveDataFromLorg {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";
    private static final String url2 = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";
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
        String queryPostTopic = "SELECT " +
                "  qa_posts.postid AS qid, " +
                "  qa_words.wordid AS wid, " +
                "  qa_topics.id AS tid, " +
                "  qa_topics.topic AS topic " +
                "FROM qa_words " +
                "  LEFT JOIN qa_topics ON topic = word " +
                "  LEFT JOIN qa_posttags ON qa_words.wordid = qa_posttags.wordid " +
                "  LEFT JOIN qa_posts ON qa_posttags.postid = qa_posts.postid " +
                "WHERE topic IS NOT NULL and qa_posts.postid is not NULL and qa_posts.type like \"%Q%\"";
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
                " FROM qa_posts ";

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
        String queryVotes = /*"SELECT " +
                "postid,userid,vote " +
                "FROM qa_uservotes";*/
        "SELECT vote.postid,post.type,vote.userid,vote.vote\n" +
                "FROM qa_uservotes vote\n" +
                "  LEFT JOIN qa_posts post ON vote.postid = post.postid";
        String queryFavorites = "SELECT * " +
                " FROM qa_userfavorites";
        String fileNameTopicRel = "D:\\Tempdir\\" + "oldNewIdTopicRel";
        String fileNameVotes = "D:\\Tempdir\\" + "votes";
        String fileNameFavorites = "D:\\Tempdir\\favorites";

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
            System.out.println("\nFile is saved");

// выгрузка таблицы юзеров
            rs = stmt.executeQuery(queryUsers);
            System.out.println("\nSave data of Users in file about Users...");
            int i = 0;
            while (rs.next()) {
                saveToFileUsers(rs);
                progressBar(i);
                i++;
            }
            System.out.println("\nЗапись данных о пользователях завершена");

//выгрузка таблицы сообщений
            rs = stmt.executeQuery(queryPost);
            System.out.println("\nНачинаем запись данных в файл сообщений");
            i = 1;
            while (rs.next()) {
                saveToFilePost(rs);
                progressBar(i);
                i++;
            }
//выгрузка таблицы votes в файл
            rs = stmt.executeQuery(queryVotes);
            System.out.println("\nНачинаем запись данных в файл votes ");
            i = 1;
            while (rs.next()) {
                saveToFile(rs, fileNameVotes);
                progressBar(i);
                i++;
            }
//выгрузка таблицы favorites в файл
            rs = stmt.executeQuery(queryFavorites);
            System.out.println("\nНачинаем запись данных в файл favorites ");
            i = 1;
            while (rs.next()) {
                saveToFile(rs, fileNameFavorites);
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
//выгрузка аватаров из базы.
        ReadFileAvtrFromDB.saveAvatars();

    }

    public static void progressBar(int i) {
        try {
            String data = "\r" + "|/-\\".charAt(i % "|/-\\".length()) + " записываем данные в файл... ";
            System.out.write(data.getBytes());
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(ResultSet rs, String fileNameTopicRel) throws SQLException {
        int columnsTotal = rs.getMetaData().getColumnCount();
        // определяем объект для каталога
        File dir = new File("D:\\TempDir\\");
        if (!dir.exists()) {
            dir.mkdir();
        }

        File fileName = new File(fileNameTopicRel);
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

    /**
     *
     * @param rs строка считанная из базы миграции из конкретной таблицы
     * @throws SQLException
     */
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
        if (quAnCm.equals("Q")) {
            fileNameQAC = "questions";
        } else if (quAnCm.contains("A")) {
            fileNameQAC = "answers";
        } else if (quAnCm.contains("C")) {
            fileNameQAC = "comments";
        } else return;

        File fileName = new File(fileNameQAC);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir + File.separator + fileName.getName() + ".csv", true))) {
            String line = "";
            /**
             * перебор всех полей в полученной строке и запись в текстовом виде в файл в виде сsv
             */
            for (int i = 1; i <= columnsTotal; i++) {
                String essence = rs.getString(i);
                if (essence == null && i==12) {//если i=12 (userid) = null, то присвоить
                    essence = "207394"; //эккаунт userid 207394 - mustafasethalilov@gmail.com искусственный экаунт созданный для подмены
                } else {
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
