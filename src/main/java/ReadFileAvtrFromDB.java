import static DBnewLogrExtra.Tables.*;
import static DBlorg.Tables.*;

import DBlorg.tables.records.QaBlobsRecord;
import DBlorg.tables.records.QaUservotesRecord;
import DBnewLogrExtra.tables.records.UserToVotesRecord;
import DBnewLogrExtra.tables.records.VotesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.UShort;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DBlorg.tables.records.QaPostsRecord;
import DBlorg.tables.records.QaUservotesRecord;
import DBnewLogrExtra.tables.records.UserToVotesRecord;
import DBnewLogrExtra.tables.records.VotesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static DBlorg.Tables.QA_USERVOTES;
import static DBnewLogrExtra.Tables.VOTES;

public class ReadFileAvtrFromDB {


    public static void saveAvatars() {
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lorg";
        String urlNew = "jdbc:mysql://localhost:3306/newlogrExtra";
        System.out.println("\nConnecting to a selected database...");
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext db = DSL.using(conn, SQLDialect.MYSQL);
            System.out.println("Connected database successfully...");
            Result<QaBlobsRecord> avatars = db.selectFrom(QA_BLOBS).fetch();
            for (QaBlobsRecord avatar:avatars) {
                String userID = avatar.getUserid();
                if (userID!=null){
                    byte[] content = avatar.getContent();
                    saveToFile(content,userID);
                }


            }



            // For the sake of this tutorial, let's keep exception handling simple
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

     private static void saveToFile(byte[] data, String fileName)  {

        // определяем объект для каталога
        File dir = new File("D:\\TempDir\\avatars\\");
        if (!dir.exists()) {
            boolean wasSuccessful = dir.mkdir();
            if (!wasSuccessful) {
                System.out.println("Не удалось создать папку avatars.");
            }
        }

        File file = new File(fileName);
        System.out.println("Writing to file " + file.getName());
        try (FileOutputStream writer = new FileOutputStream(dir + File.separator + file.getName() + ".jpg", false)) {
           // запись всей строки в файл
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


