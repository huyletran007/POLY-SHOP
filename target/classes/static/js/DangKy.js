var app = angular.module("myApp", []);
app.controller("myCtrl", function ($scope, $rootScope) {
    $scope.dangkyL = {};
    $scope.index = -1;
    document.getElementById('error_tk').style.display = "none";
    document.getElementById('error_mk').style.display = "none";
    $scope.dangky = function () {
        var tk = parseFloat($scope.dangkyL.email);
        var mk = parseFloat($scope.dangkyL.pass1);
        var regName = /^[a-zA-Z ]+$/;
        const taikhoan = document.getElementById('789');
        const matkhau = document.getElementById('123');
        let fullnameValue = taikhoan.value;
        let matkhauLogin = matkhau.value;
        if (fullnameValue != '') {
            $('#789').addClass('alert-danger');
            document.getElementById('error_tk').style.display = "none";
        } else {
            $('#789').addClass('alert-danger');
            document.getElementById('error_tk').style.display = "block";
        }
    }
});
