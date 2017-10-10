'use strict';

angular.module('myApp').factory('BaiVietService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/api/baiviet/';

    var factory = {
        fetchAllBaiViets: fetchAllBaiViets,
        createBaiViet: createBaiViet,
        updateBaiViet:updateBaiViet,
        deleteBaiViet:deleteBaiViet
    };

    return factory;

    function fetchAllBaiViets() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/all")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching BaiViets');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createBaiViet(baiviet) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "/create", baiviet)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating BaiViet');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateBaiViet(baiviet, maBV) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + "/update/" + maBV, baiviet)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating BaiViet');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteBaiViet(maBV) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + "/delete/" + maBV)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting BaiViet');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
