angular.module('Zookeeper').factory('enclosureFactory', ['$http' , function ($http){
    
    return {
	
        createEnclosure: function(enclosure){
    	return $http.post('/enclosures/create', enclosure);
        },
        
        getAllEnclosures: function(){
    	return $http.get('/enclosures/');
        },
        
        getEnclosureById: function(enclosureId){
        return $http.get('/enclosures/' + enclosureId);
        },
        
        updateEnclosure: function(enclosure){
    	return $http.put('/enclosures/update', enclosure);
        },
        
        deleteEnclosure: function(enclosureId){
        return $http.delete('/enclosures/delete/' + enclosureId);
        }

    };
}]);