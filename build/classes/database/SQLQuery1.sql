﻿create database QLXeMay
go
use QLXeMay
go
CREATE TABLE PhongBan (
    maPhongBan VARCHAR(30) PRIMARY KEY,
    tenPhongBan VARCHAR(50)
);
go

CREATE TABLE NhanVien (
    maNhanVien VARCHAR(30) PRIMARY KEY,
    hoTen VARCHAR(30),
    sdt VARCHAR(30),
    diaChi NVARCHAR(30),
    email VARCHAR(30),
    gioiTinh BIT,
    chucVu VARCHAR(30),
    tuoi INT,
    maPhongBan VARCHAR(30) FOREIGN KEY REFERENCES PhongBan(maPhongBan)
);
go

-- Thêm dữ liệu vào bảng PhongBan trước
INSERT INTO PhongBan(maPhongBan, tenPhongBan) VALUES ('PBKT', N'Phòng Kỹ Thuật');
INSERT INTO PhongBan(maPhongBan, tenPhongBan) VALUES ('PBNS', N'Phòng Nhân Sự');
INSERT INTO PhongBan(maPhongBan, tenPhongBan) VALUES ('PBTC', N'Phòng Tài chính');
INSERT INTO PhongBan(maPhongBan, tenPhongBan) VALUES('PBNS', N'Phòng Nhân Sự');
INSERT INTO PhongBan(maPhongBan, tenPhongBan) VALUES('PBMK', N'Phòng Marketing');
INSERT INTO PhongBan(maPhongBan, tenPhongBan) VALUES('PBQL', N'Phòng Quản lý');


-- Sau đó, thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan)
VALUES ('NV01', N'Chí Phèo', '0909123541', N'Huế', 'chipheo@gmail.com', 0, N'Nhân viên bán hàng', 23, 'PBTC');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES ('NV02', N'Ma Xôi', '0918234567', N'Hà Nội', 'maxoi@gmail.com', 1, N'Nhân viên kỹ thuật', 28, 'PBKT');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES ('NV03', N'Vàng Anh', '0987654321', N'Hồ Chí Minh', 'vanganh@gmail.com', 0, N'Nhân viên marketing', 25, 'PBMK');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES ('NV04', N'Thị Nở', '0978123456', N'Đà Nẵng', 'thinogmail.com', 1, N'Nhân viên kế toán', 30, 'PBKT');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES ('NV05', N'Lan Nhi', '0912345678', N'Hải Phòng', 'lannhi@gmail.com', 0, N'Nhân viên quản lý', 35, 'PBQL');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV07', N'Tâm Lý', '0988888888', N'Hải Dương', 'tamly@gmail.com', 0, N'Nhân viên marketing', 32, 'PBMK');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV08', N'Thành Công', '0966666666', N'Bắc Ninh', 'thanhcong@gmail.com', 1, N'Nhân viên quản lý', 38, 'PBQL');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV09', N'Hương Thảo', '0933333333', N'Quảng Ninh', 'huongthao@gmail.com', 0, N'Nhân viên bán hàng', 29, 'PBBH');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV11', N'Quỳnh Anh', '0944444444', N'Ninh Bình', 'quynhanh@gmail.com', 0, N'Nhân viên kỹ thuật', 26, 'PBKT');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV12', N'Thị Thơ', '0955555555', N'Thái Nguyên', 'thitho@gmail.com', 1, N'Nhân viên quản lý', 33, 'PBQL');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV13', N'Hoàng Sơn', '0916666666', N'Bắc Giang', 'hoangson@gmail.com', 0, N'Nhân viên bán hàng', 34, 'PBBH');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV14', N'Minh Hòa', '0901111222', N'Nam Định', 'minhhoa@gmail.com', 1, N'Nhân viên marketing', 28, 'PBMK');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV16', N'Tuấn Kiệt', '0961234567', N'Thanh Hóa', 'tuankiet@gmail.com', 1, N'Nhân viên quản lý', 29, 'PBQL');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV17', N'Thị Hoa', '0945678901', N'Vĩnh Phúc', 'thihoa@gmail.com', 0, N'Nhân viên bán hàng', 31, 'PBBH');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV18', N'Quang Linh', '0938765432', N'Bình Dương', 'quanglinh@gmail.com', 1, N'Nhân viên kỹ thuật', 27, 'PBKT');
INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan) 
VALUES('NV19', N'Phương Anh', '0923456789', N'Long An', 'phuonganh@gmail.com', 0, N'Nhân viên marketing', 30, 'PBMK');

