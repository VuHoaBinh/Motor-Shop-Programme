package dao;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;
import java.sql.*;
import java.util.ArrayList;

public class NhanVien_DAO {
    public NhanVien_DAO() {}
    public ArrayList<NhanVien> getAllTbNhanVien(){
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
                PhongBan p = new PhongBan(rs.getString("maPhongBan"));
                
                NhanVien nv = new NhanVien(maNV, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, p);

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
                PhongBan p = new PhongBan(rs.getString("maPhongBan"));
                NhanVien nv = new NhanVien(maNV, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, p);

                dsNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                PhongBan p = new PhongBan(rs.getString("maPhongBan"));
                NhanVien nv = new NhanVien(maNV, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, p);

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

    public void create(NhanVien nv) throws SQLException {
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO NhanVien VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, nv.getMaNhanVien());
            stmt.setString(2, nv.getHoTen());
            stmt.setString(3, nv.getSdt());
            stmt.setString(4, nv.getDiaChi());
            stmt.setString(5, nv.getEmail());  
            stmt.setBoolean(6, nv.getGioiTinh());
            stmt.setString(7, nv.getChucVu());
            stmt.setInt(8, nv.getTuoi());
            stmt.setString(9, nv.getMaPhongBan().getMaPhongBan());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            stmt.close();
        }
    }

    public void update(NhanVien nv) throws SQLException {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "UPDATE NhanVien SET maNhanVien=?, hoTen=?, sdt=?, diaChi=?, email=?, gioiTinh=?, chucVu=?, tuoi=?, maPhongBan=? WHERE maNhanVien=?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, nv.getMaNhanVien());
            statement.setString(2, nv.getHoTen());
            statement.setString(3, nv.getSdt());
            statement.setString(4, nv.getDiaChi());
            statement.setString(5, nv.getEmail());
            statement.setBoolean(6, nv.getGioiTinh());
            statement.setString(7, nv.getChucVu());
            statement.setInt(8, nv.getTuoi());
            statement.setString(9, nv.getMaPhongBan().getMaPhongBan());
            statement.setString(10, nv.getMaNhanVien());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(NhanVien nv) throws SQLException {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from NhanVien where maNhanVien = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nv.getMaNhanVien());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }
    }
    
    
}
