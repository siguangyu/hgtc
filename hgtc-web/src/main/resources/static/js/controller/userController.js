app.controller('userController', function ($scope, userService) {

//修改个人信息
  /*  $scope.updateUserInfo=function(){

        // $scope.entity.year =document.getElementById("select_year2").value;
        // $scope.entity.month =document.getElementById("select_month2");
        // $scope.entity.day =document.getElementById("select_day2");

        // alert($scope.entity);
       /!* $scope.entity.id=sessionStorage.getItem("userId");
        if($scope.entity.newPassword!=null&&$scope.entity.newPassword2!=null){
            if($scope.entity.newPassword!=$scope.entity.newPassword2){
                alert("两次输入的密码不一致！");
                return;
            }
        }*!/
       alert($scope.member);
        userService.updateUserInfo($scope.member).success(
            function(response){
                alert(response.message);

                if (response.code==000000){
                    //设置 sessionStorage中用户名的值
                    // console.log(response.data.username);
                    sessionStorage.setItem("userName",response.data.yysName);
                    $scope.yysName = response.data.yysName;
                    // location.reload();
                }
            }

        );
    }


    //selectByPrimaryKey根据用户id查询用户信息
    $scope.selectByPrimaryKey=function () {
        var id=sessionStorage.getItem("id");
        if(id!=null){
            userService.selectByPrimaryKey().success(
              function(response){
                  $scope.member=response.data;
                  console.log($scope.member);
                  $scope.yysName=$scope.member.yysName;
                  $scope.yysId=$scope.member.yysId;
                  $scope.yysHouseId=$scope.member.yysHouseId;
                  $scope.phone=$scope.member.phone;
                  $scope.qq=$scope.member.qq;

                 /!* document.getElementById("phone").value=$scope.phone;
                  document.getElementById("yysName").value=$scope.yysName;
                  document.getElementById("yysId").value=$scope.yysId;
                  // document.getElementById("yysHouseId").value=$scope.yysHouseId;
                  document.getElementById("qq").value=$scope.qq;*!/


                  /!*yearSel[0].innerHTML = $scope.year
                  yearSel[0].value = $scope.year*!/
              }
            );
        }else {
            alert("未登录");
            window.location="login.html";
        }
    }*/


    //注册
    $scope.reg = function () {
        if ($scope.entity.password != $scope.password) {
            alert("两次输入的密码不一致，请重新输入");
            return;
        }
        userService.add($scope.entity).success(
            function (response) {

                if (response.code==000000){
                    alert("注册成功",response.message+"!去登陆");
                    window.location="./login.html";
                }
                else{
                    alert(response.message);
                }
            }
        );
    }

    //登录
    $scope.login = function () {
        userService.login($scope.entity).success(
            function (response) {
                // alert(response.message);
                // console.log(response.message);
                if (response.code == 000000) {
                    //登录成功之后, 把个人信息存储到sessionStoreger中
                    var yysName = response.data.yysName;
                    var id=response.data.id;
                    sessionStorage.setItem("id",id);
                    sessionStorage.setItem("yysName",yysName);
                    sessionStorage.setItem("accessToken",response.data.token);
                    //跳转到首页
                    window.location="index.html";
                }
                else{
                    alert(response.message);
                }
            }
        );
    }

    $scope.logout = function () {
        sessionStorage.clear();
        window.location="login.html";
    }




});