go
-- Bảng LoaiXe
CREATE TABLE LoaiXe (
    maLoai VARCHAR(30) PRIMARY KEY,
    tenLoai NVARCHAR(30)
);


-- Bảng NhaPhanPhoi
CREATE TABLE NhaPhanPhoi (
    maNhaPhanPhoi VARCHAR(30) PRIMARY KEY,
    tenNhaPhanPhoi NVARCHAR(30),
    sdt NVARCHAR(30),
    diaChi NVARCHAR(100)
);


-- Bảng SanPham
CREATE TABLE SanPham (
    maSanPham VARCHAR(30) PRIMARY KEY,
    tenXeMay VARCHAR(30),
    maLoai VARCHAR(30) FOREIGN KEY REFERENCES LoaiXe(maLoai),
    maNhaPhanPhoi VARCHAR(30) FOREIGN KEY REFERENCES NhaPhanPhoi(maNhaPhanPhoi),
    gia FLOAT,
    namSanXuat INT,
    soLuong INT,
    dungTichXyLanh VARCHAR(30),
    mauSac NVARCHAR(30),
);



INSERT INTO LoaiXe(maLoai, tenLoai) VALUES ('XEGA',N'Xe tay ga');
INSERT INTO LoaiXe(maLoai, tenLoai) VALUES ('XEGON',N'Xe tay gôn');
INSERT INTO LoaiXe(maLoai, tenLoai) VALUES ('XESO',N'Xe số');


INSERT INTO NhaPhanPhoi(maNhaPhanPhoi, tenNhaPhanPhoi, sdt, diaChi)
VALUES ('YAMAHA_VN',N'Yamaha Motor Việt Nam', '0911112222', N'HCM');
INSERT INTO NhaPhanPhoi(maNhaPhanPhoi, tenNhaPhanPhoi, sdt, diaChi)
VALUES ('HONDA_VN',N'Honda Motor Việt Nam', '0933334444', N'HN');
INSERT INTO NhaPhanPhoi (maNhaPhanPhoi, tenNhaPhanPhoi, sdt, diaChi)
VALUES ('SUZUKI_VN', N'Suzuki Motor Việt Nam', '0988887777', 'Hà Nội');
INSERT INTO NhaPhanPhoi(maNhaPhanPhoi, tenNhaPhanPhoi, sdt, diaChi) 
VALUES ('KAWASAKI_VN', N'Kawasaki Motor Việt Nam', '0900001111', N'Đà Nẵng');
INSERT INTO NhaPhanPhoi(maNhaPhanPhoi, tenNhaPhanPhoi, sdt, diaChi) 
VALUES ('DUCATI_VN', N'Ducati Việt Nam', '0977778888', N'Hồ Chí Minh');
INSERT INTO NhaPhanPhoi(maNhaPhanPhoi, tenNhaPhanPhoi, sdt, diaChi) 
VALUES ('BMW_VN', N'BMW Motorrad Việt Nam', '0944445555', N'Hải Phòng');


INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac)
VALUES ('SP001', 'Yamaha Exciter 150', 'XEGA', 'YAMAHA_VN', 45000000, 2023, 10, '>50cc', N'Đỏ');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP002', 'Honda Winner X', 'XEGON', 'HONDA_VN', 42000000, 2023, 15, '>50cc', N'Đen');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP003', 'Suzuki Raider', 'XESO', 'SUZUKI_VN', 38000000, 2023, 20, '>50cc', N'Trắng');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP004', 'Yamaha Grande', 'XEGA', 'YAMAHA_VN', 40000000, 2023, 12, '>50cc', N'Xanh Dương');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP005', 'Honda Blade', 'XEGON', 'HONDA_VN', 35000000, 2023, 18, '>50cc', N'Đen Xám');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP006', 'Suzuki Satria F150', 'XESO', 'SUZUKI_VN', 39000000, 2023, 22, '>50cc', N'Đỏ Đen');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP007', 'Yamaha NVX 155', 'XEGA', 'YAMAHA_VN', 48000000, 2023, 8, '>50cc', N'Đen Nhám');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP008', 'Honda SH 150i', 'XEGON', 'HONDA_VN', 55000000, 2023, 14, '>50cc', N'Nâu Đỏ');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP009', 'Suzuki Burgman', 'XESO', 'SUZUKI_VN', 52000000, 2023, 10, '>50cc', N'Xanh Dương');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP010', 'Yamaha MT-15', 'XEGA', 'YAMAHA_VN', 47000000, 2023, 16, '>50cc', N'Đen Xám');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP011', 'Honda CBR150R', 'XEGON', 'HONDA_VN', 54000000, 2023, 13, '>50cc', N'Đỏ Trắng');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP012', 'Suzuki GSX-R150', 'XESO', 'SUZUKI_VN', 51000000, 2023, 9, '>50cc', N'Xanh Đen');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP013', 'Yamaha Exciter 135', 'XEGA', 'YAMAHA_VN', 35000000, 2023, 20, '>50cc', N'Xanh Nhám');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP014', 'Honda Air Blade 125', 'XEGON', 'HONDA_VN', 32000000, 2023, 25, '>50cc', N'Xám Đen');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP015', 'Suzuki Address', 'XESO', 'SUZUKI_VN', 34000000, 2023, 30, '>50cc', N'Nâu Đen');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP016', 'Yamaha Latte', 'XEGA', 'YAMAHA_VN', 30000000, 2023, 28, '>50cc', N'Vàng Đen');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP017', 'Honda Vision', 'XEGON', 'HONDA_VN', 31000000, 2023, 32, '>50cc', N'Đen Xanh');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP018', 'Suzuki Viva 115 Fi', 'XESO', 'SUZUKI_VN', 33000000, 2023, 26, '>50cc', N'Đỏ Trắng');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP019', 'Yamaha Sirius', 'XEGA', 'YAMAHA_VN', 29000000, 2023, 24, '>50cc', N'Xanh Trắng');
INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac) 
VALUES ('SP020', 'Honda Lead 125', 'XEGON', 'HONDA_VN', 36000000, 2023, 22, '>50cc', N'Tím Đen');



