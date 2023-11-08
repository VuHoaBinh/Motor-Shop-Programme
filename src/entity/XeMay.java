package entity;

import java.util.Objects;

public class XeMay {
	private String maXeMay;
	private LoaiXe loaiXe;
	private String thuongHieu;
	private int tocDo;
	private String khoiLuong;
	private String kichThuoc;
	private double dungTichBinhXang;
	private double dungTichXyLanh;
	private String mauSac;

	public XeMay() {
		super();
	}

	public XeMay(String maXeMay) {
		super();
		this.maXeMay = maXeMay;
	}

	public XeMay(String maXeMay, LoaiXe loaiXe, String thuongHieu, int tocDo, String khoiLuong, String kichThuoc,
			double dungTichBinhXang, double dungTichXyLanh, String mauSac) {
		super();
		this.maXeMay = maXeMay;
		this.loaiXe = loaiXe;
		this.thuongHieu = thuongHieu;
		this.tocDo = tocDo;
		this.khoiLuong = khoiLuong;
		this.kichThuoc = kichThuoc;
		this.dungTichBinhXang = dungTichBinhXang;
		this.dungTichXyLanh = dungTichXyLanh;
		this.mauSac = mauSac;
	}

	public String getMaXeMay() {
		return maXeMay;
	}

	public void setMaXeMay(String maXeMay) {
		this.maXeMay = maXeMay;
	}

	public LoaiXe getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public int getTocDo() {
		return tocDo;
	}

	public void setTocDo(int tocDo) {
		this.tocDo = tocDo;
	}

	public String getKhoiLuong() {
		return khoiLuong;
	}

	public void setKhoiLuong(String khoiLuong) {
		this.khoiLuong = khoiLuong;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public double getDungTichBinhXang() {
		return dungTichBinhXang;
	}

	public void setDungTichBinhXang(double dungTichBinhXang) {
		this.dungTichBinhXang = dungTichBinhXang;
	}

	public double getDungTichXyLanh() {
		return dungTichXyLanh;
	}

	public void setDungTichXyLanh(double dungTichXyLanh) {
		this.dungTichXyLanh = dungTichXyLanh;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maXeMay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XeMay other = (XeMay) obj;
		return Objects.equals(maXeMay, other.maXeMay);
	}

	@Override
	public String toString() {
		return "XeMay [maXeMay=" + maXeMay + ", loaiXe=" + loaiXe + ", thuongHieu=" + thuongHieu + ", tocDo=" + tocDo
				+ ", khoiLuong=" + khoiLuong + ", kichThuoc=" + kichThuoc + ", dungTichBinhXang=" + dungTichBinhXang
				+ ", dungTichXyLanh=" + dungTichXyLanh + ", mauSac=" + mauSac + "]";
	}

}
