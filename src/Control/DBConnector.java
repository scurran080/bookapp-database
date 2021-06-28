package Control;

import java.sql.*;

public class DBConnector {

    private String url = "jdbc:postgresql://localhost:5432/books?user=postgres&password=jethro";
    private String user = "postgres";
    private String password = "jethro";

    public enum ACTION {
        INSERT,
        SELECT
    }

    ;
    private String q = "SELECT * FROM book";

    public void connect(ACTION act, String query) {

        if (act == null) {
            return;
        }
        if (act == ACTION.SELECT) {
            try {
                Connection conn = DriverManager.getConnection(url);
                if (conn != null) {
                    System.out.println("Connected.");
                } else {
                    System.out.println("Connection Failed.");
                }
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    String isbn = rs.getString("isbn");
                    String date = rs.getString("date");
                    System.out.println("Retreived: " + title + " by: " + author + " isbn: " + isbn + " published: " + date);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (act == ACTION.INSERT) {
            try {
                Connection conn = DriverManager.getConnection(url);
                conn.setAutoCommit(false);
                if (conn != null) {
                    System.out.println("Connected.");
                } else {
                    System.out.println("Connection Failed.");
                }
                Statement st = conn.createStatement();
                if (st != null) {
                    System.out.println("Inserted new book.");
                }
                st.executeUpdate(query);
                conn.commit();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
