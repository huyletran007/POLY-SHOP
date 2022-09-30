var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        .when("/new", {
            templateUrl: "../home/New/New.html"
        })
        .when("/noibat", {
            templateUrl: "../home/New/Noibat.html"
        })
        .when("/lienhe", {
            templateUrl: "../home/New/lienhe.html"
        })
        .otherwise({
            redirectTo: "/new"
        })

});
app.run(function ($rootScope) {
    $rootScope.$on('$routeChangeStart', function () {
        $rootScope.loading = true;
    });
    $rootScope.$on('$routeChangeSuccess', function () {
        $rootScope.loading = false;
    });
    $rootScope.$on('routeChangeError', function () {
        $rootScope.loading = false;
        alert("Lỗi, không tải được template")
    });
});