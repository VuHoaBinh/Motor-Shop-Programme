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
}
