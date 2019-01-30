angular.module('meta-app').factory('JeongukService', function ($http) {
    /**
     *  목록 조회
     */
    function getBoardList(userId){
        return $http({
            url: '/seed/rest/getBoardList',
            method: "GET",
            params:{user_id:userId}
        });
    }
    
    return {
        'getBoardList': function(userId){
            return getBoardList(userId);
        }
    }
});