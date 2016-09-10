app.controller("AplicationLevelCtrl", [ '$scope', '$rootScope', '$location', '$window', '$q', '$http', 'authFactory', 'RestURL', '$cookieStore',
				    function( $scope, $rootScope, $location, $window, $q, $http, authFactory, RestURL,$cookieStore) {
	// $http.get(RestURL.baseURL + '/user/getLoggedUser').success(function(response) {
	// 	if(response.username){
	// 		console.log('loggedIn');
	// 		authFactory.loggedIn = true;
	// 		$rootScope.user = response;
	// 		$location.path('/landing_page-en');
	// 	}
	// 	else{
	// 		$location.path('/login');
	// 	}
	// }).error(function(err) {
	// 	 alert('You got' + err + 'error');
	// });
	// $scope.$watch( authFactory.isLoggedIn, function ( isLoggedIn ) {
	// 	console.log('?>?');
	// 	console.log(isLoggedIn);
  //   $scope.isLoggedIn = isLoggedIn;
  //   $scope.currentUser = authFactory.currentUser();
  // });
	console.log('cookie' + $cookieStore.get('loggedIn'));
	if($cookieStore.get('loggedIn')){
		authFactory.getCurrentUser();
		$location.path('/landing_page-en');
	}
	else {
		$location.path('/login');
	}
}]);
