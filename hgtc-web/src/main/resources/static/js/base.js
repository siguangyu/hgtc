var app = angular.module("hgtc", []);
app.config(function ($httpProvider) {
    //为请求头添加accesstoken
    $httpProvider.defaults.headers.common['accesstoken'] = sessionStorage.getItem("accessToken");
})