/**
 *
 * @author Schubert Generated Code</br>
 * Date Created: </br>
 * @since  </br>
   build:   </p>
 *
 * code was generated by the Schubert System </br>
 * Schubert system Copyright - NewPortBay LLC copy_right_range</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/

app.controller("In_flight_checklists_Default_Activity", [ '$scope', '$rootScope', '$location', '$window', '$q', '$http',
				    function( $scope, $rootScope, $location, $window, $q, $http) {

		$scope.In_flight_checklists = {
		id: '',
		status : '', 
		collaborators : '', 
		answers : ''
		};



        $scope.create = function () {

		  //this is where the start code goes


		  //this is where the validate code goes


		  //this is where the post code goes
		  var deferred = $q.defer();
		  $http.post('http://52.91.209.209:44168/AdcDataModelTest_10030/In_flight_checklists_Default_Activity/create_In_flight_checklists/', $scope.In_flight_checklists).success(function(response) {
		  	 alert('Operation SaveIn_flight_checklists successful');
		  	 deferred.resolve(response);
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  	 deferred.reject(err);
		  });

		  //this is where the server response code goes


		  //this is where the transition code goes

		  //this is where the end code goes 



        };




		$scope.$on('$viewContentLoaded', function(event) {
			var biggestHeight = 0;
			var height = 0;
			$(".screen").find('*').each(function(){
				height = $(this).position().top + $(this).height() + 100;
				if (height > biggestHeight ) {
					biggestHeight = height;
				}
			});
			$(".screen").height(biggestHeight);
		});

}]);


