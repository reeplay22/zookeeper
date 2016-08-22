angular
	.module('Zookeeper')
	.controller(
		'createCtrl',
		[
			'$scope',
			'$log',
			'animalFactory',
			'enclosureFactory',
			'favoriteFoodFactory',
			function($scope, $log, animalFactory, enclosureFactory,
				favoriteFoodFactory) {

			    $scope.animals = {};
			    $scope.favoriteFood = {};
			    $scope.enclosure = {};
			    $scope.regEx = '/([A-Z])\w+/g';

			    /* Time picker data */
			    $scope.myTime = new Date();
			    $scope.hstep = 1;
			    $scope.mstep = 1;

			    $scope.ismeridian = true;
			    $scope.toggleMode = function() {
				$scope.ismeridian = !$scope.ismeridian;
			    };

			    $scope.changed = function() {
				$log.log('Time changed to: ' + $scope.myTime);
				$scope.enclosure.feedingTime = $scope.myTime;
				
			    };
			    
			   
			    /*modal controller*/
			    			    
			    $scope.items = ['item1', 'item2', 'item3'];

			    $scope.animationsEnabled = true;

			    $scope.open = function (size) {

			      var modalInstance = $uibModal.open({
			        animation: $scope.animationsEnabled,
			        templateUrl: 'myModalContent.html',
			        controller: 'ModalInstanceCtrl',
			        size: size,
			        resolve: {
			          items: function () {
			            return $scope.items;
			          }
			        }
			      });

			      modalInstance.result.then(function (selectedItem) {
			        $scope.selected = selectedItem;
			      }, function () {
			        $log.info('Modal dismissed at: ' + new Date());
			      });
			    };

			    $scope.toggleAnimation = function () {
			      $scope.animationsEnabled = !$scope.animationsEnabled;
			    };

			    
			    

			    /* Animal object data binding and switching */
			    $scope.showAddAnimal = false;
			    $scope.showCreateAnimal = false;
			    $scope.selectedAnimal = {};
			    
			    $scope.mySplit = function(string, nb) {
				    var array = string.split(' ');
				    return array[nb];}
				    
			    $scope.showAddAnimalFunction = function() {
				$scope.showAddAnimal = true;
				$scope.showCreateAnimal = false;

				animalFactory.getAllAnimals().then(
					function(response) {
					    $scope.animals = response.data;
					    console.log(response);

					});
//				$scope.animals = animal.split(' ').map(function(animal){
//				    return {commonName: animal};
//				})
				
			    };

			    $scope.showCreateAnimalFunction = function() {
				$scope.showCreateAnimal = true;
				$scope.showAddAnimal = false;
			    };

			    $scope.addAnimalFunction = function() {
				$scope.enclosure.animal = $scope.selectedAnimal;
			    };

			    /* Favorite Food object data binding and switching */
			    $scope.showAddFavoriteFood = false;
			    $scope.showCreateFavoriteFood = false;
			    $scope.selectedFavoriteFood = {};

			    $scope.showAddFavoriteFoodFunction = function() {
				$scope.showAddFavoriteFood = true;
				$scope.showCreateFavoriteFood = false;

				favoriteFoodFactory
					.getAllFavoriteFoods()
					.then(
						function(response) {
						    $scope.favoriteFoods = response.data;
						    console.log(response);
						});
			    };

			    $scope.showCreateFavoriteFoodFunction = function() {
				$scope.showCreateFavoriteFood = true;
				$scope.showAddFavoriteFood = false;
			    };

			    $scope.addFavoriteFoodFunction = function() {
				$scope.animal.favoriteFood = $scope.selectedFavoriteFood;
			    };

			    $scope.createFavoriteFood = function() {

				favoriteFoodFactory
					.createFavoriteFood($scope.favoriteFood)
					.then(
						function(response) {
						    $scope.favoriteFoodMessage = "New create has been successfully added";
						});

			    };

			    $scope.createNewAnimal = function() {
				if ($scope.Animal !== "") {

				    animalFactory
					    .createAnimal($scope.animal)
					    .success(
						    function(response) {

							$scope.animalResponseMessage = "New Animal has been successfully added. To attach to a Enclosure Click 'Add Existing Animal' ";

						    })
					    .error(
						    function(response) {
							$scope.animalResponseMessage = "creation failed";
						    })
				}
				;

			    };

			    $scope.createNewEnclosure = function() {

				if ($scope.enclosure !== "") {
				    $scope.myTime = $scope.enclosure.feedingTime;
				    console.log($scope.myTime);
				    console.log($scope.enclosure.feedingTime);
				    enclosureFactory
					    .createEnclosure($scope.enclosure)
					    .success(
						    function(response) {
							$scope.enclosureMessage = "New create has been successfully added";
						    })
					    .error(
						    function(response) {
							$scope.enclosureMessage = "creation failed";
						    })
				}
				;

			    };

			} ]);
