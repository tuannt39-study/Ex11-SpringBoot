'use strict';

angular.module('myApp').controller('BaiVietController', ['$scope', 'BaiVietService', function($scope, BaiVietService) {
	
    var self = this;
    self.baiviet={maBV:null,tieuDe:'',danhMuc:'',chiTiet:'',lichDang:'',trangThai:'',nhan:''};
    self.baiviets=[];

    self.submit = submit;
    self.update = update;
    self.remove = remove;
    self.reset = reset;
	
    fetchAllBaiViets();

    function fetchAllBaiViets(){
    	BaiVietService.fetchAllBaiViets()
            .then(
            function(d) {
                self.baiviets = d;
            },
            function(errResponse){
                console.error('Error while fetching BaiViets');
            }
        );
    }
    
    function createBaiViet(baiviet){
        BaiVietService.createBaiViet(baiviet)
            .then(
            fetchAllBaiViets,
            function(errResponse){
                console.error('Error while creating BaiViet');
            }
        );
    }
    
    function updateBaiViet(baiviet, maBV){
        BaiVietService.updateBaiViet(baiviet, maBV)
            .then(
            fetchAllBaiViets,
            function(errResponse){
                console.error('Error while updating BaiViet');
            }
        );
    }

    function deleteBaiViet(maBV){
        BaiVietService.deleteBaiViet(maBV)
            .then(
            fetchAllBaiViets,
            function(errResponse){
                console.error('Error while deleting BaiViet');
            }
        );
    }

    function submit() {
        if(self.baiviet.maBV===null){
            console.log('Saving New BaiViet', self.baiviet);
            createBaiViet(self.baiviet);
        }else{
            updateBaiViet(self.baiviet, self.baiviet.maBV);
            console.log('BaiViet updated with maBV ', self.baiviet.maBV);
        }
        reset();
    }

    function update(maBV){
        console.log('maBV to be updated', maBV);
        for(var i = 0; i < self.baiviets.length; i++){
            if(self.baiviets[i].maBV === maBV) {
                self.baiviet = angular.copy(self.baiviets[i]);
                break;
            }
        }
    }

    function remove(maBV){
        console.log('maBV to be deleted', maBV);
        if(self.baiviet.maBV === maBV) {//clean form if the baiviet to be deleted is shown there.
            reset();
        }
        deleteBaiViet(maBV);
    }

    function reset(){
        self.baiviet={maBV:null,tieuDe:'',danhMuc:'',chiTiet:'',lichDang:'',trangThai:'',nhan:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
