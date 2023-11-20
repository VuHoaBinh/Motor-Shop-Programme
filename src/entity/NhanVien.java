package entity;

import java.util.Objects;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private String sdt;
    private String diaChi;
    private String email;
    private boolean gioiTinh;
    private String chucVu;
    private int tuoi;
    private PhongBan maPhongBan;

    public NhanVien() {
            super();
    }

    public NhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public NhanVien(String maNhanVien, String hoTen, String sdt, String diaChi, String email, boolean gioiTinh,
                    String chucVu, int tuoi, PhongBan maPhongBan) {
            super();
            this.maNhanVien = maNhanVien;
            this.hoTen = hoTen;
            this.sdt = sdt;
            this.diaChi = diaChi;
            this.email = email;
            this.gioiTinh = gioiTinh;
            this.chucVu = chucVu;
            this.tuoi = tuoi;
            this.maPhongBan = maPhongBan;
    }

    public String getMaNhanVien() {
            return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
            this.maNhanVien = maNhanVien;
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

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public boolean getGioiTinh() {
            return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
            this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
            return chucVu;
    }

    public void setChucVu(String chucVu) {
            this.chucVu = chucVu;
    }

    public int getTuoi() {
            return tuoi;
    }

    public void setTuoi(int tuoi) {
            this.tuoi = tuoi;
    }

    public PhongBan getMaPhongBan() {
            return maPhongBan;
    }

    public void setMaPhongBan(PhongBan maPhong) {
            this.maPhongBan = maPhong;
    }
   @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                return true;
        if (obj == null)
                return false;
        if (getClass() != obj.getClass())
                return false;
        NhanVien other = (NhanVien) obj;
        if (maNhanVien == null) {
            if (other.maNhanVien != null)
                    return false;
        } else if (!maNhanVien.equals(other.maNhanVien))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", sdt=" + sdt + ", diaChi=" + diaChi
                + ", email=" + email + ", gioiTinh=" + gioiTinh + ", chucVu=" + chucVu + ", tuoi=" + tuoi
                + ", phong=" + maPhongBan + "]";
    }

}
