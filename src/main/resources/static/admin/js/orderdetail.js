const host = "http://localhost:8080/rest";
const app = angular.module("OrderDetailApp", []);
app.controller("OrderDetailCtrl", function ($scope, $http) {
    $scope.srcImage = `http://localhost:8080/rest/files/images`;
     //Lấy URL hiện tại
     const urlCurrent = new URL(location.href);
     // Lấy param
     const idHoaDon = urlCurrent.searchParams.get("idHoaDon");
    $scope.load_all = function () {
        const urlHoaDon = `${host}/hoadon/${idHoaDon}`;
        $http.get(urlHoaDon).then((resp) => {
            $scope.donHang=resp.data;
            console.log("Sucsess", resp.data);
        });
        const urlHoaDonChiTiet = `${host}/chitiethoadon/${idHoaDon}`;
        $http.get(urlHoaDonChiTiet).then((resp) => {
            $scope.listChiTietHoaDon=resp.data;
            console.log("Sucsess", resp.data);
        });

    }

 $scope.saveOrderDetail = function (donHang) {
    const idHoaDon = urlCurrent.searchParams.get("idHoaDon");
    const url = `${host}/hoadon/${idHoaDon}`;
    
    $http.put(url, donHang).then(resp => {
        // Thay thế alert bằng Swal.fire
        Swal.fire({
            title: "Thành Công !",
            text: "Sửa Đơn Hàng Thành Công",
            icon: "success"
        }).then(() => {
            console.log("success", resp.data);
        });
    }).catch(error => {
        console.error(error);
        
        // Hiển thị SweetAlert khi có lỗi
        Swal.fire({
            title: "Lỗi!",
            text: "Không Thể Sửa Đơn Hàng !",
            icon: "error"
        });
    });
};

    $scope.load_all();
    
});