package dao;

import connectDB.ConnectDB;
import entity.NhaPhanPhoi;
import entity.SanPham;
import entity.XeMay;

import java.sql.*;
import java.util.ArrayList;

public class SanPham_DAO {
    public ArrayList<SanPham> getAllTableSanPham() {
        ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select * from SanPham";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString("maSanPham");
                XeMay xe = new XeMay(rs.getString("maXe"));
                double gia = rs.getDouble("gia");
                boolean tinhTrang = rs.getBoolean("tinhTrang");
                int soLuong = rs.getInt("soLuong");
                String moTa = rs.getString("moTa");
                NhaPhanPhoi npp = new NhaPhanPhoi(rs.getString("maNhaPhanPhoi"));
                SanPham sp = new SanPham(maSP, xe, gia, tinhTrang, soLuong, moTa, npp);

                dsSanPham.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsSanPham;
    }

    public ArrayList<SanPham> getSanPhamTheoMa(String ma) {
        ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "Select * from SanPham where maSanPham = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSanPham");
                XeMay xe = new XeMay(rs.getString("maXe"));
                double gia = rs.getDouble("gia");
                boolean tinhTrang = rs.getBoolean("tinhTrang");
                int soLuong = rs.getInt("soLuong");
                String moTa = rs.getString("moTa");
                NhaPhanPhoi npp = new NhaPhanPhoi(rs.getString("maNhaPhanPhoi"));
                SanPham sp = new SanPham(maSP, xe, gia, tinhTrang, soLuong, moTa, npp);

                dsSanPham.add(sp);
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
        return dsSanPham;
    }

    public ArrayList<SanPham> getSanPhamTheoMaXe(String ma) {
        ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "Select * from SanPham where maXe = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSanPham");
                XeMay xe = new XeMay(rs.getString("maXe"));
                double gia = rs.getDouble("gia");
                boolean tinhTrang = rs.getBoolean("tinhTrang");
                int soLuong = rs.getInt("soLuong");
                String moTa = rs.getString("moTa");
                NhaPhanPhoi npp = new NhaPhanPhoi(rs.getString("maNhaPhanPhoi"));
                SanPham sp = new SanPham(maSP, xe, gia, tinhTrang, soLuong, moTa, npp);

                dsSanPham.add(sp);
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
        return dsSanPham;
    }

    public ArrayList<SanPham> getSanPhamTheoMaNhaPhanPhoi(String ma) {
        ArrayList<SanPham> dsSanPham = new ArrayList<SanPham>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "Select * from SanPham where maNhaPhanPhoi = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maSanPham");
                XeMay xe = new XeMay(rs.getString("maXe"));
                double gia = rs.getDouble("gia");
                boolean tinhTrang = rs.getBoolean("tinhTrang");
                int soLuong = rs.getInt("soLuong");
                String moTa = rs.getString("moTa");
                NhaPhanPhoi npp = new NhaPhanPhoi(rs.getString("maNhaPhanPhoi"));
                SanPham sp = new SanPham(maSP, xe, gia, tinhTrang, soLuong, moTa, npp);

                dsSanPham.add(sp);
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
        return dsSanPham;
    }

    public boolean create(SanPham sp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;

        try {
            statement = con.prepareStatement("insert SanPham values (?,?,?,?,?,?,?)");
            statement.setString(1, sp.getMaSanPham());
            statement.setString(2, sp.getXe().getMaXeMay());
            statement.setDouble(3, sp.getGia());
            statement.setBoolean(4, sp.getTinhTrang());
            statement.setInt(5, sp.getSoLuong());
            statement.setString(6, sp.getMoTa());
            statement.setString(7, sp.getNhaPhanPhoi().getMaNhaPhanPhoi());
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

    public boolean update(SanPham sp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {
            statement = con.prepareStatement(
                    "update SanPham set maXe=?, gia=?, tinhTrang=?, soLuong=?, moTa=?, maNhaPhanPhoi=?" + "where maSanPham=? ");
            statement = con.prepareStatement("insert SanPham values (?,?,?,?,?,?,?)");
            statement.setString(1, sp.getXe().getMaXeMay());
            statement.setDouble(2, sp.getGia());
            statement.setBoolean(3, sp.getTinhTrang());
            statement.setInt(4, sp.getSoLuong());
            statement.setString(5, sp.getMoTa());
            statement.setString(6, sp.getNhaPhanPhoi().getMaNhaPhanPhoi());
            statement.setString(7, sp.getMaSanPham());
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

    public void delete(String maSP) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from SanPham where maSanPham = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maSP);
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
