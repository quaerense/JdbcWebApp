package connection;

import java.sql.*;

public class MySqlJdbcConnection implements JdbcConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/users_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}