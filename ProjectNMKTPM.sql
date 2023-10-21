create database ProjectNMKTPM

use ProjectNMKTPM

create table NhanVien(
	MaNV nvarchar(10) primary key not null,
	TenNV nvarchar(50) not null,
	MatKhau nvarchar(50) not null,
	DienThoai nvarchar(10) not null,
	Email nvarchar(100) not null,
	VaiTro nvarchar(50) not null,
	Hinh nvarchar(50) null
)




create table SanPham(
	MaSP nvarchar(10) primary key not null,
	MaNV nvarchar(10) not null,
	TenSP nvarchar(50) not null,
	TonKho int not null,
	NhaSX nvarchar(50) not null,
	NgaySX date not null,
	Gia float not null,
	Hinh nvarchar(50) null,
	foreign key (MaNV) references NhanVien(MaNV)
)


create table KhachHang(
	MaKH nvarchar(10) primary key not null,
	MaNV nvarchar(10) not null,
	TenKH nvarchar(50) not null,
	NgaySinh date not null,
	DienThoai nvarchar(10) not null,
	DiaChi nvarchar(100) not null,
	GioiTinh bit not null,
	Hinh nvarchar(50) null,
	foreign key (MaNV) references NhanVien(MaNV)
)


create table DonHang(
	MaDH nvarchar(10) primary key not null,
	MaSP nvarchar(10) not null,
	MaNV nvarchar(10) not null,
	MaKH nvarchar(10) not null,
	TenSP nvarchar(50) not null,
	DiaChiGiao nvarchar(100) not null,
	TenKH nvarchar(50) not null,
	TrangThai nvarchar(20) not null,
	TongTien money not null,
	foreign key (MaSP) references SanPham(MaSP),
	foreign key(MaNV) references NhanVien(MaNV),
	foreign key (MaKH) references KhachHang(MaKH)
)

create table DoanhThu(
	MaTK nvarchar(10) primary key not null,
	MaSP nvarchar(10) not null,
	MaDH nvarchar(10) not null,
	dateFrom date not null,
	dateTo date not null,
	TenSP nvarchar(50) not null,
	SoLuongBan int not null,
	ChenhLechSoLuong int not null,
	TonKho int not null,
	DoanhThu money not null,
	LoiNhuan float not null,
	foreign key (MaSP) references SanPham(MaSP),
	foreign key (MaDH) references DonHang(MaDH)
)



INSERT INTO NhanVien (MaNV, TenNV, MatKhau, DienThoai, Email, VaiTro, Hinh)
VALUES ('NV001', 'John Doe', 'password1', '0123456789', 'john.doe@example.com', 'QuanLy', 'john.jpg');

INSERT INTO NhanVien (MaNV, TenNV, MatKhau, DienThoai, Email, VaiTro, Hinh)
VALUES ('NV002', 'Jane Smith', 'password2', '0987654321', 'jane.smith@example.com', 'NhanVien', 'jane.jpg');

INSERT INTO NhanVien (MaNV, TenNV, MatKhau, DienThoai, Email, VaiTro, Hinh)
VALUES ('NV003', 'David Johnson', 'password3', '9876543210', 'david.johnson@example.com', 'NhanVien', 'david.jpg');


INSERT INTO SanPham (MaSP, MaNV, TenSP, TonKho, NhaSX, NgaySX, Gia, Hinh)
VALUES ('SP001', 'NV001', 'Product 1', 10, 'Manufacturer 1', '2022-01-01', 100.50, 'product1.jpg');

INSERT INTO SanPham (MaSP, MaNV, TenSP, TonKho, NhaSX, NgaySX, Gia, Hinh)
VALUES ('SP002', 'NV002', 'Product 2', 5, 'Manufacturer 2', '2022-02-01', 50.75, 'product2.jpg');

INSERT INTO SanPham (MaSP, MaNV, TenSP, TonKho, NhaSX, NgaySX, Gia, Hinh)
VALUES ('SP003', 'NV003', 'Product 3', 8, 'Manufacturer 3', '2022-03-01', 75.00, 'product3.jpg');


INSERT INTO KhachHang (MaKH, MaNV, TenKH, NgaySinh, DienThoai, DiaChi, GioiTinh, Hinh)
VALUES ('KH001', 'NV001', 'Customer 1', '1990-01-01', '0123456789', '123 Street, City', 1, 'customer1.jpg');

INSERT INTO KhachHang (MaKH, MaNV, TenKH, NgaySinh, DienThoai, DiaChi, GioiTinh, Hinh)
VALUES ('KH002', 'NV002', 'Customer 2', '1995-06-15', '0987654321', '456 Street, City', 0, 'customer2.jpg');

INSERT INTO KhachHang (MaKH, MaNV, TenKH, NgaySinh, DienThoai, DiaChi, GioiTinh, Hinh)
VALUES ('KH003', 'NV003', 'Customer 3', '1985-03-20', '0123456789', '789 Street, City', 1, 'customer3.jpg');


INSERT INTO DonHang (MaDH, MaSP, MaNV, MaKH, TenSP, DiaChiGiao, TenKH, TrangThai, TongTien)
VALUES ('DH001', 'SP001', 'NV001', 'KH001', 'Product 1', '123 Street, City', 'Customer 1', 'Pending', 100.50);

INSERT INTO DonHang (MaDH, MaSP, MaNV, MaKH, TenSP, DiaChiGiao, TenKH, TrangThai, TongTien)
VALUES ('DH002', 'SP002', 'NV002', 'KH002', 'Product 2', '456 Street, City', 'Customer 2', 'Completed', 50.75);

INSERT INTO DonHang (MaDH, MaSP, MaNV, MaKH, TenSP, DiaChiGiao, TenKH, TrangThai, TongTien)
VALUES ('DH003', 'SP003', 'NV003', 'KH003', 'Product 3', '789 Street, City', 'Customer 3', 'Pending', 75.00);


INSERT INTO DoanhThu (MaTK, MaSP, MaDH, dateFrom, dateTo, TenSP, SoLuongBan, ChenhLechSoLuong, TonKho, DoanhThu, LoiNhuan)
VALUES ('DT001', 'SP001', 'DH001', '2022-01-01', '2022-01-31', 'Product 1', 5, 0, 5, 50.25, 0.5);

INSERT INTO DoanhThu (MaTK, MaSP, MaDH, dateFrom, dateTo, TenSP, SoLuongBan, ChenhLechSoLuong, TonKho, DoanhThu, LoiNhuan)
VALUES ('DT002', 'SP002', 'DH002', '2022-02-01', '2022-02-28', 'Product 2', 2, 0, 3, 101.50, 0.75);




select * from DoanhThu