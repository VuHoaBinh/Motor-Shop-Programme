package dao;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;

import java.sql.*;
import java.util.ArrayList;

public class NhanVien_DAO {
    public ArrayList<NhanVien> getAllTableNhanVien() {
        ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select * from NhanVien";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString("maNhanVien");
                String hoTen = rs.getString("hoTen");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("diaChi");
                String email = rs.getString("email");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                String chucVu = rs.getString("chucVu");
                int tuoi = rs.getInt("tuoi");
                double tienLuong = rs.getDouble("tienLuong");
                PhongBan p = new PhongBan(rs.getString("maPhong"));
                NhanVien nv = new NhanVien(maNV, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, tienLuong, p);

                dsNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    public ArrayList<NhanVien> getNVTheoMa(String ma) {
        ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "Select * from NhanVien where maNhanVien = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString("maNhanVien");
                String hoTen = rs.getString("hoTen");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("diaChi");
                String email = rs.getString("email");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                String chucVu = rs.getString("chucVu");
                int tuoi = rs.getInt("tuoi");
                double tienLuong = rs.getDouble("tienLuong");
                PhongBan p = new PhongBan(rs.getString("maPhong"));
                NhanVien nv = new NhanVien(maNV, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, tienLuong, p);

                dsNhanVien.add(nv);
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
        return dsNhanVien;
    }

    public ArrayList<NhanVien> getNVTheoMaPhongBan(String ma) {
        ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "Select * from nhanvien where maPhongBan = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString("maNhanVien");
                String hoTen = rs.getString("hoTen");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("diaChi");
                String email = rs.getString("email");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                String chucVu = rs.getString("chucVu");
                int tuoi = rs.getInt("tuoi");
                double tienLuong = rs.getDouble("tienLuong");
                PhongBan p = new PhongBan(rs.getString("maPhong"));
                NhanVien nv = new NhanVien(maNV, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, tienLuong, p);

                dsNhanVien.add(nv);
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
        return dsNhanVien;
    }

    public boolean create(NhanVien nv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;

        try {
            statement = con.prepareStatement("insert NhanVien values (?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, nv.getMaNhanVien());
            statement.setString(2, nv.getHoTen());
            statement.setString(3, nv.getSdt());
            statement.setString(4, nv.getDiaChi());
            statement.setString(5, nv.getEmail());
            statement.setBoolean(6, nv.getGioiTinh());
            statement.setString(7, nv.getChucVu());
            statement.setInt(8, nv.getTuoi());
            statement.setDouble(9, nv.getTienLuong());
            statement.setString(10, nv.getPhong().getMaPhongBan());
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

    public boolean update(NhanVien nv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {
            statement = con.prepareStatement(
                    "update NhanVien set hoTen=?, sdt=?" + "diaChi=?, email=?,gioiTinh=?, chucVu=?, tuoi=?, tienLuong=?, maPhong=?" + "where maNhanVien=? ");
            statement.setString(1, nv.getHoTen());
            statement.setString(2, nv.getSdt());
            statement.setString(3, nv.getDiaChi());
            statement.setString(4, nv.getEmail());
            statement.setBoolean(5, nv.getGioiTinh());
            statement.setString(6, nv.getChucVu());
            statement.setInt(7, nv.getTuoi());
            statement.setDouble(8, nv.getTienLuong());
            statement.setString(9, nv.getPhong().getMaPhongBan());
            statement.setString(10, nv.getMaNhanVien());
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

    public void delete(String maNV) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from NhanVien where maNhanVien = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maNV);
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
