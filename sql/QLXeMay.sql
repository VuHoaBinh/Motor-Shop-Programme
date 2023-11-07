create database QLXeMay
go

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

--Entity
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
						 , chucVu nvarchar(20)
						 , tuoi int
						 , tienLuong float
						 ,maPhong varchar(10) foreign key REFERENCES  PhongBan(maPhongBan)
						 ,primary key (maNhanVien))
go

create table HoaDon ( maHoaDon varchar(10)
					  , ngayLapHoaDon date
					  , soLanTraGop int
					  , tienNhanVao float
					  , tienThua float
					  , maNhanVien varchar(10) foreign key REFERENCES  NhanVien(maNhanVien)
					  , maKhachHang varchar(10) foreign key REFERENCES  KhachHang(maKhachHang)
					  , primary  key (maHoaDon))
go

create table LoaiXe ( maLoai varchar(10),
					tenLoai nvarchar(30),
					primary key (maLoai))
go

create table XeMay( maXeMay varchar(10)
						 ,loaiXe varchar(10) foreign key REFERENCES  LoaiXe(maLoai)
						, thuongHieu nvarchar(30)
						 , tocDo int
						 , khoiLuong nvarchar(30)
						 , kichThuoc nvarchar(30)
						 , dungTichBinhXang float 
						 , dungTichXyLanh float   
						 , mauSac nvarchar(30)            
						 ,primary key (maXeMay))
go
 
create table NhaPhanPhoi (
						maNhaPhanPhoi varchar(10)
						 , tenNhaPhanPhoi nvarchar(30)
						 , sdt nvarchar(10)
						 , diaChi nvarchar(100)
						 primary key (maNhaPhanPhoi))
go

create table SanPham (maSanPham varchar(10)
						 , maXe varchar(10) foreign key REFERENCES  XeMay(maXeMay)
						 , gia float
						 , tinhTrang bit
						 , soLuong int
						 , moTa nvarchar(100)
						, maNhaPhanPhoi varchar(10) foreign key REFERENCES  NhaPhanPhoi(maNhaPhanPhoi)
						 primary key (maSanPham))
go

create table ChiTietHoaDon ( maSanPham varchar(10) foreign key REFERENCES  SanPham(maSanPham)
							, maHoaDon varchar(10) foreign key REFERENCES  HoaDon(maHoaDon)
						 ,primary key (maSanPham, maHoaDon))
go

insert into LoaiXe values ('XEGA',N'Xe tay ga');
insert into LoaiXe values ('XESO',N'Xe số');
insert into LoaiXe values ('XEGON',N'Xe tay gôn');


insert into PhongBan values ('PBKT',N'Phòng Kỹ Thuật');
insert into PhongBan values ('PBNS',N'Phòng Nhân Sự');
insert into PhongBan values ('PBTC',N'Phòng Tài chính');


insert into KhachHang values ('KH01',N'Nguyễn Phan Anh Tuấn', '0909123445', N'HCM', 'anhtuan@gmail.com', 0);

insert into NhanVien values ('NV01',N'Chí Phèo', '0909123541', N'Huế', 'chipheo@gmail.com', 0, N'Nhân viên bán hàng', 23, 15000000, 'PBTC');

