angular.module("Zookeeper").controller(
	"indexCtrl",
	[
		'$scope',
		'$location',
		'$log',
		function($scope, $location, $log) {

		    $scope.selectedIndex = 0;

		    $scope.$watch('selectedIndex', function(current, old) {
			switch (current) {
			case 0:
			    $location.url("/log");
			    break;
			case 1:
			    $location.url("/create");
			    break;
			case 2:
			    $location.url("/update");
			    break;
			case 3:
			    $location.url("/delete");
			    break;
			}
		    });

//		    $scope.next = function() {
//			$scope.selectedIndex = Math.min(
//				$scope.selectedIndex + 1, 2);
//		    };
//		    $scope.previous = function() {
//			$scope.selectedIndex = Math.max(
//				$scope.selectedIndex - 1, 0);
//		    };

		} ]);