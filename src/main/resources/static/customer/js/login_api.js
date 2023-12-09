const app = angular.module("LoginApp", []);
app.controller("LoginCtrl", function ($scope, $http) {
  //Checklogin
  let sessionLogin = sessionStorage.getItem("User");
  if (sessionLogin != null) {
    const urlTaiKhoan = `http://localhost:8080/rest/khachhang/${sessionLogin}`;
    $http.get(urlTaiKhoan).then(resp => {
      if (resp.data.quyen.maQuyen == 1) {
        location.replace("./index");
      } else {
        location.replace("./admin/index");
        $scope.username = sessionLogin;
        $scope.login = true;
      }
    });

    return;
  }
  const url = new URL(location.href);
  const loginStatus = url.searchParams.get("loginStatus");
  if (loginStatus == "false") {
    $scope.message = "Vui lòng đăng nhập để tiếp tục";
    $scope.noLogin = true;

    console.log($scope.message)
  }
  console.log(loginStatus);
  $scope.login = () => {
    const username = document.getElementById("idUser").value;
    const password = document.getElementById("idPassword").value;
    $http.get("http://localhost:8080/rest/khachhang").then((resp) => {
      const khachHangData = resp.data;
      console.log(khachHangData);
      angular.forEach(khachHangData, (item) => {
        if (username == item.taiKhoan && password === item.matKhau && item.quyen.maQuyen != 3) {
          sessionStorage.setItem("User", username);
          $scope.username = sessionLogin;
          $scope.login = true;
          if (item.quyen.maQuyen != 3) {
            const origin = location.origin;
            location.replace(origin+"/index");
          }
        } else {
          $scope.loginFail = true;
          $scope.message = "Tên đăng nhập hoặc mật khẩu không chính xác";
        }
      })

    }).catch(error => {
      console.log("Error", error)
    });
  }
});

