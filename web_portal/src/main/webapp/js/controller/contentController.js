app.controller("contentController",function($scope,contentService){
	$scope.contentList = [];
	// 根据分类ID查询广告的方法:
	$scope.findByCategoryId = function(categoryId){
		contentService.findByCategoryId(categoryId).success(function(response){
			$scope.contentList[categoryId] = response;
		});
	}
	
	//搜索,跳转到portal系统查询列表页面(传递参数）
	$scope.search=function(){
		location.href="http://localhost:8080/search.html#?keywords="+$scope.keywords;
	}

    $scope.itemCatList = null;
	//查询所有商品分类1
    $scope.findAllItenCat = function(){
        contentService.findAllItenCat().success(function(response){
            $scope.itemCatList = response;
        });
    }

    $scope.findAllItenCat2 = function(id){
        contentService.findAllItenCat2(id).success(function(response){
            $scope.itemCatList2 = response;
        });
    }
	
});