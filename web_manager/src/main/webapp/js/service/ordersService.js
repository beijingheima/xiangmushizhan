// 定义服务层:
app.service("ordersService",function($http){
    this.findAll = function(){
        return $http.get("../orders/findAll.do");
    }

    this.findByPage = function(page,rows){
        return $http.get("../orders/findByPage.do?page="+page+"&rows="+rows);
    }

    this.findById=function(id){
        return $http.get("../orders/findOne.do?id="+id);
    }

    this.search = function(page,rows,searchEntity){
        return $http.post("../orders/search.do?page="+page+"&rows="+rows,searchEntity);
    }

    this.selectOptionList = function(){
        return $http.get("../orders/selectOptionList.do");
    }
});