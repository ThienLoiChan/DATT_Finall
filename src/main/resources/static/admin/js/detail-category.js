const host = "http://localhost:8080/rest/loaiQua";
const app = angular.module("DetailCategoryApp", []);
app.controller("DetailCategoryCtrl", function ($scope, $http) {
    $scope.checkInsert = false;
    //Lấy URL hiện tại
    const urlCurrent = new URL(location.href);
    // Lấy param
    const idDanhMuc = urlCurrent.searchParams.get("idDanhMuc");
    const url = `${host}/${idDanhMuc}`;
    $scope.load_all = function () {
        console.log("idDanhMuc", idDanhMuc);
        $http.get(url).then((resp) => {
            $scope.danhMuc = resp.data;
            console.log("Sucsess", resp.data);
        })
    }
    $scope.delete = function (filename) {
        $http.delete(url).then(resp => {
            console.log("Đã xóa", resp.data);
            alert("Tồn tại khoá ngoại không thể xoá!")
        }).catch(error => {
            alert("Tồn tại khoá ngoại không thể xoá!")
            console.log("Error", error);
        });
    }
   $scope.updateDanhMuc = (danhMuc) => {
    $http.put(url, danhMuc).then(resp => {
        // Thay thế alert bằng Swal.fire
        Swal.fire({
            title: "Thành Công !",
            text: "Sửa Danh Mục Thành Công",
            icon: "success"
        }).then(() => {
            console.log("success", resp.data);
        });
    }).catch(error => {
        // Hiển thị SweetAlert khi có lỗi
        Swal.fire({
            title: "Lỗi!",
            text: "Không Thể Sửa Danh Mục",
            icon: "error"
        });
    });
};

 $scope.insertDanhMuc = (danhMuc) => {
    $http.post(host, danhMuc).then(resp => {
        // Thay thế alert bằng Swal.fire
        Swal.fire({
            title: "Thành Công !",
            text: "Thêm Mới Danh Mục Thành Công",
            icon: "success"
        }).then(() => {
            console.log("success", resp.data);
        });
    }).catch(error => {
        // Hiển thị SweetAlert khi có lỗi
        Swal.fire({
            title: "Lỗi !",
            text: "Không Thể Thêm Mới Danh Mục",
            icon: "error"
        });
    });
};

$scope.deleteDanhMuc = (id) => {
    $http.delete(url).then(resp => {
        // Thay thế alert bằng Swal.fire
        Swal.fire({
            title: "Thành Công !",
            text: "Xóa Danh Mục Thành Công",
            icon: "success"
        }).then(() => {
            // Thực hiện hành động sau khi đóng alert (nếu cần)
            location.replace("/admin/category");
        });
    }).catch((resp) => {
        // Hiển thị SweetAlert khi có lỗi
        Swal.fire({
            title: "Lỗi!",
            text: "Không Thể Xóa Vì Tồn Tại Sản Phẩm Có Danh Mục Này",
            icon: "error"
        });
    });
};

    $scope.reset = () => {
        $scope.danhMuc = null;
        $scope.checkInsert = true;
    }
    $scope.load_all();
});