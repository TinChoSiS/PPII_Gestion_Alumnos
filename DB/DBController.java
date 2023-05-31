package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import handlers.ErrorHandler;
import models.Usuario;

public class DBController {
    private DBConnect dbConn;

    public DBController() {
        this.dbConn = new DBConnect();
    }

    public Usuario userLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ? LIMIT 1";

        try (Connection conn = this.dbConn.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setQueryTimeout(5);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet userSet = pstmt.executeQuery();

            if (userSet.next()) {
                Usuario user = new Usuario(
                        userSet.getInt("id"),
                        userSet.getString("name"),
                        userSet.getString("username"),
                        userSet.getBoolean("is_staff"),
                        userSet.getString("grupo"),
                        userSet.getInt("calificacion"));
                conn.close();

                return user;
            }

        } catch (Exception e) {
            new ErrorHandler(e);

        }
        return null;

    }

    public String userAdd(String username, String password, boolean is_staff) {
        String sql = "INSERT INTO users VALUES(?, ?, ?)";

        try (Connection conn = this.dbConn.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setQueryTimeout(5);

            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            new ErrorHandler(e);

        }
        return username;

    }

    public List<Usuario> selectAlumnos(String groupfilter) {
        return selectUsers(groupfilter, false);
    }

    public List<Usuario> selectProfesores() {
        return selectUsers(null, true);

    }

    private List<Usuario> selectUsers(String groupfilter, boolean is_staff) {
        String sql = "SELECT * FROM users";
        sql += " WHERE is_staff = " + is_staff;
        if (groupfilter != null) {
            sql += " AND grupo = '" + groupfilter + "'";
        }

        try (Connection conn = this.dbConn.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setQueryTimeout(5);

            ResultSet userSet = pstmt.executeQuery();

            List<Usuario> users = new ArrayList<Usuario>();

            while (userSet.next()) {
                users.add(new Usuario(
                        userSet.getInt("id"),
                        userSet.getString("name"),
                        userSet.getString("username"),
                        userSet.getBoolean("is_staff"),
                        userSet.getString("grupo"),
                        userSet.getInt("calificacion")));
            }
            conn.close();

            return users;

        } catch (Exception e) {
            new ErrorHandler(e);

        }
        return null;

    }

}
