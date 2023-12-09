const host = "http://localhost:8080/rest";
const app = angular.module("OrderApp", []);
app.controller("OrderCtrl", function ($scope, $http) {
    //Checklogin  
    let sessionLogin = sessionStorage.getItem("User");
    if (sessionLogin != null) {
        $scope.username = sessionLogin;
        $scope.login = true;
    } else {
        $scope.login = false;
        location.replace("/index");
    }
    $scope.logout = () => {
        sessionStorage.clear();
        location.replace("/index");
    };
    const getSoLuongGioHang = () => {
        const gioHang = JSON.parse(localStorage.getItem(sessionLogin));
        console.log("gioHang", gioHang)
        let soLuongGioHang = 0;
        if (gioHang != null) {
            soLuongGioHang = gioHang.reduce((accum, item) => accum + item.soLuong, 0)
        }
        return soLuongGioHang;
    };
    if (getSoLuongGioHang() == 0) {
        location.replace("/index");
    }
    $scope.srcImage = `http://localhost:8080/rest/files/images`;
    $scope.soLuongGioHang = getSoLuongGioHang();
    $scope.loadAll = () => {
        const id = $scope.username;
        const url = `${host}/khachhang/${id}`;
        $http.get(url).then((resp) => {
            $scope.khachHang = resp.data;
        })
    };
    $scope.listDonHang = JSON.parse(localStorage.getItem(sessionLogin));
    $scope.getTongTien = () => {
        let tongTien = 0;
        let dongia =0;
        $scope.listDonHang.forEach((item) => {
			dongia = item.Qua.donGia - (item.Qua.donGia * item.Qua.giamGia);
            tongTien += dongia * item.soLuong;
        });
        return tongTien ;
    };
    addDays = (date, days) => {
        var result = new Date(date);
        result.setDate(result.getDate() + days);
        return result;
    }
    $scope.ngayGiaoDuKien = addDays(new Date(), 3);
    
    
$scope.datHang = () => {
    const hoaDon = {};
    hoaDon.diaChi = $scope.khachHang.diaChi;
    hoaDon.tenNguoiNhan = $scope.khachHang.tenKhachHang;
    hoaDon.tongTien = $scope.getTongTien();
    hoaDon.ghiChuKhachHang = $scope.ghiChuKhachHang;
    hoaDon.ngayDatHang = new Date();
    hoaDon.trangThai = "Chưa giao";
    hoaDon.soDienThoai = $scope.khachHang.soDienThoai;
    hoaDon.khachHang = $scope.khachHang;
    const url = `${host}/hoadon`;
    $http.post(url, hoaDon).then((resp) => {
        const donHang = resp.data;
        $scope.listDonHang.forEach(item => {
            const chiTietHoaDon = {};
            const chiTietHoaDonPK = {};
            chiTietHoaDonPK.maDonHang = donHang.maDonHang;
            chiTietHoaDonPK.maQua = item.Qua.maQua;
            chiTietHoaDon.id = chiTietHoaDonPK;
            chiTietHoaDon.soLuong = item.soLuong;
            chiTietHoaDon.donGia = item.Qua.donGia;
            const urlChiTietHoaDon = `${host}/chitiethoadon`;
            $http.post(urlChiTietHoaDon, chiTietHoaDon).then((respchitiet) => {
                console.log("respchitiet", respchitiet);
            });
        });

        Swal.fire({
            icon: 'success',
            title: 'Đặt hàng thành công!',
            text: 'Bạn sẽ trở lại trang mua sắm',
        }).then(() => {
            localStorage.clear();
            location.replace("/index");
        });
    });
};

    
    
    
    
    $scope.loadAll();
});