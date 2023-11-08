package entity;

import java.util.Objects;

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
    public int hashCode() {
        return Objects.hash(maLoai);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                return true;
        if (obj == null)
                return false;
        if (getClass() != obj.getClass())
                return false;
        LoaiXe other = (LoaiXe) obj;
        return Objects.equals(maLoai, other.maLoai);
    }
    
    @Override
    public String toString() {
        return "LoaiXe [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
    }

}
