package entity;

import java.util.Objects;

public class HoaDon {
    private String maHoaDon;
    private double giaSP;
    private SanPham maSanPham;


    public HoaDon(String maHoaDon) {
        super();
        this.maHoaDon = maHoaDon;
        this.giaSP = giaSP;
    }

    public HoaDon(String maHoaDon, double giaSP
               ,SanPham maSanPham) {
        super();
        this.maHoaDon = maHoaDon;
        this.giaSP = giaSP;
        this.maSanPham = maSanPham;
    }

    public String getMaHoaDon() {
            return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
            this.maHoaDon = maHoaDon;
    }

    public SanPham getSanPham() {
            return maSanPham;
    }

    public void setSanPham(SanPham maSanPham) {
            this.maSanPham = maSanPham;
    }
    
    public double getGiaSP() {
            return giaSP;
    }

    public void setGiaSP(double giaSP) {
            this.giaSP = giaSP;
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
            return "HoaDon [maHoaDon=" + maHoaDon + ", soLanTraGop="+", sanpham=" + maSanPham + "]";
    }
}