go
CREATE TABLE KhachHang(
    maKhachHang VARCHAR(10) PRIMARY KEY,
    hoTen NVARCHAR(30),
    sdt VARCHAR(30),
    diaChi NVARCHAR(30)
);
go

INSERT INTO KhachHang (maKhachHang, hoTen, sdt, diaChi)
VALUES 
    ('KH001', N'Nguyễn Thị Anh', '0987654321', N'456 Đường X, Quận Y, TP.Z'),
    ('KH002', N'Trần Văn Bình', '0901122334', N'789 Đường M, Quận N, TP.P'),
    ('KH003', N'Lê Thị Cường', '0978123456', N'123 Đường A, Quận B, TP.C'),
    ('KH007', N'Nguyễn Văn Hoàng', '0987654321', N'456 Đường X, Quận Y, TP.Z'),
    ('KH008', N'Trần Thị Lan', '0901122334', N'789 Đường M, Quận N, TP.P'),
    ('KH009', N'Lê Văn Minh', '0978123456', N'123 Đường A, Quận B, TP.C');

go
CREATE TABLE HoaDon (
    maHoaDon VARCHAR(30) PRIMARY KEY,
    giaSP FLOAT,
	maSanPham VARCHAR(30) REFERENCES SanPham(maSanPham)
);
go
CREATE TABLE ChiTietHoaDon (
    maSanPham VARCHAR(30) REFERENCES SanPham(maSanPham),
    maHoaDon VARCHAR(30) REFERENCES HoaDon(maHoaDon),
	maNhanVien VARCHAR(30) REFERENCES NhanVien(maNhanVien),
    PRIMARY KEY (maSanPham, maHoaDon)
);

INSERT INTO HoaDon (maHoaDon, giaSP, maSanPham)
VALUES ('HD001', 1500.00,'SP001'),
	('HD002', 1800.00, 'SP002'),
    ('HD003', 1600.00, 'SP003'),
    ('HD004', 1750.00, 'SP004'),
    ('HD005', 1900.00, 'SP005'),
    ('HD006', 2000.00, 'SP006'),
    ('HD007', 2200.00, 'SP007'),
    ('HD008', 2400.00, 'SP008'),
    ('HD009', 2100.00, 'SP009'),
    ('HD010', 1950.00, 'SP010');
    
	
-- Chèn dữ liệu vào bảng ChiTietHoaDon
INSERT INTO ChiTietHoaDon (maSanPham, maHoaDon,maNhanVien)
VALUES ('SP001', 'HD001','NV01'),
    ('SP002', 'HD002', 'NV02'),
    ('SP003', 'HD003', 'NV03'),
    ('SP004', 'HD004', 'NV04'),
    ('SP005', 'HD005', 'NV05'),
    ('SP006', 'HD006', 'NV06'),
    ('SP007', 'HD007', 'NV07'),
    ('SP008', 'HD008', 'NV08'),
    ('SP009', 'HD009', 'NV09'),
    ('SP010', 'HD010', 'NV10');

