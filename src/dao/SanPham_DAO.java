package dao;

import connectDB.ConnectDB;
import entity.LoaiXe;
import entity.NhaPhanPhoi;
import entity.SanPham;

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
                String tenXe = rs.getString("tenXeMay");
                
                LoaiXe loaiXe = new LoaiXe(rs.getString("maLoai"));
                NhaPhanPhoi npp = new NhaPhanPhoi(rs.getString("maNhaPhanPhoi"));
                
                double gia = rs.getDouble("gia");
                int namSanXuat = rs.getInt("namSanXuat");
                int soluong = rs.getInt("soLuong");
                String xiLanh = rs.getString("dungTichXyLanh");
                String mauSac = rs.getString("mauSac");
                
                SanPham sp = new SanPham(maSP, tenXe, loaiXe, npp, gia, namSanXuat, soluong , xiLanh ,mauSac);

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
                String tenXe = rs.getString("tenXeMay");
                LoaiXe loaiXe = new LoaiXe(rs.getString("maLoai"));
                NhaPhanPhoi npp = new NhaPhanPhoi(rs.getString("maNhaPhanPhoi"));
                double gia = rs.getDouble("gia");
                int namSanXuat = rs.getInt("namSanXuat");
                
                int soluong = rs.getInt("soLuong");
                String xiLanh = rs.getString("dungTichXyLanh");
                String mauSac = rs.getString("mauSac");
                SanPham sp = new SanPham(maSP, tenXe, loaiXe, npp, gia, namSanXuat, soluong, xiLanh ,mauSac);

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
                String tenXe = rs.getString("tenXeMay");
                LoaiXe loaiXe = new LoaiXe(rs.getString("maLoai"));
                NhaPhanPhoi npp = new NhaPhanPhoi(rs.getString("maNhaPhanPhoi"));
                double gia = rs.getDouble("gia");
                int namSanXuat = rs.getInt("namSanXuat");
                
                int soluong = rs.getInt("soLuong");
                String xiLanh = rs.getString("dungTichXyLanh");
                String mauSac = rs.getString("mauSac");
                SanPham sp = new SanPham(maSP, tenXe, loaiXe, npp, gia, namSanXuat, soluong ,xiLanh ,mauSac);

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
                String tenXe = rs.getString("tenXeMay");
                LoaiXe loaiXe = new LoaiXe(rs.getString("maLoai"));
                NhaPhanPhoi npp = new NhaPhanPhoi(rs.getString("maNhaPhanPhoi"));
                double gia = rs.getDouble("gia");
                int namSanXuat = rs.getInt("namSanXuat");
                
                int soLuong = rs.getInt("soLuong");
                String xiLanh = rs.getString("dungTichXyLanh");
                String mauSac = rs.getString("mauSac");
                SanPham sp = new SanPham(maSP, tenXe, loaiXe, npp, gia, namSanXuat, soLuong,xiLanh ,mauSac);

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

    public void create(SanPham sp) throws SQLException {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("INSERT INTO SanPham VALUES (?,?,?,?,?,?,?,?,?)");
            statement.setString(1, sp.getMaSanPham());
            statement.setString(2, sp.getTenXe());
            statement.setString(3, sp.getMaLoai().getMaLoai());
            statement.setString(4, sp.getNhaPhanPhoi().getMaNhaPhanPhoi());
            statement.setDouble(5, sp.getGia());
            statement.setInt(6, sp.getNamSanXuat());
            statement.setInt(7, sp.getSoLuong());
            statement.setString(8, sp.getXiLanh());
            statement.setString(9, sp.getMauSac());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statement.close();
        }
    }   

    public void update(SanPham sp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "UPDATE SanPham SET maSanPham=?, tenXeMay=?, maLoai=?, maNhaPhanPhoi=?, gia=?, namSanXuat=?, soLuong=?, dungTichXyLanh=?, mauSac=? WHERE maSanPham=?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, sp.getMaSanPham());
            statement.setString(2, sp.getTenXe());
            statement.setString(3, sp.getMaLoai().getMaLoai());
            statement.setString(4, sp.getNhaPhanPhoi().getMaNhaPhanPhoi());
            statement.setDouble(5, sp.getGia());
            statement.setInt(6, sp.getNamSanXuat());
            statement.setInt(7, sp.getSoLuong());
            statement.setString(8, sp.getXiLanh());
            statement.setString(9, sp.getMauSac());
            statement.setString(10, sp.getMaSanPham()); // Set the parameter for WHERE clause
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(SanPham sp) throws SQLException {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from SanPham where maSanPham = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sp.getMaSanPham());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }
    }
    
}
