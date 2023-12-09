const host = "http://localhost:8080/rest/khachhang";
const app = angular.module("InformationApp", []);
app.controller("InformationCtrl", function ($scope,$http) {
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
           console.log("Sucsess", resp.data);
           $scope.khachHang=resp.data;
        })
    }
  }
  
  
$scope.saveKhachHang = function (khachHang) {
    console.log("khachHang", khachHang);
    const id = khachHang.taiKhoan;
    const url = `${host}/${id}`;
    
    $http.put(url, khachHang).then((resp) => {
        console.log("Success", resp.data);
        
        Swal.fire({
            icon: 'success',
            title: 'Thay đổi thông tin thành công!',
            showConfirmButton: false,
            timer: 1500 // Tự động đóng sau 1.5 giây
        });
    });
};

  
  
  $scope.load_all();
});