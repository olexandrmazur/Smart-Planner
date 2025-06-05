package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserChecker {
    public static boolean isLoginAvailable(String login) {
        String sql = "SELECT 1 FROM users WHERE login = ? LIMIT 1;";

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);

            try (ResultSet rs = stmt.executeQuery()) {
                return !rs.next();
            }

        } catch (SQLException e) {
            System.err.println("Помилка при перевірці доступності логіна: " + e.getMessage());
            return false;
        }
    }

    public static Integer getUserIdByLogin(String login) {
        String sql = "SELECT id FROM users WHERE login = ?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}