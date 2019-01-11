// 定义服务层:
app.service("ordersService",function($http){
    this.findOrder = function(){
        return $http.get("../order/findOrder.do");
    }


    this.findPage=function(page,rows){
        return $http.get('../order/findPage.do?page='+page+'&rows='+rows);
    }


    this.findById=function(id){
        return $http.get("../order/findOne.do?id="+id);
    }

    this.search = function(page,rows,searchEntity){
        return $http.post("../order/findPage.do?page="+page+"&rows="+rows,searchEntity);
    }


    this.save = function(entity){
        return $http.post("../order/add.do",entity);
    }
});