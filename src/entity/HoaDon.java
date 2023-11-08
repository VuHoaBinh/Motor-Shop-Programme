package entity;

import java.sql.Date;
import java.util.Objects;

public class HoaDon {
    private String maHoaDon;
    private Date ngayLapHoaDon;
    private int soLanTraGop;
    private double tienNhanVao;
    private double tienThua;
    private NhanVien nhanVien;
    private KhachHang khachHang;

    public HoaDon() {
            super();
    }

    public HoaDon(String maHoaDon) {
            super();
            this.maHoaDon = maHoaDon;
    }

    public HoaDon(String maHoaDon, Date ngayLapHoaDon, int soLanTraGop, double tienNhanVao, double tienThua,
                    NhanVien nhanVien, KhachHang khachHang) {
            super();
            this.maHoaDon = maHoaDon;
            this.ngayLapHoaDon = ngayLapHoaDon;
            this.soLanTraGop = soLanTraGop;
            this.tienNhanVao = tienNhanVao;
            this.tienThua = tienThua;
            this.nhanVien = nhanVien;
            this.khachHang = khachHang;
    }

    public String getMaHoaDon() {
            return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
            this.maHoaDon = maHoaDon;
    }

    public Date getNgayLapHoaDon() {
            return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
            this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public int getSoLanTraGop() {
            return soLanTraGop;
    }

    public void setSoLanTraGop(int soLanTraGop) {
            this.soLanTraGop = soLanTraGop;
    }

    public double getTienNhanVao() {
            return tienNhanVao;
    }

    public void setTienNhanVao(double tienNhanVao) {
            this.tienNhanVao = tienNhanVao;
    }

    public double getTienThua() {
            return tienThua;
    }

    public void setTienThua(double tienThua) {
            this.tienThua = tienThua;
    }

    public NhanVien getNhanVien() {
            return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
            this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
            return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
            this.khachHang = khachHang;
    }
    @Override
    public int hashCode() {
            return Objects.hash(maHoaDon);
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            HoaDon other = (HoaDon) obj;
            return Objects.equals(maHoaDon, other.maHoaDon);
    }
    @Override
    public String toString() {
            return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", soLanTraGop=" + soLanTraGop
                            + ", tienNhanVao=" + tienNhanVao + ", tienThua=" + tienThua + ", nhanVien=" + nhanVien + ", khachHang="
                            + khachHang + "]";
    }
}
