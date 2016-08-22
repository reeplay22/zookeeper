angular.module('Zookeeper').factory('animalFactory',
	[ '$http', function($http) {

	    var animalFactory = {};

	    animalFactory.createAnimal = function(animal) {
		return $http.post('/animals/create', animal);
	    }

	    animalFactory.getAllAnimals = function() {
		return $http.get('/animals/');
	    }

	    animalFactory.updateAnimal = function(animal) {
		return $http.put('/animals/update', animal);
	    }

	    return animalFactory;
	} ]);