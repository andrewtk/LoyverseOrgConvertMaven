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
        SaveDataFromLorg.saveDataFromLorg1();
        loadDataToLorg2();

    }

    //==========================================================================
    private static void loadDataToLorg2() throws IOException {

        String queryTopic = "SELECT * FROM topics";
        String queryQu = "SELECT * FROM questions";
        String queryUsers = "SELECT * FROM for_user Where sellerid is not null";
        String insertTopics = "";
        int slugInc = 0;
        String queryIdOwner = "SELECT fos_user.id " +
                " FROM fos_user " +
                " WHERE fos_user.userid = ";

        List<List<String>> listOfTopic = readFromFile("D:\\Tempdir\\topic.csv", false);
        List<List<String>> listOfUsers = readFromFile("D:\\Tempdir\\users.csv", false);
        List<List<String>> listOfQuestions = readFromFile("D:\\Tempdir\\questions.csv", true);
        List<List<String>> listOfAnswers = readFromFile("D:\\Tempdir\\answers.csv", true);
        List<List<String>> listOfComments = readFromFile("D:\\Tempdir\\comments.csv", true);
        String fileNameOfQuestionRel = "D:\\Tempdir\\" + "oldnewId";
        String fileNameOfAnswerRel = "D:\\Tempdir\\" + "oldnewIdAnsw";

//вставляем юзеров из таблицы в новую базу///////////////////////////////////////////////////////////////////////////
        try {
            System.out.println("\nConnecting to a selected database...");
            con = DriverManager.getConnection(url2, userLORG2, passwordLORG2);
            System.out.println("Connected database successfully...");
            stmt = con.createStatement();
            String insertSQLUsers = "INSERT  INTO fos_user " +
                    /*1*/      "(username," +
                    /*2*/      "username_canonical," +
                    /*3*/      "email," +
                    /*4*/      "email_canonical," +
                    /*5*/      "enabled," +
                    /*6*/      "last_login, " +
                    /*7*/      "userId," +
                    /*8*/      "owner_id," +
                    /*9*/      "localize," +
                    /*10*/    "slug," +
                    /*11*/    "segment," +
                    /*12*/    "status," +
                    /*13*/    "cropic," +
                    /*14*/    "roles," +
                    /*15*/    "is_owner," +
                    /*16*/    "password)" +

                    "VALUES (" +
                    /*1  username*/  "?," + //1
                    /*2  usm_cncl*/  "?," + //2
                    /*3  email*/     "?," + //3
                    /*4  eml_cnncl*/ "?," + //4
                    /*5  enabled*/   "?," + //5
                    /*6  last_lgn*/  "?," + //6
                    /*7  userid*/    "?," + //7
                    /*8  owner_id*/  "?," + //8
                    /*9  localize*/  "'en'," +
                    /*10 slug*/      "?," + //9
                    /*11 segment*/   "'eng'," +
                    /*12 status*/    "'Active'," +
                    /*13 cropic*/    "'default.jpeg'," +
                    /*14 roles */    "'a:0:{}'," +
                    /*15 is Owner*/  "?," + //10
                    /*16 password*/  "?" +   //11
                    " )";
            Slugify slg = new Slugify();
            int numberOfUser = 0;
            for (List<String> line : listOfUsers) {
                String slug = slg.slugify(line.get(5)) + numberOfUser;// слаг для ю3ера
                PreparedStatement statement = con.prepareStatement(insertSQLUsers, Statement.RETURN_GENERATED_KEYS);
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
                Random rng = new Random();
                String password = String.valueOf(generateString(rng, "QWERTYUIOPqwertyuiopASDDFGHJKLasdfghjkl", 40));
                statement.setString(11, password);
                int affectedRow = statement.executeUpdate();
                if (affectedRow == 0) {
                    System.out.print("\rСоздание строки не удалось - " + email);
                } else {
                    receiveIDinNewDB(line, statement);

                }
                numberOfUser++;

                try {
                    String data = "\r" + "|/-\\".charAt(numberOfUser % "|/-\\".length()) + " добавляем номер " + numberOfUser + " с почтой " + email;
                    System.out.write(data.getBytes());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("\n\nFinished to convert the users\n=== === === === ===\n=== === === === ===\n");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//вставка вопросов
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("\nStart to convert the questions");
            for (List<String> line : listOfQuestions) {
                String slug = slg.slugify(line.get(27)); // слаг для топика
                int endIndexSlug = slug.length();
                int slugIncLength = Integer.toString(slugInc).length();
                if ((endIndexSlug + slugIncLength) > 30) {
                    slug = slug.substring(0, 30 - slugIncLength) + slugInc;
                } else {
                    slug = slug + slugInc;
                }
                slugInc++;
                String insertSQLQuestions = "INSERT IGNORE INTO questions (userid,title,content,slug,status,mailme,segment,created,updated)" +
                        "VALUES (?,?,?,?,'active','1','en',?,?)";
                if (line.get(11).contains("null")) {
                    continue;
                }
                String userIdFromFOS_user = line.get(11);
                String currentQueryIdOwner = queryIdOwner + userIdFromFOS_user;
                rs = stmt.executeQuery(currentQueryIdOwner);
                Boolean stateOfLine = rs.next();
                String oldIdOwner;
                if (stateOfLine) {
                    oldIdOwner = rs.getString(1);
                } else {
                    continue;
                }
                PreparedStatement statement = con.prepareStatement(insertSQLQuestions, Statement.RETURN_GENERATED_KEYS);
                String userid = oldIdOwner; //connectToFOS_UserID(line.get(11), listOfUsers);
                String title = line.get(27);
                String content = line.get(28);
                String created = line.get(24);
                if (created.contains("null")) {
                    continue;
                }
                String updated = line.get(25);
                if (updated.contains("null")) {
                    updated = created;
                }
                if (userid.contains("null")) {
                    continue;
                }
                statement.setString(1, userid);
                statement.setString(2, title);
                statement.setString(3, content);
                statement.setString(4, slug);
                statement.setString(5, created);
                statement.setString(6, updated);
                int affectedRow = statement.executeUpdate();
                if (affectedRow == 0) {
                    System.out.println("Создание строки не удалось - ");
                } else {
                    receiveIDinNewDB(line, statement);
                    saveToFileTableOfRelation(line.get(0), line.get(line.size() - 1), fileNameOfQuestionRel);
                }

                try {
                    String data = "\r" + "|/-\\".charAt(slugInc % "|/-\\".length()) + " " + slugInc;
                    System.out.write(data.getBytes());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//вставка ответов
          /*        "postid," + //      //0
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
                    "notify" +          //30*/
            System.out.println("Start to convert the answers");
            List<List<String>> list_Old_New_Id_Q = readFromFile(fileNameOfQuestionRel, false);
            for (List<String> line : listOfAnswers) {
                String slug = getMySlug(slugInc, slg, line);
                slugInc++;
                if (line.get(11).contains("null")) { //11-userId
                    continue;
                }
                String userIdFromFOS_user = line.get(11);
                String currentQueryIdOwner = queryIdOwner + userIdFromFOS_user;
                rs = stmt.executeQuery(currentQueryIdOwner);
                Boolean stateOfLine = rs.next();
                String userId;
                if (stateOfLine) {
                    userId = rs.getString(1);//получить новый айди (ID) торговца из таблицы fos_user
                } else {
                    continue;
                }
                if (userId.contains("null")) {
                    continue;
                }
                String oldParentId_from_qa_post = line.get(2);//parentId from qa_post
                //String qsId = takeNewIdOfQuestion(oldParentId_from_qa_post, listOfQuestions);
                String qsId = takeNewIdFromFile(oldParentId_from_qa_post, list_Old_New_Id_Q);
                if (qsId.contains("-1")) {
                    continue;
                }
                String content = line.get(28);
                String created = line.get(24);
                if (created.contains("null")) {
                    continue;
                }
                String updated = line.get(25);
                if (updated.contains("null")) {
                    updated = created;
                }
                String insertSQLAnswers = "INSERT IGNORE INTO answers " +
                        "(qsid,userid,content,slug,mailme,created,updated)" +
                        "VALUES (?,?,?,?,'0',?,?)";
                PreparedStatement statement = con.prepareStatement(insertSQLAnswers, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, qsId);
                statement.setString(2, userId);
                statement.setString(3, content);
                statement.setString(4, slug);
                statement.setString(5, created);
                statement.setString(6, updated);
                int affectedRow = statement.executeUpdate();
                if (affectedRow == 0) {
                    System.out.println("Создание строки не удалось - userId " + userId);
                } else {
                    receiveIDinNewDB(line, statement);
                    saveToFileTableOfRelation(line.get(0), line.get(line.size() - 1), fileNameOfAnswerRel);
                }
                try {
                    String data = "\r" + "|-".charAt(slugInc % "|-".length()) + " " + slugInc;
                    System.out.write(data.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// вставка комментариев
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            List<List<String>> list_Old_New_Id_A = readFromFile(fileNameOfAnswerRel, false);

            insertCommentsInNewDB(slugInc, queryIdOwner, listOfComments, list_Old_New_Id_Q, list_Old_New_Id_A);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//вставка тем - топиков
////////////////////////////////////////////////////////////////////////////////
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
                    receiveIDinNewDB(line, statement);
                    //saveToFileTableOfRelation(line.get(0), line.get(line.size() - 1), fileNameOfAnswerRel);
                }
                //прогресс бар
                try {
                    String data = "\r" + "|-+".charAt(slugInc % "|-+".length()) + " " + slugInc;
                    System.out.write(data.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                receiveIDinNewDB(line, statement);
            }
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
            } catch (SQLException se) { /*can't do anything*/ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything*/ }
            //    try {
            //        rs.close();
            //    } catch (SQLException se) { /*can't do anything*/ }
        }

    }

    private static void insertCommentsInNewDB(int slugInc, String queryIdOwner,
                                              List<List<String>> listOfComments,
                                              List<List<String>> listOfOldAndNewQuestionsId,
                                              List<List<String>> listOfOldAndNewAnsId) throws SQLException {
        System.out.println("Start to convert the comments");
        String anim = "|-/\\";
        slugInc = 0;
        for (List<String> line : listOfComments) {
            slugInc++;
            String userIdFromFOS_user = line.get(11);
            String currentQueryIdOwner = queryIdOwner + userIdFromFOS_user;
            rs = stmt.executeQuery(currentQueryIdOwner);
            Boolean stateOfLine = rs.next();
            String userId;
            if (stateOfLine) {
                userId = rs.getString(1);//получить новый айди (ID) торговца из таблицы fos_user
            } else {
                userId = null;
            }
            String oldParentId_from_qa_post = line.get(2);//parentId from qa_post
            String qsId = takeNewIdFromFile(oldParentId_from_qa_post, listOfOldAndNewQuestionsId);
            if (qsId.contains("-1")) {
                qsId = null;
            }
            String answerID = takeNewIdFromFile(oldParentId_from_qa_post, listOfOldAndNewAnsId);
            if (answerID.contains("-1")) {
                answerID = null;
            }
            if (answerID == null & qsId == null & userId == null) {
                continue;
            }
            String content = line.get(28);
            String created = line.get(24);
            String updated = line.get(25);
            if (updated.contains("null")) {
                updated = created;
            }
            String insertSQLComments = "INSERT INTO comments " +
                    "(answid,qsid,comid,userid,content,depth,mailme,created,updated)" +
                    "VALUES (?,?,NULL,?,?,'1','0',?,?)";
            PreparedStatement statement = con.prepareStatement(insertSQLComments, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, answerID);
            statement.setString(2, qsId);
            statement.setString(3, userId);
            statement.setString(4, content);
            statement.setString(5, created);
            statement.setString(6, updated);
            int affectedRow = statement.executeUpdate();
            if (affectedRow == 0) {
                String data = "\r" + anim.charAt(slugInc % anim.length()) + " " + slugInc;
                try {
                    System.out.write(data.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //System.out.println("\nСоздание строки не удалось - userId " + userId);
            } else {
                receiveIDinNewDB(line, statement);

            }
            try {
                String data = "\r" + anim.charAt(slugInc % anim.length()) + " " + slugInc;
                System.out.write(data.getBytes());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String takeNewIdFromFile(String oldParentId_from_qa_post, List<List<String>> listOfId) {
        String newId = "-1";
        for (List<String> line : listOfId) {
            if (line.get(0).equals(oldParentId_from_qa_post)) {
                newId = line.get(1);
                break;
            }
        }
        return newId;
    }

    private static String getMySlug(int slugInc, Slugify slg, List<String> line) {
        String slug = slg.slugify(line.get(28)); // слаг
        int endIndexSlug = slug.length();
        int slugIncLength = Integer.toString(slugInc).length();
        if ((endIndexSlug + slugIncLength) > 30) {
            slug = slug.substring(0, 30 - slugIncLength) + slugInc;
        } else {
            slug = slug + slugInc;
        }
        return slug;
    }

    private static void saveToFileTableOfRelation(String oldId, String newId, String fileNameId) {
        // определяем объект для каталога
        File dir = new File("D:\\TempDir\\");

        if (!dir.exists()) {
            dir.mkdir();
        }
        File fileName = new File(fileNameId);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir + File.separator + fileName.getName() + ".csv", true))) {
            // запись всей строки
            String line = oldId + "," + newId + "\n";
            writer.write(line);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static List<String> receiveIDinNewDB(List<String> line, PreparedStatement statement) throws
            SQLException {
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                long a = generatedKeys.getLong(1);
                String aStr = String.valueOf(a);
                line.add(aStr);
            } else {
                try {
                    String anim = "\\|-/";
                    String data = "\r" + anim.charAt(Integer.parseInt(line.get(0)) % anim.length()) + "Creating line failed, no ID obtained." + line.get(0);
                    System.out.write(data.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return line;
        }
    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static List<List<String>> readFromFile(String fileName, Boolean isEncoded) throws IOException {
        List<List<String>> listOfItems;
        if (!fileName.substring(fileName.length() - 4, fileName.length()).contains("csv")) {
            fileName = fileName + ".csv";
        }
        listOfItems = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).map(line -> parseLine(line, isEncoded)).collect(toList());
        return listOfItems;
    }

    private static List<String> parseLine(String line, Boolean isEncoded) {
        List list = new ArrayList();
        String[] subStr;
        String delimeter = ","; // Разделитель
        subStr = line.split(delimeter);
        for (String str : subStr) {
            if (isEncoded) {
                byte[] lineCoded = str.getBytes();
                byte[] decoded = Base64.getDecoder().decode(lineCoded);
                String decodedStr = new String(decoded);
                list.add(decodedStr);
            } else {
                list.add(str);
            }

        }
        return list;

    }


    //==============================================================================================
/*
    private static void saveDataFromLorg1() {
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
            } catch (SQLException se) { */
/*can't do anything *//*
 }
            try {
                stmt.close();
            } catch (SQLException se) { */
/*can't do anything *//*
 }
            try {
                rs.close();
            } catch (SQLException se) { */
/*can't do anything *//*
 }
        }
    }
*/
/*

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
            */
/*byte[] lineCoded = line.getBytes("UTF-8");
            String encoded = Base64.getEncoder().encodeToString(lineCoded);
            byte[] decoded = Base64.getDecoder().decode(encoded);
            *//*

            writer.write(line);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
*/
/*

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
                //System.out.println(line);
                try {
                    String data = "\r" + "|/-\\".charAt(i % "|/-\\".length()) + " записываем данные в файл... " + fileName;
                    System.out.write(data.getBytes());
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            line = line + rs.getString(columnsTotal) + "\n";
            // запись всей строки в файл
            writer.write(line);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("\nзапись завершена.");
    }
*/
/*
    private static void saveToFile(int id, String topic) {
        // определяем объект для каталога
        File dir = new File("D:\\TempDir\\");

        if (!dir.exists()) {
            dir.mkdir();
        }
        File fileName = new File("topic");
        System.out.println("Записываем данные в файл... " + fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir + File.separator + fileName.getName() + ".csv", true))) {
            // запись всей строки
            String line = id + "," + topic + "\n";
            writer.write(line);
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("данные записаны...");
    }
   */
}



