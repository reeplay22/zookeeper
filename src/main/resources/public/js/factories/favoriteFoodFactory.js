angular.module('Zookeeper').factory('favoriteFoodFactory',
	[ '$http', function($http) {

	    var favoriteFoodFactory = {};

	    favoriteFoodFactory.createFavoriteFood = function(favoriteFood) {
		return $http.post('/favoriteFoods/create', favoriteFood);
	    }

	    favoriteFoodFactory.getAllFavoriteFoods = function() {
		return $http.get('/favoriteFoods/');
	    }

	    favoriteFoodFactory.updateFavoriteFood = function(favoriteFood) {
		return $http.put('/favoriteFoods/update', favoriteFood);
	    }

	    return favoriteFoodFactory;
	} ]);