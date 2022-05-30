package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    
    private static Connection connection = null;
    
    public static Connection getConnection() {
        if ( connection != null ) {
            return connection;
        } else {
            try {
                
                String url = System.getenv("DB_URL");
                String user = System.getenv("DB_USER");
                String password = System.getenv("DB_PASSWORD");
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                connection = DriverManager.getConnection(url, user, password);
            } catch ( ClassNotFoundException | SQLException e ) {
                e.printStackTrace();
            }
            return connection;
        }
        
    }
    
    public static void closeConnection() throws SQLException {
        connection.close();
    }
    
}
