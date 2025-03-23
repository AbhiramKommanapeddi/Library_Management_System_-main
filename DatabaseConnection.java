import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3300/Library";
    private static final String USER = "root";
    private static final String PASSWORD = "Kiran@232";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return connection;
    }
}