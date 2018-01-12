import static DBnewLogrExtra.Tables.*;
import static DBlorg.Tables.*;

import DBlorg.tables.records.QaBlobsRecord;
import DBlorg.tables.records.QaUservotesRecord;
import DBnewLogrExtra.tables.records.UserToVotesRecord;
import DBnewLogrExtra.tables.records.VotesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
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
    public static void main(String[] args) {
        saveAvatars();
    }


    public static void saveAvatars() {
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";

        System.out.println("\nConnecting to a selected database...");
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext db = DSL.using(conn, SQLDialect.MYSQL);
            System.out.println("Connected database successfully...");
            Result<QaBlobsRecord> avatars = db.selectFrom(QA_BLOBS).fetch();
            for (QaBlobsRecord avatar : avatars) {

                ULong blobID = avatar.getBlobid();
                String fileName = avatar.getFilename();
                String format = avatar.getFormat();
                byte[] content = avatar.getContent();
                String dirFolder = "pictures";
                if (fileName == null) {
                    fileName = blobID.toString() + ".jpeg";
                    dirFolder = "avatars";
                }
                saveToFile(content, fileName, dirFolder);
            }
            // For the sake of this tutorial, let's keep exception handling simple
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    private static void saveToFile(byte[] data, String fileName, String dirFolder) {

        // определяем объект для каталога
        File dir = new File("D:\\TempDir\\" + dirFolder + "\\");
        if (!dir.exists()) {
            boolean wasSuccessful = dir.mkdir();
            if (!wasSuccessful) {
                System.out.println("Не удалось создать папку " + dirFolder);
            }
        }

        File file = new File(fileName);
        System.out.println("Writing to file " + file.getName());
        try (FileOutputStream writer = new FileOutputStream(dir + File.separator + file.getName() + "", false)) {
            // запись всей строки в файл
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


