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

---- Thêm dữ liệu vào bảng PhongBan trước
--INSERT INTO PhongBan(maPhongBan, tenPhongBan) VALUES ('PBKT', N'Phòng Kỹ Thuật');
--INSERT INTO PhongBan(maPhongBan, tenPhongBan) VALUES ('PBNS', N'Phòng Nhân Sự');
--INSERT INTO PhongBan(maPhongBan, tenPhongBan) VALUES ('PBTC', N'Phòng Tài chính');

---- Sau đó, thêm dữ liệu vào bảng NhanVien
--INSERT INTO NhanVien(maNhanVien, hoTen, sdt, diaChi, email, gioiTinh, chucVu, tuoi, maPhongBan)
--VALUES ('NV01', N'Chí Phèo', '0909123541', N'Huế', 'chipheo@gmail.com', 0, N'Nhân viên bán hàng', 23, 'PBTC');


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

INSERT INTO SanPham (maSanPham, tenXeMay, maLoai, maNhaPhanPhoi, gia, namSanXuat, soLuong, dungTichXyLanh, mauSac)
VALUES ('SP001', 'Yamaha Exciter 150', 'XEGA', 'YAMAHA_VN', 45000000, 2023, 10, '>50cc', N'Đỏ');





