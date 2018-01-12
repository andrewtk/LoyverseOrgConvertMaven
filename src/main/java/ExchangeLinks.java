import DBlorg.tables.records.QaBlobsRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.types.ULong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static DBlorg.Tables.QA_BLOBS;

public class ExchangeLinks {

    public static String exchangeIdToFileName(String content) {

        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext db = DSL.using(conn, SQLDialect.MYSQL);
            System.out.println("Connected database successfully...");
            Result<QaBlobsRecord> avatars = db.selectFrom(QA_BLOBS).fetch();

            for (QaBlobsRecord avatar : avatars) {
                ULong blobID = avatar.getBlobid();
                String fileName = avatar.getFilename();
                if (fileName == null) {
                   continue;
                }
                content = content.replace(blobID.toString(),fileName);

            }
            // For the sake of this tutorial, let's keep exception handling simple
        } catch (
                SQLException sqlEx)
        {
            sqlEx.printStackTrace();
        }
        return content;
    }
}


