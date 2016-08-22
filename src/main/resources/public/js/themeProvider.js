angular.module('Zookeeper').config(function($mdThemingProvider) {

    $mdThemingProvider.theme('default')

    .primaryPalette('orange', {
	'default' : '500',
	'hue-1' : '100',
	'hue-2' : '300'

    }).accentPalette('red', {
	'default' : '500',
	'hue-1' : '100',
	'hue-2' : '300'

    }).backgroundPalette('green', {

	'default' : '500',
	'hue-1' : '100',
	'hue-2' : '300'

    })
    
    .dark();
    
    
});