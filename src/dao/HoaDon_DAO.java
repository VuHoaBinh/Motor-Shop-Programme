package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

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
                String maHD = rs.getString("maHoaDon");
                Date ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
                int soLanTraGop = rs.getInt("soLanTraGop");
                double tienNhanVao = rs.getDouble("tienNhanVao");
                double tienThua = rs.getDouble("tienThua");
                NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
                KhachHang kh = new KhachHang(rs.getString("maKhachHang"));

                HoaDon hd = new HoaDon(maHD, ngayLapHoaDon, soLanTraGop, tienNhanVao, tienThua, nv, kh);

                dsHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    public ArrayList<HoaDon> getHoaDonTheoMa(String maHD) {
        ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();

        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "Select * from HoaDon where maHoaDon = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maHD);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                Date ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
                int soLanTraGop = rs.getInt("soLanTraGop");
                double tienNhanVao = rs.getDouble("tienNhanVao");
                double tienThua = rs.getDouble("tienThua");
                NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
                KhachHang kh = new KhachHang(rs.getString("maKhachHang"));

                HoaDon hd = new HoaDon(maHoaDon, ngayLapHoaDon, soLanTraGop, tienNhanVao, tienThua, nv, kh);

                dsHoaDon.add(hd);
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
        return dsHoaDon;
    }

    public boolean create(HoaDon hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;

        try {
            statement = con.prepareStatement("insert HoaDon values (?,?,?,?,?,?,?)");
            statement.setString(1, hd.getMaHoaDon());
            statement.setDate(2, hd.getNgayLapHoaDon());
            statement.setInt(3, hd.getSoLanTraGop());
            statement.setDouble(4, hd.getTienNhanVao());
            statement.setDouble(5, hd.getTienThua());
            statement.setString(6, hd.getNhanVien().getMaNhanVien());
            statement.setString(7, hd.getKhachHang().getMaKhachHang());
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

    public boolean update(HoaDon hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {
            statement = con.prepareStatement(
                    "update HoaDon set ngayLapHoaDon=?, soLanTraGop=?, tienNhanVao=?, tienThua=?,maNhanVien=?, maKhachHang=?" + "where maHoaDon=? ");
            statement.setDate(1, hd.getNgayLapHoaDon());
            statement.setInt(2, hd.getSoLanTraGop());
            statement.setDouble(3, hd.getTienNhanVao());
            statement.setDouble(4, hd.getTienThua());
            statement.setString(5, hd.getNhanVien().getMaNhanVien());
            statement.setString(6, hd.getKhachHang().getMaKhachHang());
            statement.setString(7, hd.getMaHoaDon());
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

    public void delete(String maHD) {
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
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
