angular.module('Zookeeper').config(
	['$stateProvider', '$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {
		    
	    
	    $urlRouterProvider.otherwise('/log');

		    $stateProvider.state('log', {
			url : '/log',
			templateUrl : 'html/templates/logPage.tpl.html',
			controller : 'logCtrl'
			onEnter: function() {console.log("/html/template/logPage.tpl.html")};

		    });

		    $stateProvider.state('create', {
			url : '/create',
			templateUrl : 'html/templates/createPage.tpl.html',
			controller : 'createCtrl'

		    });

		    $stateProvider.state('update', {
			url : '/update',
			templateUrl : 'html/templates/updatePage.tpl.html',
			controller : 'updateCtrl'

		    });

		    $stateProvider.state('delete', {
			url : '/delete',
			templateUrl : 'html/templates/deletePage.tpl.html',
			controller : 'deleteCtrl'

		    });
		    
		    
//		    $scope.selectedIndex = 0;
//
//		    $scope.$watch('selectedIndex', function(current, old) {
//			switch (current) {
//			case 0:
//			    $state.go("/log");
//			    break;
//			case 1:
//			    $state.go("/create");
//			    break;
//			case 2:
//			    $state.go("/update");
//			    break;
//			case 3:
//			    $state.go("/delete");
//			    break;
//			}
//		    });
		    

		} ]);