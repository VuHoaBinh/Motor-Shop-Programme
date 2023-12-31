/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import com.sun.source.tree.IfTree;
import connectDB.ConnectDB;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LoaiXe_DAO;
import dao.NhaPhanPhoi_DAO;
import dao.SanPham_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.SanPham;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class frmEmployeeHome extends javax.swing.JPanel {

    /**
     * Creates new form frmEmployeeHome
     */
    private SanPham_DAO sp_DAO;
    private NhaPhanPhoi_DAO npp_DAO;
    private LoaiXe_DAO lx_DAO;
    private KhachHang_DAO kh_DAO;
    private HoaDon_DAO hd_DAO;
    private Double sumMoney = 0.0;
    
    
    public frmEmployeeHome() {
        initComponents();
        LayNguonSP();
        txt_TienThoi.setEditable(false);
        txt_TongTien.setEditable(false);
        txt_maKH.setEditable(false);
        KhoaMo(false);
    }
    
    private void KhoaMo(boolean b) {
        txt_maKH.setEditable(b);
        txt_tenKH.setEditable(b);
        txt_sdtKH.setEditable(b);
        txt_diachiKH.setEditable(b);
        txt_TienKH.setEditable(b);

        btn_Huy.setEnabled(b);
        btn_XuatHoaDon.setEnabled(b);
        
        tbl_home2.setEnabled(!b);
    }
    private void LayNguonSP() {
        tbl_SanPham.removeAll();
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception e) {
                // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sp_DAO = new SanPham_DAO();
        List<SanPham> listSP  = sp_DAO.getAllTableSanPham();
        
        if (tbl_SanPham.getModel() == null) {
            String[] arr = {"Mã SP", "Tên SP", "Loại Xe", "Nhà cung cấp", "Giá Bán", "Năm sản xuất", "Số Lượng" ,"Xi lanh", "Màu Sắc"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            tbl_SanPham.setModel(model);
        }
        DefaultTableModel model = (DefaultTableModel) tbl_SanPham.getModel();
        model.setRowCount(0);
        for(SanPham sp: listSP) {
            model.addRow(new Object[] {sp.getMaSanPham(),
                sp.getTenXe(), sp.getMaLoai().getMaLoai(),
                sp.getNhaPhanPhoi().getMaNhaPhanPhoi(), sp.getGia(), sp.getNamSanXuat() , sp.getSoLuong(),
                sp.getXiLanh(),sp.getMauSac()});
        }
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_TimKiem = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SanPham = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_home2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_tenKH = new javax.swing.JTextField();
        txt_sdtKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_diachiKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_TongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_TienKH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_TienThoi = new javax.swing.JTextField();
        txt_maKH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_Huy = new javax.swing.JButton();
        btn_XuatHoaDon = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_ThanhToan = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setText("HOME");

        txt_TimKiem.setText("Search.........");
        txt_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TimKiemActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tbl_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Loại Xe", "Nhà cung cấp", "Giá Bán", "Năm sản xuất", "Số lượng", "Xi-lanh", "Màu sắc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_SanPham);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách giỏ hàng"));

        tbl_home2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Loại Xe", "Giá", "Số lượng", "Màu sắc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_home2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        jLabel1.setText("Họ tên khách hàng:");

        jLabel2.setText("Số điện thoại:");

        jLabel3.setText("Địa chỉ:");

        jLabel4.setText("Tổng số tiền:");

        jLabel5.setText("Tiền khách trả:");

        txt_TienKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TienKHActionPerformed(evt);
            }
        });

        jLabel6.setText("Tiền thối:");

        jLabel7.setText("Mã Khách Hàng:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_maKH)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sdtKH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_diachiKH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_TongTien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_TienKH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_TienThoi, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_diachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txt_TienKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_TienThoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_Huy.setText("HỦY BỎ");
        btn_Huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HuyMouseClicked(evt);
            }
        });

        btn_XuatHoaDon.setText("XUẤT ĐƠN");
        btn_XuatHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XuatHoaDonMouseClicked(evt);
            }
        });

        btn_Xoa.setText("XÓA");
        btn_Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMouseClicked(evt);
            }
        });
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_ThanhToan.setText("THANH TOÁN");
        btn_ThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThanhToanMouseClicked(evt);
            }
        });
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290)
                        .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_XuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Huy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_XuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 985, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 745, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TimKiemActionPerformed
        // TODO add your handling code here:
        try {
            ConnectDB.getInstance().connect();
            String timkiem = txt_TimKiem.getText();

            sp_DAO = new SanPham_DAO();
            ArrayList<SanPham> listSP = sp_DAO.getSanPhamTheoMa(timkiem);

            if (tbl_SanPham.getModel() == null) {
                String[] arr = {"Mã SP", "Tên SP", "Loại Xe", "Nhà cung cấp", "Giá Bán", "Năm sản xuất", "Số Lượng" ,"Xi lanh", "Màu Sắc"};
                DefaultTableModel model = new DefaultTableModel(arr, 0);
                tbl_SanPham.setModel(model);
            }
            DefaultTableModel model = (DefaultTableModel) tbl_SanPham.getModel();
            model.setRowCount(0);
            
            for(SanPham sp: listSP) {
                model.addRow(new Object[] {sp.getMaSanPham(),
                sp.getTenXe(), sp.getMaLoai().getMaLoai(),
                sp.getNhaPhanPhoi().getMaNhaPhanPhoi(), sp.getGia(), sp.getNamSanXuat() , sp.getSoLuong(),
                sp.getXiLanh(),sp.getMauSac()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txt_TimKiemActionPerformed

    private void tbl_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseClicked
        // TODO add your handling code here:
        int row = tbl_SanPham.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel modelHome2 = (DefaultTableModel) tbl_home2.getModel();
            Object[] rowData = new Object[6];
            rowData[0] = tbl_SanPham.getValueAt(row, 0);
            rowData[1] = tbl_SanPham.getValueAt(row, 1);
            rowData[2] = tbl_SanPham.getValueAt(row, 2);
            rowData[3] = tbl_SanPham.getValueAt(row, 4);
            rowData[4] = 1;  
            rowData[5] = tbl_SanPham.getValueAt(row, 8);

            modelHome2.addRow(rowData);
            
            double number = Double.parseDouble(tbl_SanPham.getValueAt(row, 4).toString());
            sumMoney += number;
            txt_TongTien.setText(String.valueOf(sumMoney));
        }
    }//GEN-LAST:event_tbl_SanPhamMouseClicked

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void btn_XoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMouseClicked
        // TODO add your handling code here:
        if (tbl_home2.getSelectedRow() >= 0) {
            int row = tbl_home2.getSelectedRow();
            try {
                DefaultTableModel model = (DefaultTableModel) tbl_home2.getModel();
                double number = Double.parseDouble(tbl_home2.getValueAt(row, 3).toString());
                sumMoney -= number;
                model.removeRow(row);
                txt_TongTien.setText(String.valueOf(sumMoney));
            } catch (Exception e1) {
                    JOptionPane.showMessageDialog(this, "Not delete");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để xóa.");
        }
    }//GEN-LAST:event_btn_XoaMouseClicked

    private void btn_ThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThanhToanMouseClicked
        // TODO add your handling code here:
        KhoaMo(true);
        
    }//GEN-LAST:event_btn_ThanhToanMouseClicked

    private void txt_TienKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TienKHActionPerformed
        // TODO add your handling code here:
        double money = Double.parseDouble(txt_TienKH.getText());
        double sum = money - sumMoney;
        txt_TienThoi.setText(String.valueOf(sum));
    }//GEN-LAST:event_txt_TienKHActionPerformed
    
    private List<Product> products = new ArrayList<>();

    String getMaKH() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    public class Info {
        private String maKH;
        private String hoTen;
        private String sdt;
        private String diaChi;
        private String Tien;
        // Constructor that takes parameters to initialize the values
        public Info() {
        }
        public Info(String maKH, String hoTen, String sdt, String diaChi, String tien) {
            this.maKH = maKH;
            this.hoTen = hoTen;
            this.sdt = sdt;
            this.diaChi = diaChi;
            this.Tien = tien;
        }

        public String getMaKH() {
            return maKH;
        }

        public void setMaKH(String maKH) {
                this.maKH = maKH;
        }


        public String getHoTen() {
                return hoTen;
        }

        public void setHoTen(String hoTen) {
            this.hoTen = hoTen;
        }

        public String getSdt() {
                return sdt;
        }

        public void setSdt(String sdt) {
            this.sdt = sdt;
        }

        public String getDiaChi() {
                return diaChi;
        }

        public void setDiaChi(String diaChi) {
            this.diaChi = diaChi;
        }

        public String getTien() {
                return Tien;
        }

        public void setTien(String Tien) {
            this.Tien = Tien;
        }
    }
    
    
    
    // bill
    public List<Product> getProductsList() {
        return products;
    }

    // Product class to represent a product with name and price
    public static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Getter methods for name and price
        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
    
    public void setProductsList(List<Product> newProducts) {
        this.products = newProducts;
    }

    private List<Product> getProductsList(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Product> products = new ArrayList<>();

        // Iterate through the rows of the table
        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = (String) model.getValueAt(i, 1);
            double productPrice = Double.parseDouble(model.getValueAt(i, 3).toString()); 

            // Create a new Product instance and add it to the list
            products.add(new Product(productName, productPrice));
        }

        return products;
    }
    
    
    public void addToHome2() {
        products = getProductsList(tbl_home2);
    }
    
    private void btn_XuatHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatHoaDonMouseClicked
        // TODO add your handling code here:
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        kh_DAO = new KhachHang_DAO();
        hd_DAO = new HoaDon_DAO();
        
        
        addToHome2();
        
        if(validation()==true){
            String ma = txt_maKH.getText();
            String ten = txt_tenKH.getText();

            String sdt = txt_sdtKH.getText();
            String diaChi = txt_diachiKH.getText();
            String tien = txt_TienKH.getText();
            Info customerInfo = new Info(ma,txt_tenKH.getText(),txt_sdtKH.getText(), txt_diachiKH.getText(),txt_TongTien.getText());
            
            KhachHang kh = new KhachHang(txt_maKH.getText(), txt_tenKH.getText(), txt_sdtKH.getText(),txt_diachiKH.getText());
            
//            HoaDon hd = new HoaDon("HD001", Double.parseDouble(txt_TongTien.getText()));
//            hd_DAO.create(hd);
            kh_DAO.create(kh);
            String successMessage = "Payment successful!\nThank you for your purchase.";

            JOptionPane.showMessageDialog(null, successMessage, "Payment Success", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_XuatHoaDonMouseClicked

    private void btn_HuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HuyMouseClicked
        // TODO add your handling code here:
        tbl_home2.removeAll();
        KhoaMo(false);
        xoatrang();
    }//GEN-LAST:event_btn_HuyMouseClicked
    private boolean validation(){
        if (txt_maKH.getText().isEmpty() && !txt_maKH.getText().matches("^KH\\d+$")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã Khách Hàng.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (txt_TienKH.getText().isEmpty() && Integer.parseInt(txt_TienKH.getText())<0 && Double.parseDouble(txt_TienKH.getText()) < Double.parseDouble(txt_TongTien.getText()) ) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhân viên.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    public void xoatrang() {
        txt_maKH.setText("");
        txt_TimKiem.setText("");
        txt_TienThoi.setText("");
        txt_TienKH.setText("");
        txt_diachiKH.setText("");
        txt_sdtKH.setText("");
        txt_tenKH.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Huy;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XuatHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_SanPham;
    private javax.swing.JTable tbl_home2;
    private javax.swing.JTextField txt_TienKH;
    private javax.swing.JTextField txt_TienThoi;
    private javax.swing.JTextField txt_TimKiem;
    private javax.swing.JTextField txt_TongTien;
    private javax.swing.JTextField txt_diachiKH;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_sdtKH;
    private javax.swing.JTextField txt_tenKH;
    // End of variables declaration//GEN-END:variables
}
