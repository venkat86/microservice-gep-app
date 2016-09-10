    app.factory('authFactory', ['$cookieStore','RestURL','$http','$cookieStore', function ($cookieStore,RestURL,$http,$cookieStore) {
      var currentUser;
      var isLoggedIn = false;
      var isAdmin = false;
      return {
        logout: function() {
          $location.path('/logout');
        },
        isLoggedIn: function() {
          return isLoggedIn;
        },
        isAdmin: function() {
          console.log(JSON.stringify(currentUser));
          currentUser.roles.forEach(function(entry) {
            if(entry.authority == 'GpAdmin'){
              console.log('ISADMIN!');
              isAdmin = true;
            }
          });
          return isAdmin;
        },
        currentUser: function() {
          return currentUser;
        },
        getCurrentUser: function() {
          $http.get(RestURL.baseURL + '/user/getLoggedUser').success(function(response) {
           if(response.username){
             console.log('user ' + response);
             currentUser = response;
             isLoggedIn = true;
             return currentUser;
           }
           $cookieStore.remove('loggedIn');
           isLoggedIn = false;
           return undefined;
         }).error(function(err) {
            alert('You got' + err + 'error');
            isLoggedIn = false;
            $cookieStore.remove('loggedIn');
            return undefined;
         });
        }
      };
    }])
;
