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
	private double tienLuong;
	private PhongBan phong;

	public NhanVien() {
		super();
	}

	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	public NhanVien(String maNhanVien, String hoTen, String sdt, String diaChi, String email, boolean gioiTinh,
			String chucVu, int tuoi, double tienLuong, PhongBan phong) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
		this.phong = phong;
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

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}

	public PhongBan getPhong() {
		return phong;
	}

	public void setPhong(PhongBan phong) {
		this.phong = phong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
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
		return Objects.equals(maNhanVien, other.maNhanVien);
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", sdt=" + sdt + ", diaChi=" + diaChi
				+ ", email=" + email + ", gioiTinh=" + gioiTinh + ", chucVu=" + chucVu + ", tuoi=" + tuoi
				+ ", tienLuong=" + tienLuong + ", phong=" + phong + "]";
	}

}
