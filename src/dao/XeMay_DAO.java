package dao;

import connectDB.ConnectDB;
import entity.LoaiXe;
import entity.XeMay;

import java.sql.*;
import java.util.ArrayList;

public class XeMay_DAO {
    public ArrayList<XeMay> getAllTableXeMay() {
        ArrayList<XeMay> dsXeMay = new ArrayList<XeMay>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select * from XeMay";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maXe = rs.getString("maXeMay");
                LoaiXe lx = new LoaiXe(rs.getString("loaiXe"));
                String thuongHieu = rs.getString("thuongHieu");
                int tocDo = rs.getInt("tocDo");
                String khoiLuong = rs.getString("khoiLuong");
                String kichThuoc = rs.getString("kichThuoc");
                double dungTichBinhXang = rs.getDouble("dungTichBinhXang");
                double dungTichXyLanh = rs.getDouble("dungTichXyLanh");
                String mauSac = rs.getString("mauSac");
                XeMay xe = new XeMay(maXe, lx, thuongHieu, tocDo, khoiLuong, kichThuoc, dungTichBinhXang, dungTichXyLanh, mauSac);

                dsXeMay.add(xe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsXeMay;
    }

    public ArrayList<XeMay> getXeMayTheoMa(String ma) {
        ArrayList<XeMay> dsXeMay = new ArrayList<XeMay>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "Select * from XeMay where maXeMay = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maXe = rs.getString("maXeMay");
                LoaiXe lx = new LoaiXe(rs.getString("loaiXe"));
                String thuongHieu = rs.getString("thuongHieu");
                int tocDo = rs.getInt("tocDo");
                String khoiLuong = rs.getString("khoiLuong");
                String kichThuoc = rs.getString("kichThuoc");
                double dungTichBinhXang = rs.getDouble("dungTichBinhXang");
                double dungTichXyLanh = rs.getDouble("dungTichXyLanh");
                String mauSac = rs.getString("mauSac");
                XeMay xe = new XeMay(maXe, lx, thuongHieu, tocDo, khoiLuong, kichThuoc, dungTichBinhXang, dungTichXyLanh, mauSac);

                dsXeMay.add(xe);
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
        return dsXeMay;
    }

    public ArrayList<XeMay> getXeMayTheoMaLoai(String ma) {
        ArrayList<XeMay> dsXeMay = new ArrayList<XeMay>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "Select * from XeMay where loaiXe = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maXe = rs.getString("maXeMay");
                LoaiXe lx = new LoaiXe(rs.getString("loaiXe"));
                String thuongHieu = rs.getString("thuongHieu");
                int tocDo = rs.getInt("tocDo");
                String khoiLuong = rs.getString("khoiLuong");
                String kichThuoc = rs.getString("kichThuoc");
                double dungTichBinhXang = rs.getDouble("dungTichBinhXang");
                double dungTichXyLanh = rs.getDouble("dungTichXyLanh");
                String mauSac = rs.getString("mauSac");
                XeMay xe = new XeMay(maXe, lx, thuongHieu, tocDo, khoiLuong, kichThuoc, dungTichBinhXang, dungTichXyLanh, mauSac);

                dsXeMay.add(xe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return dsXeMay;
    }

    public boolean create(XeMay xe) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;

        try {
            statement = con.prepareStatement("insert XeMay values (?,?,?,?,?,?,?,?,?)");
            statement.setString(1, xe.getMaXeMay());
            statement.setString(2, xe.getLoaiXe().getMaLoai());
            statement.setString(3, xe.getThuongHieu());
            statement.setInt(4, xe.getTocDo());
            statement.setString(5, xe.getKhoiLuong());
            statement.setString(6, xe.getKichThuoc());
            statement.setDouble(7, xe.getDungTichBinhXang());
            statement.setDouble(8, xe.getDungTichXyLanh());
            statement.setString(9, xe.getMauSac());
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

    public boolean update(XeMay xe) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {
            statement = con.prepareStatement(
                    "update XeMay set loaiXe=?, thuongHieu=?, tocDo=?, khoiLuong=?,kichThuoc=?, dungTichBinhXang=?, dungTichXyLanh=?, mauSac=?" + "where maXeMay=? ");
            statement.setString(1, xe.getLoaiXe().getMaLoai());
            statement.setString(2, xe.getThuongHieu());
            statement.setInt(3, xe.getTocDo());
            statement.setString(4, xe.getKhoiLuong());
            statement.setString(5, xe.getKichThuoc());
            statement.setDouble(6, xe.getDungTichBinhXang());
            statement.setDouble(7, xe.getDungTichXyLanh());
            statement.setString(8, xe.getMauSac());
            statement.setString(9, xe.getMaXeMay());
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

    public void delete(String maXe) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from XeMay where maXeMay = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maXe);
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
