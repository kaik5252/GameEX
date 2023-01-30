package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Control.PopUps;

public class DbConnection {

    private Connection conn = null;
    private static final String URL = "jdbc:sqlite:src/resources/games.db";

    public Connection connect() {
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException err) {
            PopUps.showError(err);
        }

        return conn;
    }

    public static void dbClose(Connection conn, PreparedStatement pstm, ResultSet res) {
        if (res != null) try {
            res.close();
        } catch (SQLException ignore) {}

        if (pstm != null) try {
            pstm.close();
        } catch (SQLException ignore) {}

        if (conn != null) try {
            conn.close();
        } catch (SQLException ignore) {}
    }
}
