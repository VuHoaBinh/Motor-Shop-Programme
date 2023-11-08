package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection con = null;
    private static final ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
            return instance;
    }

    public void connect() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databasename=QLXeMay";
        String user = "sa";
        String password = "sapassword";
        con = DriverManager.getConnection(url, user, password);
    }

    public void disconnect() {
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
            
    }

    public static Connection getConnection() {
            return con;
    }
}
