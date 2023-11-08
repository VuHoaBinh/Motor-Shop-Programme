package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;

public class PhongBan_DAO {
	public ArrayList<PhongBan> getAllTablePhongBan() {
		ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "Select * from PhongBan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPB = rs.getString("maPhongBan");
				String tenPB = rs.getString("tenPhongBan");
				PhongBan p = new PhongBan(maPB, tenPB);
				dsPhongBan.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhongBan;
	}
}
