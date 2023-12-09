const host = "http://localhost:8080/rest";
const app = angular.module("StatisticalApp", []);
app.controller("StatisticalCtrl", function ($scope, $http) {
//   //Checklogin
//   let sessionLogin = sessionStorage.getItem("User");
//   if (sessionLogin != null) {
//       const urlTaiKhoan = `${host}/khachhang/${sessionLogin}`;
//       $http.get(urlTaiKhoan).then(resp => {
//           if (resp.data.quyen.maQuyen == 1) {
//               location.replace("/login?loginStatus=" + false);
//               $scope.disableKhachHang=true;
//           } else if (resp.data.quyen.maQuyen == 2) {
//               $scope.disableKhachHang=true;
//               $scope.username = sessionLogin;
//               $scope.login = true;
//           } else {
//               $scope.disableKhachHang=false;
//               $scope.username = sessionLogin;
//               $scope.login = true;
//           }
//       });
//
//   } else {
//       $scope.login = false;
//       location.replace("/login?loginStatus=" + false);
//   }
//    $scope.logout = () => {
//        sessionStorage.clear();
//        localStorage.clear();
//        location.replace("/login");
//    };
    $scope.yearChoosen = 2021;
    $scope.load_all = function () {
        const url = `${host}/thongke/${$scope.yearChoosen}`;
        $http.get(url).then((resp) => {
            $scope.doanhThu = resp.data;
            google.charts.load('current', {
                'packages': ['bar']
            });
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization
                    .arrayToDataTable([
                        ["Tháng", "Doanh thu"],
                        ["1", $scope.doanhThu.thang1],
                        ["2", $scope.doanhThu.thang2],
                        ["3", $scope.doanhThu.thang3],
                        ["4", $scope.doanhThu.thang4],
                        ["5", $scope.doanhThu.thang5],
                        ["6", $scope.doanhThu.thang6],
                        ["7", $scope.doanhThu.thang7],
                        ["8", $scope.doanhThu.thang8],
                        ["9", $scope.doanhThu.thang9],
                        ["10", $scope.doanhThu.thang10],
                        ["11", $scope.doanhThu.thang11],
                        ["12", $scope.doanhThu.thang12]
                    ]);
                var options = {
                    chart: {
                        title: 'Thống kê doanh thu',
                        subtitle: 'Doanh thu năm 2021',
                    }
                };

                var chart = new google.charts.Bar(document
                    .getElementById('columnchart_material'));

                chart.draw(data, google.charts.Bar.convertOptions(options));
            }
        })
    }
    $scope.changeYear = (year) => {
        $scope.yearChoosen = year;
        $scope.load_all();
    }
    $scope.load_all();

});

