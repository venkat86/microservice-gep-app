app.controller("MenuCtrl", [ '$scope','$rootScope', '$location', '$window', 'authFactory',
                    function($scope,$rootScope, $location, $window, authFactory) {
    $scope.handle_url = function (url_name){
        var language = $window.navigator.language || $window.navigator.userLanguage;
        language_part1 = language.split("-")[0];
        console.log(url_name + '-' + language_part1);
        $location.path(url_name + '-' + language_part1);
    }
    $scope.user = authFactory.currentUser();
    if($scope.user){
      $scope.isLoggedIn = true;
      console.log('landing_page-en ' + authFactory.isAdmin());
      if(authFactory.isAdmin()){
        console.log('landing_page-en');
        $scope.isAdmin = true;
      }
      else{
        console.log('landing_page-no');
      }
    }
    else {
      $location.path('/');
    }
    ddmenu.init();
}]);
