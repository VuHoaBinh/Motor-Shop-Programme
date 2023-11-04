use QLXeMay	
go

/* Login */
create table NguoiDung( maNguoiDung nvarchar(10)
						, tenDangNhap nvarchar(30)
						 ,matKhau nvarchar(30)
						 , vaiTro nvarchar(30)
						 , primary key (maNguoiDung)
						)
go
insert into NguoiDung values ('AD01','admin','123456','NhanVien')

create table KhachHang( maKhachHang varchar(10)
						, hoTen nvarchar(30)
						 , sdt varchar(30)
						 , diaChi nvarchar(30)
						 , email varchar(100)
						 , gioiTinh bit
						 , primary key (maKhachHang)
						)
go

create table PhongBan( maPhongBan varchar(10)
						,tenPhongBan nvarchar(30)
						 ,primary key (maPhongBan)
						)
go

create table NhanVien( maNhanVien varchar(10)
						, hoTen nvarchar(30)
						 , sdt varchar(10)
						 , diaChi nvarchar(30)
						 , email varchar(30)
						 , gioiTinh bit
						 , chucVu varchar(20)
						 , tuoi int
						 , trangThai bit
						 ,primary key (maNhanVien)
						 ,maPhongBan varchar(10) foreign key REFERENCES  PhongBan(maPhongBan))
go

create table HoaDon ( maHoaDon varchar(10)
					  , ngayLapHoaDon date
					  , soLanTraGop int
					  , tienNhanVao float
					  , tienThua float
					  , primary  key (maHoaDon) 
					  , maNhanVien varchar(10) foreign key REFERENCES  NhanVien(maNhanVien)
					  , maKhachHang varchar(10) foreign key REFERENCES  KhachHang(maKhachHang))
go

create table LoaiXe (
						 maLoai varchar(10),
						 tenLoai nvarchar(30),
						 primary key (maLoai))
go

create table XeMay( maXeMay varchar(10)
						, thuongHieu nvarchar(30)
						 , tocDo int
						 , khoiLuong nvarchar(30)
						 , kichThuoc nvarchar(30)
						 , dungTichBinhXang float 
						 , dungTichXyLanh float   
						 , mauSac nvarchar(30)            
						 ,primary key (maXeMay)
						 ,loaiXe varchar(10) foreign key REFERENCES  LoaiXe(maLoai))
go
 
create table NhaPhanPhoi (
						maNhaPhanPhoi varchar(10)
						 , tenNhaPhanPhoi nvarchar(30)
						 , sdt nvarchar(10)
						 , email varchar(30)
						 , diaChi nvarchar(100)
						 primary key (maNhaPhanPhoi))
go

create table SanPham (maSanPham varchar(10)
						 , tenSanPham nvarchar(30)
						 , gia float
						 , tinhTrang bit
						 , soLuong int
						 , moTa nvarchar(100)
						, maNhaPhanPhoi varchar(10) foreign key REFERENCES  NhaPhanPhoi(maNhaPhanPhoi)
						 primary key (maSanPham))
go


insert into LoaiXe values ('XEGA',N'Xe tay ga');
insert into LoaiXe values ('XESO',N'Xe số');
insert into LoaiXe values ('XEGON',N'Xe tay gôn');


insert into PhongBan values ('PBKT',N'Phòng Kỹ Thuật');
insert into PhongBan values ('PBNS',N'Phòng Nhân Sự');
insert into PhongBan values ('PBTC',N'Phòng Tài chính');


