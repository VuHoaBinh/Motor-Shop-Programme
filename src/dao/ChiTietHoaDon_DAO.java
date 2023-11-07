package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChiTietHoaDon_DAO {
    public ArrayList<ChiTietHoaDon> getAllTableChiTietHD() {
        ArrayList<ChiTietHoaDon> dsChiTietHD = new ArrayList<ChiTietHoaDon>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select * from ChiTietHoaDon";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString("maSanPham"));
                HoaDon hd = new HoaDon(rs.getString("maHoaDon"));

                ChiTietHoaDon ct = new ChiTietHoaDon(sp, hd);
                dsChiTietHD.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsChiTietHD;
    }
}
