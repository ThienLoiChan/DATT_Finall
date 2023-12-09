const host = "http://localhost:8080/rest";
const app = angular.module("AdminApp", []);
app.controller("AdminCtrl", function ($scope, $http) {
    $scope.listQua = [];
    $scope.srcImage = `http://localhost:8080/rest/files/images`;
    $scope.tenQua="";
    $scope.load_all = function () {
        const url = `${host}/Qua`;
        $http.get(url).then((resp) => {
            $scope.listQua = resp.data.reverse();
            console.log("Sucsess", resp.data);
            $scope.pageNumber = 1;
            $scope.limit = 8;
            $scope.totalPage = getTotalPage($scope.listQua, $scope.limit);
        })
    }
    $scope.search=(text)=>{
        $scope.tenQua=text;
        const url = `${host}/searchQua/${$scope.tenQua}`;
        $http.get(url).then((resp) => {
            $scope.listQua = resp.data;
            console.log("Sucsess", resp.data);
            $scope.pageNumber = 1;
            $scope.limit = 8;
            $scope.totalPage = getTotalPage($scope.listQua, $scope.limit);
        })
    }
    $scope.setLimit = (soSanPham) => {
        $scope.pageNumber = 1;
        $scope.limit = soSanPham;
        $scope.totalPage = getTotalPage($scope.listQua, $scope.limit);
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
  $scope.deletesanPham = (id) => {
    // Sử dụng SweetAlert thay thế cho window.confirm
    Swal.fire({
        title: "Xác Nhận Xóa?",
        text: "Bạn có chắc chắc muốn xóa sản phẩm này !!!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "A8A196",
        cancelButtonColor: "FF8F8F",
        confirmButtonText: "Xóa",
        cancelButtonText: "Hủy"
    }).then((result) => {
        // Nếu người dùng xác nhận xóa
        if (result.isConfirmed) {
            const urlsanPham = `${host}/Qua/${id}`;
            $http.delete(urlsanPham).then(resp => {
                Swal.fire({
                    title: "Xóa Thành Công",
                    text: "Bạn Đã Xóa Thành Công Sản Phẩm ",
                    icon: "success"
                }).then(() => {
                    // Sau khi xóa thành công, chuyển hướng hoặc thực hiện các bước khác
                   
                    location.replace("/admin/index");
                });
            }).catch(resp => {
                // Nếu không thể xóa (có đơn hàng sử dụng sản phẩm)
                Swal.fire({
                    title: "Lỗi!",
                    text: "Không Thể Xóa Sản Phẩm Này!",
                    icon: "error"
                });
            });
        }
    });
};

    $scope.load_all();
    $scope.detail = (id) => {
        location.replace("/admin/detail?idQua=" + id);
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