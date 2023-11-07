package entity;

public class LoaiXe {
    private String maLoai;
    private String tenLoai;

    public LoaiXe(String maLoai) {
        this.maLoai = maLoai;
    }

    public LoaiXe(String maLoai, String tenLoai) {
        super();
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public LoaiXe() {
        super();
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiXe [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
    }

}
