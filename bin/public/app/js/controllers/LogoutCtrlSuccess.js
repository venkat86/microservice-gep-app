app.controller('LogoutCtrlSuccess', ['Facebook','$modal','$log', '$scope', '$http', '$location', '$cookieStore', 'RestURL','authFactory',
    function (Facebook,$modal, $log, $scope, $http, $location, $cookieStore, RestURL,authFactory) {

        var self = $scope;
        $cookieStore.put('loggedIn',false);
        $location.path('/');
    }]);
