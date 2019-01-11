app.service("contentService",function($http){
	this.findByCategoryId = function(categoryId){
		return $http.get("content/findByCategoryId.do?categoryId="+categoryId);
	}


    this.findAllItenCat = function(){
        return $http.get("content/findAllItenCat.do");
    }

    this.findAllItenCat2 = function(id){
        return $http.get("content/findAllItenCat2.do");
    }



});