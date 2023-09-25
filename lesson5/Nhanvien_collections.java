package stt07_VuHoaBinh_JListDemo;

import java.io.Serializable;
import java.util.ArrayList;

public class Nhanvien_collections implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<NhanVien> dsNV;
	
	public Nhanvien_collections() {
		dsNV= new ArrayList<NhanVien>();
	}
	
	public boolean themNhanVien(NhanVien nv)
	{
		if(dsNV.contains(nv))
			return false ;
		dsNV.add(nv);
		return true;
	}
	public NhanVien getElement(int index) {
		if(index <0 || index>=dsNV.size()) {
			return null;
		}
		return dsNV.get(index);
	}
	public int getSize() {
		return dsNV.size();
	}
	public boolean xoaNhanVien(String maNV) {
		NhanVien nv = new NhanVien();
		if(dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
		return false;
	}
	public NhanVien timNhanVien(String id) {
        for (NhanVien nv : dsNV) {
            if (nv.getEmployeeID().equals(id)) {
                return nv;
            }
        }
        return null; 
    }
}
