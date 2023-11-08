package dao;

import connectDB.ConnectDB;
import entity.NhaPhanPhoi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NhaPhanPhoi_DAO {
    public ArrayList<NhaPhanPhoi> getAllTableNhaPhanPhoi() {
        ArrayList<NhaPhanPhoi> dsNhaPP = new ArrayList<NhaPhanPhoi>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select * from NhaPhanPhoi";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maNPP = rs.getString("maNhaPhanPhoi");
                String tenNPP = rs.getString("tenNhaPhanPhoi");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("diaChi");
                NhaPhanPhoi npp = new NhaPhanPhoi(maNPP, tenNPP, sdt, diaChi);
                dsNhaPP.add(npp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNhaPP;
    }
}
