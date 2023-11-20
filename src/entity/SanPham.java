package entity;

import java.util.Objects;

public class SanPham {
    private String maSanPham;
    private String tenXe;
    private LoaiXe maLoai;
    private NhaPhanPhoi npp;
    private double gia;
    private int namSanXuat;
    private int soLuong;
    private String xiLanh;
    private String mauSac;
    
        
	
	
    public SanPham() {
        super();
    }

    public SanPham(String maSanPham) {
        super();
        this.maSanPham = maSanPham;
    }
//String[] arr = {"Mã SP", "Tên SP", "Loại Xe", "Nhà CC", "Giá Bán", "Năm SX", "Số Lượng" ,"Xi lanh", "Màu Sắc"};
    public SanPham(String maSanPham, String tenXe, LoaiXe maLoai, NhaPhanPhoi npp, double gia, int namSanXuat,
                  int soLuong, String xiLanh, String mauSac ) {
        super();
        this.maSanPham = maSanPham;
        this.tenXe = tenXe;
        this.maLoai = maLoai;
        this.npp = npp;
        this.gia = gia;
        this.namSanXuat = namSanXuat;
        this.soLuong = soLuong;
        this.xiLanh = xiLanh;
        this.mauSac = mauSac;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public LoaiXe getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(LoaiXe maLoai) {
        this.maLoai = maLoai;
    }

    public NhaPhanPhoi getNhaPhanPhoi () {
        return npp;
    }

    public void setNhaPhanPhoi (NhaPhanPhoi npp) {
        this.npp = npp;
    }
    
    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getXiLanh() {
        return xiLanh;
    }

    public void setXiLanh(String xiLanh) {
        this.xiLanh = xiLanh;
    }
    
    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
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
        return "SanPham [maSanPham=" + maSanPham + ", tenXeMay=" + tenXe + ", loaiXe=" + maLoai + ", npp=" + npp
                + ", gia=" + gia + ", namSanXuat=" + namSanXuat + ", soLuong=" + soLuong + ", xiLanh=" + xiLanh + ", mauSac=" + mauSac + "]";
    }

}
