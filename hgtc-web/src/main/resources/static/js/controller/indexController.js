app.controller('indexController', function ($scope, $controller, loginService,userService) {
    //读取当前登录人
    $scope.showLoginName = function () {
        // loginService.loginName().success(
        // 		function(response){
        // 			$scope.loginName=response.loginName;
        // 		}
        // );
        $scope.yysName = sessionStorage.getItem("yysName");
        $scope.id = sessionStorage.getItem("id");
        if ($scope.yysName == "undefined") {
            sessionStorage.removeItem("yysName");
        }
        if ($scope.id == "undefined") {
            sessionStorage.removeItem("id");
        }
        if ($scope.id != null) {

        }

        if ($scope.yysName == null && $scope.id == null) {
            window.location = "login.html"
        }


    }

    //注销
    $scope.logout = function () {
        /*   //删除sessionStorage中的managerId和managerName
           sessionStorage.removeItem("yysName");
           sessionStorage.removeItem("id");
           //跳转到登录界面
           $scope.yysName = sessionStorage.getItem("yysName");
           $scope.id = sessionStorage.getItem("id");
           if ($scope.yysName==null&&$scope.id ==null){
               window.location="../manager/login.html"
           }*/
        sessionStorage.clear();
        window.location = "login.html";
    }

    //selectByPrimaryKey根据用户id查询用户信息
    $scope.selectByPrimaryKey=function () {
        var id=sessionStorage.getItem("id");
        if(id!=null){
            userService.selectByPrimaryKey().success(
                function(response){
                    $scope.member=response.data;
                    // console.log($scope.member);
                    $scope.yysName=$scope.member.yysName;
                    $scope.yysId=$scope.member.yysId;
                    $scope.yysHouseId=$scope.member.yysHouseId;
                    $scope.phone=$scope.member.phone;
                    $scope.qq=$scope.member.qq;

                    /* document.getElementById("phone").value=$scope.phone;
                     document.getElementById("yysName").value=$scope.yysName;
                     document.getElementById("yysId").value=$scope.yysId;
                     // document.getElementById("yysHouseId").value=$scope.yysHouseId;
                     document.getElementById("qq").value=$scope.qq;*/


                    /*yearSel[0].innerHTML = $scope.year
                    yearSel[0].value = $scope.year*/
                }
            );
        }else {
            alert("未登录");
            window.location="login.html";
        }
    }
    //修改个人信息
    $scope.updateUserInfo=function(){

        // $scope.entity.year =document.getElementById("select_year2").value;
        // $scope.entity.month =document.getElementById("select_month2");
        // $scope.entity.day =document.getElementById("select_day2");

        // alert($scope.entity);
        /* $scope.entity.id=sessionStorage.getItem("userId");
         if($scope.entity.newPassword!=null&&$scope.entity.newPassword2!=null){
             if($scope.entity.newPassword!=$scope.entity.newPassword2){
                 alert("两次输入的密码不一致！");
                 return;
             }
         }*/

        userService.updateUserInfo($scope.member).success(
            function(response){
                if (response.code==000000){
                    //设置 sessionStorage中用户名的值
                    // console.log(response.data.username);
                    $scope.yysName =$scope.member.yysName;
                    sessionStorage.setItem("yysName",$scope.yysName);
                    // location.reload();
                }
                alert(response.message);
            }

        );
    }
});