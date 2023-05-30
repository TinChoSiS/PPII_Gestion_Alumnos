package DB;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.sqlite.SQLiteConfig;

import handlers.ErrorHandler;
import utils.Menu;

/**
 * Conection
 */
public class DBConnect {
    private Menu initDBMenu;

    private String driverConn;
    private String DBPath = System.getProperty("user.dir") + "\\DB\\DB.db";
    private File dbFile;

    public DBConnect() {
        this.driverConn = "jdbc:sqlite:" + DBPath;
        this.initDBMenu = new Menu();
        this.dbFile = new File(DBPath);

        if (!this.dbFile.exists()) {
            boolean initRes = initDB();
            if (initRes) {
                System.out.println("Base de datos creada con éxito");
            } else {
                System.out.println("Error al crear la base de datos");
                this.dbFile.delete();
            }
        }

    }

    public Connection connect() {
        Connection conn = null;
        SQLiteConfig config = new SQLiteConfig();
        config.setEncoding(SQLiteConfig.Encoding.UTF8);

        try {
            conn = DriverManager.getConnection(driverConn, config.toProperties());

        } catch (SQLException e) {
            new ErrorHandler(e);
        }

        return conn;
    }

    private boolean initDB() {
        this.initDBMenu.printTitle("Inicializando Base de Datos", "=");
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.setQueryTimeout(5);

            stmt.executeUpdate(
                    "CREATE TABLE users ("
                            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + "name VARCHAR(50) NOT NULL,"
                            + "username VARCHAR(20) NOT NULL,"
                            + "password VARCHAR(50) NOT NULL,"
                            + "grupo VARCHAR(10),"
                            + "calificacion INT,"
                            + "is_staff BOOL DEFAULT false"
                            + ")");

            stmt.executeUpdate("INSERT INTO users(name,username,password,grupo,calificacion,is_staff) VALUES "
                    + "('Administrador', 'admin', 'admin', '2°BK', 0, true)"
                    + ",('Alumno 1', 'user1', 'user', '2°BK', 8, false)"
                    + ",('Alumno 2', 'user2', 'user2', '2°BK', 4, false)"
                    + ",('Alumno 3', 'user3', 'user3', '2°BK', 10, false)"
                    + ",('Alumno 4', 'user4', 'user4', '2°BK', 11, false)"
                    + ",('Alumno 5', 'user5', 'user5', '2°BK', 6, false)"
                    + ",('Alumno 6', 'user6', 'user6', '2°BK', 6, false)"
                    + ",('Alumno 7', 'user7', 'user7', '2°BK', 2, false)"
                    + ",('Alumnoñ 8', 'userñ', 'user8', '2°BK', 7, false)");

            conn.close();
        } catch (Exception e) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e1) {
            }
            this.dbFile.delete();
            return false;
        }
        return true;
    }

    // private void close(){
    // try {
    // if (this.conn != null) {
    // this.conn.close();
    // }
    // } catch (SQLException e1) {
    // new ErrorHandler(e1);
    // }
    // }

}