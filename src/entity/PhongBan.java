package entity;

import java.util.Objects;

public class PhongBan {
    private String maPhongBan;
    private String tenPhongBan;

    public PhongBan() {
        super();
    }

    public PhongBan(String maPhongBan) {
        super();
        this.maPhongBan = maPhongBan;
    }

    public PhongBan(String maPhongBan, String tenPhongBan) {
        super();
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhongBan);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhongBan other = (PhongBan) obj;
        return Objects.equals(maPhongBan, other.maPhongBan);
    }

    @Override
    public String toString() {
        return "PhongBan [maPhongBan=" + maPhongBan + ", tenPhongBan=" + tenPhongBan + "]";
    }

}
