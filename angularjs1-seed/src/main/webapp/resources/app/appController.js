'use strict';
angular.module('meta-app').controller('AppCtrl', function ($scope, $rootScope) {
    $rootScope.userList = [
        {id: 'misun-kim', name: '김미선', position: '선임', department: '지능융합기술실'},
        {id: 'jeonguk-im', name: '임정욱', position: '전임', department: 'SW연구센터'}
    ];
    $rootScope.currentUser = 'misun-kim'
    $rootScope.setUser=function(user){
    	$rootScope.currentUser=user;
    	console.log($scope.$root.currentUser);
    }
    $rootScope.commonText = '메타빌드 신입사원 교육용 AngularJS1 템플릿입니다.'
});

