const host = "http://localhost:8080/rest";
const app = angular.module("OrderApp", []);
app.controller("OrderCtrl", function ($scope, $http) {
    $scope.srcImage = `http://localhost:8080/rest/files/images`;
    $scope.listKhachHang = [];
    $scope.load_all = function () {
        const url = `${host}/khachhang`;
        $http.get(url).then((resp) => {
            $scope.listKhachHang = resp.data;
            console.log("Sucsess", resp.data);
            $scope.pageNumber = 1;
            $scope.limit = 8;
            $scope.totalPage = getTotalPage($scope.listKhachHang, $scope.limit);
        })
    }
    $scope.setLimit = (soSanPham) => {
        $scope.pageNumber = 1;
        $scope.limit = soSanPham;
        $scope.totalPage = getTotalPage($scope.listKhachHang, $scope.limit);
    };
    $scope.setPageNumber = (pageNumber) => {
        $scope.pageNumber = pageNumber;
    };
    const getTotalPage = (arr, soSanPham) => {
        return Math.ceil(arr.length / soSanPham);
    };
    
    
$scope.deleteKhachHang = (id) => {
    Swal.fire({
        title: 'Xác nhận xoá',
        text: `Bạn có chắc chắn muốn xoá khách hàng ${id}?`,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: 'A8A196',
        cancelButtonColor: 'FF8F8F',
        confirmButtonText: 'Xoá',
        cancelButtonText: 'Hủy',
    }).then((result) => {
        if (result.isConfirmed) {
            const urlKhachHang = `${host}/khachhang/${id}`;
            $http.delete(urlKhachHang).then(resp => {
                Swal.fire({
                    icon: 'success',
                    title: 'Xoá thành công!',
                }).then(() => {
                    location.replace("/admin/customer");
                });
            }).catch(resp => {
                Swal.fire({
                    icon: 'error',
                    title: 'Không thể xoá',
                    text: 'Không thể xoá do tồn tại đơn hàng sử dụng sản phẩm này!',
                });
            });
        }
    });
};

    $scope.load_all();
    $scope.detail = (id) => {
        location.replace("/admin/orderdetail?idHoaDon=" + id);
    }
});
app.filter('range', function () {
    return function (input, total) {
        total = parseInt(total);

        for (var i = 0; i < total; i++) {
            input.push(i);
        }

        return input;
    };
});