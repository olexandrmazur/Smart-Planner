package database;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    public static boolean createUser(User s) {
        if (UserChecker.isLoginAvailable(s.getLogin())) {
            try (Connection conn = Database.connect()) {
                String sql = "INSERT INTO users (login, password) VALUES (?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, s.getLogin());
                    stmt.setString(2, s.getPassword());
                    stmt.executeUpdate();
                }
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean checkUser(User s) {
        String sql = "SELECT 1 FROM users WHERE login = ? AND password = ? LIMIT 1";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getLogin());
            stmt.setString(2, s.getPassword());
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Помилка при перевірці користувача: " + e.getMessage());
            return false;
        }
    }
}