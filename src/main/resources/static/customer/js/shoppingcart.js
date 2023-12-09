const host = "http://localhost:8080/rest/khachhang";
const app = angular.module("ShoppingCartApp", []);
app.controller("ShoppingCartCtrl", function ($scope) {
  //Checklogin
  let sessionLogin = sessionStorage.getItem("User");
  if (sessionLogin != null) {
    $scope.username = sessionLogin;
    $scope.login = true;
  } else {
    $scope.login = false;
    location.replace("/index");
  }
  $scope.logout = () => {
    sessionStorage.clear();
    location.replace("/index");
  };
  const getSoLuongGioHang = () => {
    const gioHang = JSON.parse(localStorage.getItem(sessionLogin));
    console.log("gioHang",gioHang)
    let soLuongGioHang =0;
    if(gioHang!=null){
        soLuongGioHang =gioHang.reduce((accum, item) => accum + item.soLuong, 0)
    }
    return soLuongGioHang;
  };
  $scope.srcImage = `http://localhost:8080/rest/files/images`;
  $scope.soLuongGioHang = getSoLuongGioHang();
  $scope.listGioHang = JSON.parse(localStorage.getItem(sessionLogin));
  $scope.getTongTien = () => {
    let tongTien = 0;
    let dongia = 0;
    $scope.listGioHang.forEach((item) => {
		dongia = item.Qua.donGia - (item.Qua.donGia * item.Qua.giamGia);
      tongTien += dongia * item.soLuong;
    });
    return tongTien;
  };
  $scope.removeItem = (item) => {
    const gioHang= JSON.parse(localStorage.getItem(sessionLogin));
    let index=gioHang.findIndex((i)=>{
      return i.Qua.maQua === item.Qua.maQua
    });
    if (index !== -1) {
      gioHang.splice(index, 1);
    }
    localStorage.clear();
    localStorage.setItem(sessionLogin, JSON.stringify(gioHang));
    $scope.listGioHang = JSON.parse(localStorage.getItem(sessionLogin));
    $scope.soLuongGioHang = getSoLuongGioHang();
  };
  $scope.removeAll=()=>{
    localStorage.clear();
    $scope.listGioHang = JSON.parse(localStorage.getItem(sessionLogin));
    $scope.soLuongGioHang=0;
  }
  $scope.datHang=()=>{
    location.replace("/order");
  }
  $scope.changeNumber=(Qua)=>{

    const gioHangObj = {};
    const gioHang = $scope.listGioHang;
    //Tìm vị trí giỏ hàng
    let viTri=-1;
    if(gioHang!=null){
        viTri = gioHang.findIndex((item, i) => {
            return item.Qua.maQua === Qua.maQua
        });
    }
    if(viTri != -1){
        gioHang[viTri].soLuong =Qua.soLuong;
    }
    localStorage.setItem(sessionLogin, JSON.stringify(gioHang));
    $scope.soLuongGioHang = getSoLuongGioHang();
  }
});