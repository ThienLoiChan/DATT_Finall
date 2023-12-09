const host = "http://localhost:8080/rest/loaiQua";
const app = angular.module("CategoryApp", []);
app.controller("CategoryCtrl", function ($scope, $http) {
    $scope.listDanhMuc = [];
    $scope.load_all = function () {
        const url = `${host}`;
        $http.get(url).then((resp) => {
            $scope.listDanhMuc = resp.data;
            console.log("Sucsess", resp.data);
            $scope.pageNumber = 1;
            $scope.limit = 8;
            $scope.totalPage = getTotalPage($scope.listDanhMuc, $scope.limit);
        })
    }
    $scope.setLimit = (soSanPham) => {
        $scope.pageNumber = 1;
        $scope.limit = soSanPham;
        $scope.totalPage = getTotalPage($scope.listDanhMuc, $scope.limit);
    };
    $scope.setPageNumber = (pageNumber) => {
        $scope.pageNumber = pageNumber;
    };
    const getTotalPage = (arr, soSanPham) => {
        return Math.ceil(arr.length / soSanPham);
    };
    $scope.load_all();
    $scope.detail = (id) => {
        location.replace("/admin/category/detail?idDanhMuc=" + id);
    }
$scope.deleteDanhMuc = (id) => {
    const idDanhMuc = id;
    
    // Hiển thị cửa sổ xác nhận
    Swal.fire({
        title: 'Xác nhận xóa',
        text: 'Bạn có chắc chắn muốn xóa danh mục này?',
        icon: 'warning',
        showCancelButton: true,
         confirmButtonColor: "A8A196",
        cancelButtonColor: "FF8F8F",
        confirmButtonText: 'Xóa',
        cancelButtonText: 'Hủy',
    }).then((result) => {
        // Nếu người dùng xác nhận xóa
        if (result.isConfirmed) {
            const urlXoa = `${host}/${idDanhMuc}`;
            $http.delete(urlXoa).then(resp => {
                // Hiển thị thông báo xóa thành công
                Swal.fire({
                    title: 'Thành công!',
                    text: 'Xóa danh mục thành công',
                    icon: 'success',
                }).then(() => {
                    // Thực hiện hành động sau khi đóng alert (nếu cần)
                    location.replace("/admin/category");
                });
            }).catch((resp) => {
                // Hiển thị SweetAlert khi có lỗi
                Swal.fire({
                    title: 'Lỗi!',
                    text: 'Không thể xóa vì tồn tại sản phẩm có danh mục này',
                    icon: 'error',
                });
            });
        }
    });
};


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