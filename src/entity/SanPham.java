package entity;

import java.util.Objects;

public class SanPham {
    private String maSanPham;
    private XeMay xe;
    private double gia;
    private boolean tinhTrang;
    private int soLuong;
    private String moTa;
    private NhaPhanPhoi nhaPhanPhoi;

    public SanPham() {
        super();
    }

    public SanPham(String maSanPham) {
        super();
        this.maSanPham = maSanPham;
    }

    public SanPham(String maSanPham, XeMay xe, double gia, boolean tinhTrang, int soLuong, String moTa,
                   NhaPhanPhoi nhaPhanPhoi) {
        super();
        this.maSanPham = maSanPham;
        this.xe = xe;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.nhaPhanPhoi = nhaPhanPhoi;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public XeMay getXe() {
        return xe;
    }

    public void setXe(XeMay xe) {
        this.xe = xe;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public NhaPhanPhoi getNhaPhanPhoi() {
        return nhaPhanPhoi;
    }

    public void setNhaPhanPhoi(NhaPhanPhoi nhaPhanPhoi) {
        this.nhaPhanPhoi = nhaPhanPhoi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSanPham);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SanPham other = (SanPham) obj;
        return Objects.equals(maSanPham, other.maSanPham);
    }

    @Override
    public String toString() {
        return "SanPham [maSanPham=" + maSanPham + ", xe=" + xe + ", gia=" + gia + ", tinhTrang=" + tinhTrang
                + ", soLuong=" + soLuong + ", moTa=" + moTa + ", nhaPhanPhoi=" + nhaPhanPhoi + "]";
    }

}
