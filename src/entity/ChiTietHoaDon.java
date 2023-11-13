package entity;

public class ChiTietHoaDon {
	private SanPham sanPham;
	private HoaDon hoaDon;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(SanPham sanPham, HoaDon hoaDon) {
		super();
		this.sanPham = sanPham;
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [sanPham=" + sanPham + ", hoaDon=" + hoaDon + "]";
	}

}
