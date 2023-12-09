const host = "http://localhost:8080/rest/khachhang";
const app = angular.module("ChangePassApp", []);
app.controller("ChangePassCtrl", function ($scope,$http) {
  //Checklogin
  let sessionLogin = sessionStorage.getItem("User");
  if (sessionLogin != null) {
      $scope.username = sessionLogin;
      $scope.login = true;
  } else {
      $scope.login = false;
  }
  $scope.logout = () => {
      sessionStorage.clear();
      localStorage.clear();
      location.replace("/index");
  };
  const getSoLuongGioHang = () => {
      if(localStorage.getItem(sessionLogin)==null){
          return 0;
      }
      const gioHang = JSON.parse(localStorage.getItem(sessionLogin))|| [];
      console.log("localstore", gioHang);
      let soLuongGioHang = gioHang.reduce((accum, item) => accum + item.soLuong, 0)
      console.log("soluonggioHang", soLuongGioHang);
      return soLuongGioHang;
  };
  $scope.load_all = function () {
    if (sessionLogin == null) {
        $scope.soLuongGioHang = 0;
        location.replace("/index")
    } else {
        $scope.soLuongGioHang = getSoLuongGioHang();
        const id=$scope.username;
        const url = `${host}/${id}`;
        $http.get(url).then((resp) => {
           $scope.khachHang=resp.data;
        })
    }
  }
  
  
  
  $scope.doiMatKhau = function (matKhau) {
    const idKhachHang = $scope.username;
    const urlKhachHang = `${host}/${idKhachHang}`;
    
    $http.get(urlKhachHang).then((resp) => {
        const khachHang = $scope.khachHang;
        if ($scope.khachHang.matKhau != matKhau.matKhau) {
            $scope.wrongPass = true;
        } else if (matKhau.matKhauMoi != matKhau.nhapLaiMatKhauMoi) {
            $scope.wrongPass = false;
            $scope.wrongReNewPass = true;
        } else {
            const url = `${host}/${idKhachHang}`;
            khachHang.matKhau = matKhau.matKhauMoi;
            
            $http.put(url, khachHang).then((resp) => {
                $scope.wrongPass = false;
                $scope.wrongReNewPass = false;
                $scope.matKhau = null;
                
                Swal.fire({
                    icon: 'success',
                    title: 'Thay đổi mật khẩu thành công!',
                    text: 'Vui lòng đăng nhập lại',
                }).then(() => {
                    sessionStorage.clear();
                    localStorage.clear();
                    location.replace("/login");
                });
            });
        }
    });
};

     
  $scope.load_all();
});