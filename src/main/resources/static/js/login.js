var app = angular.module("myApp", []);
app.controller("myCtrl", function ($scope, $rootScope) {
    $scope.login = {};
    $scope.index = -1;
    document.getElementById('error_tk').style.display = "none";
    document.getElementById('error_mk').style.display = "none";
    document.getElementById('error_tk_email').style.display = "none";
    $scope.dangnhap = function () {
        var tk = parseFloat($scope.login.taikhoan);
        var mk = parseFloat($scope.login.matkhau);
        var regName = /^[a-zA-Z ]+$/;
        var emaillg = /^([a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$)/;
        const taikhoan = document.getElementById('789');
        const matkhau = document.getElementById('123');
        let fullnameValue = taikhoan.value;
        let matkhauLogin = matkhau.value;
        if (fullnameValue != '') {
            document.getElementById('error_tk').style.display = "none";
            $('#789').removeClass('alert-danger');
            if (regName.test(tk)) {
                document.getElementById('error_tk_email').style.display = "none";
                $('#789').removeClass('alert-danger');
                if (matkhauLogin != '') {
                    document.getElementById('error_mk').style.display = "none";
                    $('#123').removeClass('alert-danger');
                    alert('Đăng nhập thành công!');
                } else {
                    $('#123').addClass('alert-danger');
                    document.getElementById('error_mk').style.display = "block";
                }
            } else {
                $('#789').addClass('alert-danger');
                document.getElementById('error_tk_email').style.display = "block";
            }
        } else {
            $('#789').addClass('alert-danger');
            document.getElementById('error_tk').style.display = "block";
        }
    }
});
