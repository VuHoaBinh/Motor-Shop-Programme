package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
//    public static Connection con = null;
//    private static final ConnectDB instance = new ConnectDB();
//
//    
//
//    public void connect() throws SQLException {
//        String url = "jdbc:sqlserver://localhost:1433;databasename=HTG_QD_MuaXeMay";
//        String user = "sa";
//        String password = "sapassword";
//        con = DriverManager.getConnection(url, user, password);
//    }
//
//    public void disconnect() {
//        if (con != null){
//            try {
//                con.close();
//            } catch (SQLException e) {
//            }
//        }
//            
//    }
//
//    public static Connection getConnection() {
//            return con;
//    }
    private static final ConnectDB instance = new ConnectDB();
    public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=HTG_QD_MuaXeMay";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }
        try {
            conn = (Connection) DriverManager.getConnection(connectionUrl,"sa","sapassword");
            return conn;
        } catch (Exception e) {
            //lỗi sai tên database
            //lỗi tên đăng nhập và mật khẩu
            System.out.println("Error: "+e.toString());
        }
        return conn;
    }
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }  
    public static ConnectDB getInstance() {
            return instance;
    }
    public static void main(String[] args) {
        ConnectDB ketnoi = new ConnectDB();
        ketnoi.getConnection();
    }
}
