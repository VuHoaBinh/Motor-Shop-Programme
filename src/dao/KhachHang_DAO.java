package dao;

import connectDB.ConnectDB;
import entity.KhachHang;

import java.sql.*;
import java.util.ArrayList;

public class KhachHang_DAO {
    public ArrayList<KhachHang> getAllTableKhachHang() {
        ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select * from KhachHang";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maKH = rs.getString("maKhachHang");
                String hoTen = rs.getString("hoTen");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("diaChi");
                KhachHang kh = new KhachHang(maKH, hoTen, sdt, diaChi);

                dsKhachHang.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKhachHang;
    }

    public ArrayList<KhachHang> getKHTheoMa(String ma) {
        ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "Select * from KhachHang where maKhachHang = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("maKhachHang");
                String hoTen = rs.getString("hoTen");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("diaChi");
                KhachHang kh = new KhachHang(maKH, hoTen, sdt, diaChi);

                dsKhachHang.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return dsKhachHang;
    }

    public boolean create(KhachHang kh) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;

        try {
            statement = con.prepareStatement("insert KhachHang values (?,?,?,?)");
            statement.setString(1, kh.getMaKhachHang());
            statement.setString(2, kh.getHoTen());
            statement.setString(3, kh.getSdt());
            statement.setString(4, kh.getDiaChi());
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

    public void update(KhachHang kh) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "UPDATE KhachHang SET maKhachHang=?, hoTen=?, sdt=?, diaChi=? WHERE maKhachHang=?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, kh.getMaKhachHang());
            statement.setString(2, kh.getHoTen());
            statement.setString(3, kh.getSdt());
            statement.setString(4, kh.getDiaChi());
            statement.setString(5, kh.getMaKhachHang()); 
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }


    public void delete(KhachHang kh) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from KhachHang where maKhachHang = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, kh.getMaKhachHang());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
