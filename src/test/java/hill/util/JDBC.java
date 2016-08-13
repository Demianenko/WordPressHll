package hill.util;

import java.sql.*;

/**
 * Created by user on 12.08.2016.
 */
public class JDBC {
    private static final String url = "jdbc:mysql://localhost:3306/mysql";
    private static final String user = "root";
    private static final String password = "470780";


// JDBC variables for opening and managing connection
        private static Connection con;
        private static Statement stmt;
        private static ResultSet rs;

    public static void main(String args[]) {
        String query = "select count(*) from books";
        query = "select * from db;";
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println();
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

