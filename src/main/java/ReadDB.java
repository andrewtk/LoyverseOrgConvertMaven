import java.sql.*;

public class ReadDB {


    /**
     * Simple Java program to connect to MySQL database running on localhost and
     * running SELECT and INSERT query to retrieve and add data.
     * @author Javin Paul
     */


        // JDBC URL, username and password of MySQL server
        private static final String url = "jdbc:mysql://localhost:3306/lorg";
        private static final String user = "root";
        private static final String password = "root";

        // JDBC variables for opening and managing connection
        private static Connection con;
        private static Statement stmt;
        private static ResultSet rs;

        public static void main(String args[]) {
            String query = "select count(*) from qa_posts";

            try {
                // opening database connection to MySQL server
                con = DriverManager.getConnection(url, user, password);

                // getting Statement object to execute query
                stmt = con.createStatement();

                // executing SELECT query
                rs = stmt.executeQuery(query);

                while (rs.next()) {
                    int count = rs.getInt(1);
                    System.out.println("Total number of books in the table : " + count);
                }

            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            } finally {
                //close connection ,stmt and resultset here
                try { con.close(); } catch(SQLException se) { /*can't do anything */ }
                try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
                try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
            }
        }



}
