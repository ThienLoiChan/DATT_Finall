const host = "http://localhost:8080/rest/khachhang";
const app = angular.module("RegisterApp", []);
app.controller("RegisterCtrl", function ($scope, $http) {
    //Checklogin
    let sessionLogin = sessionStorage.getItem("User");
    if (sessionLogin != null) {
        location.replace("/index");
        return;
    }
    $scope.register = () => {
        $http.get(host).then(resp => {
            const list=resp.data;
            //Lấy giá trị từ ô input
            const username = $scope.idUser;
            const password = $scope.idPassword;
            const repassword = $scope.idRePassword;
            const phone = $scope.idPhone;
            const fullname = $scope.idFullname;
            const address = $scope.idAddress;
            //Tạo 1 Object chứa khách hàng
            const registerObj = {
                taiKhoan: username,
                matKhau: password,
                tenKhachHang: fullname,
                soDienThoai: phone,
                diaChi: address
            };
            //Tạo biến check đăng ký
            var checkRegister = true;
            if ((!username, !password, !repassword, !phone, !fullname, !address)) {
                checkRegister = false;
            }
            //Tìm username xem đã tồn tại hay chưa
            var idx = list.findIndex((item) => {
                return username == item.taiKhoan;
            });
            //Nếu user name đã tồn tại
            if (idx > -1) {
                $scope.reason = "Tên đăng nhập đã tồn tại!";
                checkRegister = false;
            } else if (password != repassword) {
                $scope.reason = "Nhập lại mật khẩu sai!";
                checkRegister = false;
            } else {
                $scope.reason = null;
            }
            // Kiểm tra đăng ký thành công hoặc thất bại
            $scope.registerSucess = checkRegister;
            if (checkRegister) {
                const item=registerObj;
                $("#myModal").modal("show"); //Hiện modal lên
                $http.post(host,item).then(resp=>{
                    console.log("Sucsess", resp);
                })
                let setTime = 5;
                const elementTimeOut = document.getElementById("second");
                setInterval(() => { // Sau mỗi 1s thực hiện lại thao tác 1 lần
                    setTime--;
                    if (setTime < 0) {
                        setTime = 0;
                    }
                    elementTimeOut.innerHTML = setTime;
                }, 1000);
                setTimeout(() => {
                    location.replace("/login");
                }, 5000); // delay 5s để chuyển trang
            }
        }).catch(error => {
            console.log("Error", error)
        });
    }
    $scope.goToLogin = () => {
        location.replace("/login");
    };
});

