import DBlorg.tables.records.QaBlobsRecord;
import DBnewLogrExtra.tables.Answers;
import DBnewLogrExtra.tables.Comments;
import DBnewLogrExtra.tables.Questions;
import DBnewLogrExtra.tables.records.AnswersRecord;
import DBnewLogrExtra.tables.records.CommentsRecord;
import DBnewLogrExtra.tables.records.QuestionsRecord;
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
    public static void main(String[] args) {
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/newlogrExtra?autoReconnect=true&useSSL=false";
        String oldLink = "https://s3.eu-central-1.amazonaws.com/devloyverseorg/pictures/";
        System.out.println("Start database connect...");

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext db = DSL.using(conn, SQLDialect.MYSQL);
            System.out.println("Connected database successfully...");
            Result<AnswersRecord> answers = db.selectFrom(Answers.ANSWERS).where(Answers.ANSWERS.CONTENT.contains(oldLink)).fetch();
            Result<QuestionsRecord> questions = db.selectFrom(Questions.QUESTIONS).where(Questions.QUESTIONS.CONTENT.contains(oldLink)).fetch();
            int i = 1;

            for (AnswersRecord answer : answers) {
                String content = answer.getContent();
                if (content != null && content.contains(oldLink)) {
                    answer.setContent(exchangeIdToFileName(content));
                    System.out.println("записали строку " + i++ + " in answer");
                }

            }
            db.batchUpdate(answers).execute();


            i = 1;
            for (QuestionsRecord question : questions) {
                String content = question.getContent();
                if (content != null && content.contains(oldLink)) {
                    question.setContent(exchangeIdToFileName(content));
                    System.out.println("записали строку " + i++ + " in question");
                }
            }
            db.batchUpdate(questions).execute();
            db.close();
        } catch (
                SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static String exchangeIdToFileName(String content) {

        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lorg?autoReconnect=true&useSSL=false";
        String newContent = content;
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext db = DSL.using(conn, SQLDialect.MYSQL);
            System.out.println("Connected database successfully...");
            Result<QaBlobsRecord> avatars = db.selectFrom(QA_BLOBS).fetch();
            int i = 0;
            for (QaBlobsRecord avatar : avatars) {
                ULong blobID = avatar.getBlobid();
                String fileName = avatar.getFilename();
                if (fileName != null && content.contains(String.valueOf(blobID))) {
                    newContent = content.replaceAll(String.valueOf(blobID), fileName);
                    System.out.println("Провели замену в строке " + i++ + " with ID blub " + blobID + " for filename " + fileName);
                }
                //todo поставить условие замены при выполнения условия вхождения

            }
            db.close();
            // For the sake of this tutorial, let's keep exception handling simple
        } catch (
                SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return newContent;
    }
}


