const host = "http://localhost:8080/rest";
const app = angular.module("OrderApp", []);
app.controller("OrderCtrl", function ($scope, $http) {
    $scope.srcImage = `http://localhost:8080/rest/files/images`;
    $scope.listHoaDon = [];
    $scope.load_all = function () {
        const url = `${host}/hoadon`;
        $http.get(url).then((resp) => {
            $scope.listHoaDon = resp.data;
            console.log("Sucsess", resp.data);
            $scope.pageNumber = 1;
            $scope.limit = 8;
            $scope.totalPage = getTotalPage($scope.listHoaDon, $scope.limit);
        })
    }
    $scope.setLimit = (soSanPham) => {
        $scope.pageNumber = 1;
        $scope.limit = soSanPham;
        $scope.totalPage = getTotalPage($scope.listHoaDon, $scope.limit);
    };
    $scope.setPageNumber = (pageNumber) => {
        $scope.pageNumber = pageNumber;
    };
    $scope.next = () => {
        if ($scope.pageNumber < $scope.totalPage) {
            $scope.pageNumber++;
        } else {
            $scope.pageNumber = 1;
        }
    };
    const getTotalPage = (arr, soSanPham) => {
        return Math.ceil(arr.length / soSanPham);
    };
    $scope.deleteDonhang = (id) => {
       
    // Sử dụng SweetAlert thay thế cho window.confirm
    Swal.fire({
        title: "Xác Nhận Xóa?",
        text: "Bạn Có Chắc Chắc Muốn Xóa Đơn Hàng Này !!!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "A8A196",
        cancelButtonColor: "FF8F8F",
        confirmButtonText: "Xóa",
        cancelButtonText: "Hủy"
    }).then((result) => {
        // Nếu người dùng xác nhận xóa
        if (result.isConfirmed) {
            const urldonHang = `${host}/hoadon/${id}`;
            $http.delete(urldonHang).then(resp => {
                Swal.fire({
                    title: "Xóa Thành Công",
                    text: "Bạn Đã Xóa Thành Công Đơn Hàng ",
                    icon: "success"
                }).then(() => {
                    // Sau khi xóa thành công, chuyển hướng hoặc thực hiện các bước khác
                   
                    location.replace("/admin/order");
                });
            }).catch(resp => {
                // Nếu không thể xóa (có đơn hàng sử dụng sản phẩm)
                Swal.fire({
                    title: "Lỗi!",
                    text: "Không Thể Xóa Đơn Hàng Này!",
                    icon: "error"
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
