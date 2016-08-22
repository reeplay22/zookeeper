angular
	.module('Zookeeper')
	.controller(
		'updateCtrl',
		[
			'$scope',
			'$stateParams',
			'$http',
			'$log',
			'enclosureFactory',
			'animalFactory',
			'favoriteFoodFactory',
			function($scope, $stateParams, $http, $log,
				enclosureFactory, animalFactory,
				favoriteFoodFactory) {

			    $scope.enclosures = {};
			    $scope.selectedEnclosure = {};
			    /* get all enclosures */
			    enclosureFactory.getAllEnclosures().then(
				    function(response) {
					$scope.enclosures = response.data;

				    })

			    /* Time picker functions and data */
			    $scope.myTime = new Date();

			    $scope.hstep = 1;
			    $scope.mstep = 5;

			    $scope.ismeridian = true;
			    $scope.toggleMode = function() {
				$scope.ismeridian = !$scope.ismeridian;
			    };

			    $scope.changed = function() {
				$log.log('Time changed to: ' + $scope.myTime);
				$scope.selectedEnclosure.feedingTime = $scope.myTime;
			    };

			    $scope.changeEnclosureFunction = function() {
				$scope.enclosure = $scope.selectedEnclosure;
				console.log($scope.selectedEnclosure)
			    };

			    /* fetch animal object */
			    $scope.animals = [];
			    animalFactory.getAllAnimals().then(
				    function(response) {
					$scope.animals = response.data;
					console.log(response);
				    });

			    $scope.addAnimalFunction = function() {
				$scope.enclosure.animal = $scope.selectedAnimal;
			    };

			    /*
			     * upon clicking the Submit button, send in the
			     * update Enclosures object and update
			     */
			    $scope.updateEnclosureFunction = function() {
				$scope.updateEnclosures = {
				    enclosureId : $scope.selectedEnclosure.enclosureId,
				    enclosureName : $scope.selectedEnclosure.enclosureName,
				    animal : $scope.selectedAnimal,
				    feedingTime : $scope.myTime,
				    enclosureCondition : $scope.selectedEnclosure.enclosureCondition
				};
				console.log($scope.enclosures);

				if ($scope.enclosures.enclosureName !== "") {

				    enclosureFactory
					    .updateEnclosure(
						    $scope.updateEnclosures)
					    .success(
						    function(response) {
							console.log(response);
							console
								.log("Expense Report updated!!!");
							$scope.message = "Enclosure has been Updated!!!"
						    })
					    .error(
						    function(reason) {
							$scope.error = reason.data;
							console.log("invalid");
							$log.info(reason);
							$scope.message = "Error with one of your input, please re-attempt!!!"
						    });

				} else {
				    $scope.error = "Some of the field is empty, please double check and retry";
				}

			    };

			} ]);