const host = "http://localhost:8080/rest";
const app = angular.module("DetailApp", []);
app.controller("DetailCtrl", function ($scope, $http) {
    const urlImage = `http://localhost:8080/rest/files/images`;
    $scope.checkInsert = false;
    $scope.srcImage = urlImage;
    $scope.load_all = function () {
        //Lấy URL hiện tại
        const urlCurrent = new URL(location.href);
        // Lấy param
        const idQua = urlCurrent.searchParams.get("idQua");
        console.log("idQua", idQua);
        const url = `${host}/Qua/${idQua}`;
        $http.get(url).then((resp) => {
            $scope.Qua = resp.data;
            $scope.tenHinhAnh = $scope.Qua.hinhAnh;
            console.log("Sucsess", resp.data);
        })
        const urlLoaiQua = `${host}/loaiQua`;
        $http.get(urlLoaiQua).then((resp) => {
            $scope.listLoaiQua = resp.data;
        })
        const urlHangQua = `${host}/hangQua`;
        $http.get(urlHangQua).then((resp) => {
            $scope.listHangQua = resp.data;
        })
    }
    $scope.upload = (files) => {
        const form = new FormData();
        for (let i = 0; i < files.length; i++) {
            form.append("files", files[i]);
        }
        $http.post(urlImage, form, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.tenHinhAnh = resp.data[0];
            console.log("sucesss", resp.data[0])
        }).catch(error => {
            console.log("Error", error);
        });
    }
    $scope.delete = function (filename) {
        $http.delete(`${urlImage}/${filename}`).then(resp => {
            console.log("Đã xóa", resp.data);
        }).catch(error => {
            console.log("Error", error);
        });
    }
$scope.updateQua = (Qua) => {
    Qua.hinhAnh = $scope.tenHinhAnh;
    Qua.giamGia = document.getElementById("giamGia").value / 100;
    const viTriLoaiQua = document.getElementById("loaiQuaSelected").value.slice(7, 8);
    Qua.loaiQua = $scope.listLoaiQua[viTriLoaiQua - 1];
    const viTriHangQua = document.getElementById("hangQuaSelected").value.slice(7, 8);
    Qua.hangQua = $scope.listHangQua[viTriHangQua - 1];

    // Lấy URL hiện tại
    const urlCurrent = new URL(location.href);
    // Lấy param
    const idQua = urlCurrent.searchParams.get("idQua");
    console.log("idQua", idQua);
    const url = `${host}/Qua/${idQua}`;

    $http.put(url, Qua).then(resp => {
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
            text: "Không Thể Sửa Đơn Hàng",
            icon: "error"
        });
    });
};

  $scope.insertQua = (Qua) => {
    Qua.hinhAnh = $scope.tenHinhAnh;
    Qua.giamGia = document.getElementById("giamGia").value / 100;
    const viTriLoaiQua = document.getElementById("loaiQuaSelected").value.slice(7, 8);
    Qua.loaiQua = $scope.listLoaiQua[viTriLoaiQua - 1];
    const viTriHangQua = document.getElementById("hangQuaSelected").value.slice(7, 8);
    Qua.hangQua = $scope.listHangQua[viTriHangQua - 1];
    const url = `${host}/Qua`;

    $http.post(url, Qua).then(resp => {
        // Thay thế alert bằng Swal.fire
        Swal.fire({
            title: "Thành Công !",
            text: "Thêm Mới Sản Phẩm Thành Công",
            icon: "success"
        }).then(() => {
            console.log("success", resp.data);
        });
    }).catch(error => {
        console.error(error);

        // Hiển thị SweetAlert khi có lỗi
        Swal.fire({
            title: "Lỗi!",
            text: "Không Thể Thêm Mới Sản Phẩm",
            icon: "error"
        });
    });
};

    $scope.deleteQua = (id) => {
        // const urlDanhGia = `${host}/danhgia/${id}`;
        // $http.delete(urlDanhGia).then(resp => {

        // })
        const urlQua = `${host}/Qua/${id}`;
        $http.delete(urlQua).then(resp => {
            alert("Xóa thành công!");
            location.replace("/admin/index")
        })
    }
    $scope.reset = () => {
        $scope.Qua = null;
        document.getElementById('inputImgQua').value = "";
        $scope.checkInsert = true;
    }
    $scope.load_all();
});