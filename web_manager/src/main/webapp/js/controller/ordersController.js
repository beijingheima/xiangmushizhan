// 定义控制器:
app.controller("ordersController",function($scope,$controller,$http,ordersService){
	// AngularJS中的继承:伪继承
	$controller('baseController',{$scope:$scope});

    // 查询所有的订单的方法:
	$scope.findAll = function(){
		// 向后台发送请求:
        ordersService.findAll().success(function(response){
			$scope.list = response;
		});
	}

	// 分页查询
	$scope.findByPage = function(page,rows){
		// 向后台发送请求获取数据:
        ordersService.findByPage(page,rows).success(function(response){
			$scope.paginationConf.totalItems = response.total;
			$scope.list = response.rows;
		});
	}
	// 查询一个:
	$scope.findById = function(id){
        ordersService.findById(id).success(function(response){
			// {id:xx,name:yy,firstChar:zz}
			$scope.entity = response;
		});
	}
	

	
	$scope.searchEntity={};
	
	// 假设定义一个查询的实体：searchEntity
	$scope.search = function(page,rows){
		// 向后台发送请求获取数据:
        ordersService.search(page,rows,$scope.searchEntity).success(function(response){
			$scope.paginationConf.totalItems = response.total;
			$scope.list = response.rows;
		});
	}
});
