app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/product",{
        templateUrl:"/admin/product/index.html",
        controller: "product-ctrl"
    })
    .when("/account",{
        templateUrl:"/admin/account/index.html",
        controller: "account-ctrl"
    })
    .when("/summary",{
        templateUrl:"/admin/summary/index.html",
        controller: "summary-ctrl"
    })
    .when("/authorize",{
        templateUrl:"/admin/authority/index.html",
        controller: "authority-ctrl"
    })
    .when("/unauthorized",{
        templateUrl:"/admin/authority/unauthorized.html",
        controller: "authority-ctrl"
    })
    .otherwise({
        redirectTo: "/summary",
        controller: "summary-ctrl"
    })
})