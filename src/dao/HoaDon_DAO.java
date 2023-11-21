package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.SanPham;

import java.sql.*;
import java.util.ArrayList;

public class HoaDon_DAO {
    public ArrayList<HoaDon> getAllTableHoaDon() {
        ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select * from HoaDon";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                double giaSP = rs.getDouble("giaSP");
                SanPham sp = new SanPham(rs.getString("maSanPham"));
                
                HoaDon hd = new HoaDon(maHoaDon, giaSP ,sp);

                dsHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

   public ArrayList<HoaDon> getHoaDonTheoMa(String maHD) {
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM HoaDon WHERE maHoaDon = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maHD);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                double giaSP = rs.getDouble("giaSP");
                SanPham sp = new SanPham(rs.getString("maSanPham"));
                
                HoaDon hd = new HoaDon(maHoaDon, giaSP ,sp);


                dsHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return dsHoaDon;
    }


    public boolean create(HoaDon hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;

        try {
            statement = con.prepareStatement("insert HoaDon values (?,?,?)");
            statement.setString(1, hd.getMaHoaDon());
            statement.setDouble(2, hd.getGiaSP());
            statement.setString(3, hd.getSanPham().getMaSanPham());
            n = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public void update(HoaDon hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(
                    "update HoaDon set maHoaDon=?, giaSP=? , maSanPham=?" + "where maHoaDon=? ");
            statement.setString(1, hd.getMaHoaDon());
            statement.setDouble(2, hd.getGiaSP());
            statement.setString(3, hd.getSanPham().getMaSanPham());
            statement.setString(4, hd.getMaHoaDon());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void delete(String maHD) throws SQLException {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from HoaDon where maHoaDon = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            stmt.close();
        }
    }
}
