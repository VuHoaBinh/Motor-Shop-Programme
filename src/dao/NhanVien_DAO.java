package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;

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

//	public ArrayList<NhanVien> getNVTheoMa(String ma) {
//		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
//
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//
//			String sql = "Select * from nhanvien where maNV = ?";
//			statement = con.prepareStatement(sql);
//			statement.setString(1, ma);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				String maNV = rs.getString("maNV");
//				String ho = rs.getString("ho");
//				String ten = rs.getString("ten");
//				int tuoi = rs.getInt("tuoi");
//				boolean phai = rs.getBoolean("phai");
//				double tienLuong = rs.getDouble("tienLuong");
//				PhongBan p = new PhongBan(rs.getString("maPhong"));
//				NhanVien nv = new NhanVien(maNV, ho, ten, tuoi, phai, tienLuong, p);
//
//				dsNhanVien.add(nv);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		return dsNhanVien;
//	}
//
//	public ArrayList<NhanVien> getNVTheoMaPhongBan(String ma) {
//		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
//
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//
//			String sql = "Select * from nhanvien where maPhong = ?";
//			statement = con.prepareStatement(sql);
//			statement.setString(1, ma);
//			ResultSet rs = statement.executeQuery();
//			while (rs.next()) {
//				String maNV = rs.getString("maNV");
//				String ho = rs.getString("ho");
//				String ten = rs.getString("ten");
//				int tuoi = rs.getInt("tuoi");
//				boolean phai = rs.getBoolean("phai");
//				double tienLuong = rs.getFloat("tienLuong");
//				PhongBan p = new PhongBan(rs.getString("maPhong"));
//				NhanVien nv = new NhanVien(maNV, ho, ten, tuoi, phai, tienLuong, p);
//
//				dsNhanVien.add(nv);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		return dsNhanVien;
//	}
//
//	public boolean create(NhanVien nv) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		int n = 0;
//
//		try {
//			statement = con.prepareStatement("insert NhanVien values (?,?,?,?,?,?,?)");
//			statement.setString(1, nv.getMaNV());
//			statement.setString(2, nv.getHo());
//			statement.setString(3, nv.getTen());
//			statement.setInt(4, nv.getTuoi());
//			statement.setBoolean(5, nv.getPhai());
//			statement.setString(6, nv.getPhong().getMaPhong());
//			statement.setDouble(7, nv.getTienLuong());
//			n = statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return n > 0;
//	}
//
//	public boolean update(NhanVien nv) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement(
//					"update NhanVien set ho=?, ten=?" + "tuoi=?, phai=?,phongban=?, luong=?" + "where maNV=? ");
//			stmt.setString(1, nv.getHo());
//			stmt.setString(2, nv.getTen());
//			stmt.setInt(3, nv.getTuoi());
//			stmt.setBoolean(4, nv.getPhai());
//			stmt.setString(5, nv.getPhong().getMaPhong());
//			stmt.setDouble(6, nv.getTienLuong());
//			stmt.setString(7, nv.getMaNV());
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return n > 0;
//	}
//
//	public void delete(String maNV) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		String sql = "delete from NhanVien where maNV = ?";
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maNV);
//			stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
