package database;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://metro.proxy.rlwy.net:50901/railway";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "sSkmcdcLimVmVzIbwovIOyKkENAlNcTw";
    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("✅ Подключение успешно");
            return conn;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
