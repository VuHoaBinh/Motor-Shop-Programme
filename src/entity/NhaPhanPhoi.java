package entity;

public class NhaPhanPhoi {
    private String maNhaPhanPhoi;
    private String tenNhapPhanPhoi;
    private String sdt;
    private String diaChi;

    public NhaPhanPhoi() {
        super();
    }

    public NhaPhanPhoi(String maNhaPhanPhoi) {
        this.maNhaPhanPhoi = maNhaPhanPhoi;
    }

    public NhaPhanPhoi(String maNhaPhanPhoi, String tenNhapPhanPhoi, String sdt, String diaChi) {
        super();
        this.maNhaPhanPhoi = maNhaPhanPhoi;
        this.tenNhapPhanPhoi = tenNhapPhanPhoi;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getMaNhaPhanPhoi() {
        return maNhaPhanPhoi;
    }

    public void setMaNhaPhanPhoi(String maNhaPhanPhoi) {
        this.maNhaPhanPhoi = maNhaPhanPhoi;
    }

    public String getTenNhapPhanPhoi() {
        return tenNhapPhanPhoi;
    }

    public void setTenNhapPhanPhoi(String tenNhapPhanPhoi) {
        this.tenNhapPhanPhoi = tenNhapPhanPhoi;
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

    @Override
    public String toString() {
        return "NhaPhanPhoi [maNhaPhanPhoi=" + maNhaPhanPhoi + ", tenNhapPhanPhoi=" + tenNhapPhanPhoi + ", sdt=" + sdt
                + ", diaChi=" + diaChi + "]";
    }

}
