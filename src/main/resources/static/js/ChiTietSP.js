var app = angular.module("myApp", []);

app.controller("myCtrl", function ($scope, $http) {

});
app.controller("sanphamCtrl", function ($scope, $http) {
    $scope.sanpham = [];
    $scope.pageSize = 9;
    $scope.begin = 0;
    $http.get("../js/sanpham.json").then(function (response) {
        $scope.sanpham = response.data;
        $scope.pageCount = Math.ceil($scope.sanpham.length / $scope.pageSize);
        $scope.prev = function () {
            if ($scope.begin > 0) {
                $scope.begin -= $scope.pageSize;
            }
        }
        $scope.next = function () {
            if ($scope.begin < ($scope.pageCount - 1) * $scope.pageSize) {
                $scope.begin += $scope.pageSize;
            }
        }
    })
    $scope.first = function () {
        $scope.begin = 0;
    }

    $scope.last = function () {
        $scope.begin = ($scope.pageCount - 1) * $scope.pageSize;
    }
});