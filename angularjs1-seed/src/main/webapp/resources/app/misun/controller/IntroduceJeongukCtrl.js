'use strict';
angular.module('meta-app').controller('JeongukCtrl', function ($scope, $http, $rootScope, JeongukService) {
    $scope.introduce = { text: '안녕하세요 전임 임정욱 입니다.'};
    
    console.log($scope.$root.commonText);
    

    JeongukService.getBoardList($rootScope.currentUser).success(function(resp){
        console.log(resp);
        $scope.boardLists= resp.data;
    })
    

    $scope.getDetailInfo = function () {

        JeongukService.getDetailInfo($scope.id).success(function(resp){
            console.log(resp);
//            $scope.content = resp.data.content;
        }).error(function(resp){
        });
    }
});