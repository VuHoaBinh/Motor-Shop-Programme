package dao;

import connectDB.ConnectDB;
import entity.LoaiXe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoaiXe_DAO {
    public ArrayList<LoaiXe> getAllTableLoaiXe() {
        ArrayList<LoaiXe> dsLoaiXe = new ArrayList<LoaiXe>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();

            String sql = "Select * from LoaiXe";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maLoai = rs.getString("maLoai");
                String tenLoai = rs.getString("tenLoai");
                LoaiXe l = new LoaiXe(maLoai, tenLoai);
                dsLoaiXe.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLoaiXe;
    }
}
