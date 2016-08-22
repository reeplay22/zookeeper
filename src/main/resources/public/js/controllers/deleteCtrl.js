angular
	.module("Zookeeper")
	.controller(
		"deleteCtrl",
		[
			'$scope',
			'enclosureFactory',
			function($scope, enclosureFactory) {

			    $scope.enclosures = {};
			    $scope.selectedEnclosure = {};

			    enclosureFactory.getAllEnclosures().then(
				    function(response) {

					$scope.enclosures = response.data;
				    });

			    $scope.changeEnclosureFunction = function() {
				$scope.enclosure = $scope.selectedEnclosure;
			    };

			    $scope.deleteEnclosureFunction = function() {
				console.log($scope.selectedEnclosure);
				enclosureFactory
					.deleteEnclosure(
						$scope.selectedEnclosure.enclosureId)
					.then(
						function(response) {
						    $scope.reply = "enclosure has been successfully deleted";
						})

			    };
			} ]);