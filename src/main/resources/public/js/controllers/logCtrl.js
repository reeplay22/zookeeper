angular.module("Zookeeper").controller(
	"logCtrl",
	[
		'$scope',
		'animalFactory',
		'enclosureFactory',
		function($scope, animalFactory, enclosureFactory) {

		    $scope.enclosures = [];
		    enclosureFactory.getAllEnclosures().then(
			    function(response) {
				$scope.enclosures = response.data;
				console.log($scope.enclosures.feedingTime);
			    });

		    console.log($scope.enclosures.feedingTime);

		} ]);