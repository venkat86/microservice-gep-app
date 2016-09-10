 	$(document).ready(function(){
 		alert("here")
 		var Node = function() {}
 		  gapi.drive.realtime.custom.registerType(  Node, 'nodeObj');
 		  // add all attributes
 		  Node.prototype.title = gapi.drive.realtime.custom.collaborativeField('title');
 		 Node.prototype.id = gapi.drive.realtime.custom.collaborativeField('author');
 		  Node.prototype.nodes = gapi.drive.realtime.custom.collaborativeField('nodes');
 		 
 		  var clientId = '486859968955-7ihg4qdnubnhjd5of6ugt9hssgo98v11.apps.googleusercontent.com';

 		  if (!/^([0-9])$/.test(clientId[0])) {
 			alert('Invalid Client ID - did you forget to insert your application Client ID?');
 		  }
 		  // Create a new instance of the realtime utility with your client ID.
 		  var realtimeUtils = new utils.RealtimeUtils({ clientId: clientId });
 		
 		  authorize();

 	  function authorize() {
 	    // Attempt to authorize
 		realtimeUtils.authorize(function(response){
 		  if(response.error){
 		    // Authorization failed because this is the first time the user has used your application,
 				// show the authorize button to prompt them to authorize manually.
 				var button = document.getElementById('auth_button');
 				button.classList.add('visible');
 				button.addEventListener('click', function () {
 					console.log("inside click")
 		          realtimeUtils.authorize(function(response){
 		        	  angular.element(domElement).scope().start();
 		          }, true);
 		        });
 		   } else {
 			   angular.element(domElement).scope().start();
 		      }
 		    }, false);
 	  }
 	});
	
app.controller('BasicExampleCtrl', ['$scope','authFactory','$location','RestURL', function ($scope,authFactory,$location,RestURL) {

  $scope.Check_List_Maintenance_Master = {
    id: '',
    name : '',
    description : '',
    work_flow_status : '',
    territory : '',
    check_list_version : '',
    version_date : '',
    approved_by : '',
    current_jason_state : '',
    questions : '',
    answer : ''
  };



      $scope.create = function () {
        var deferred = $q.defer();
        $http.post(RestURL + '/Check_List_Maintenance_Master_Default_Activity/create_Check_List_Maintenance_Master/', $scope.Check_List_Maintenance_Master).success(function(response) {
           alert('Operation SaveCheck_List_Maintenance_Master successful');
           deferred.resolve(response);
        }).error(function(err) {
           alert('You got' + err + 'error');
           deferred.reject(err);
        });
      };

      $scope.remove = function (scope) {
        scope.remove();
      };
      $scope.showText = function (scope) {
        console.log(scope)
        scope.enableText = true;
      };
      $scope.hideText = function (scope) {
        console.log(scope)
        scope.enableText = false;
      };
      $scope.saveAndHide = function (scope) {
        scope.hide();

      };

      $scope.toggle = function (scope) {
        scope.toggle();
      };

      $scope.moveLastToTheBeginning = function () {
        var a = $scope.data.pop();
        $scope.data.splice(0, 0, a);
      };

      $scope.newSubItem = function (scope) {
        var nodeData = scope.$modelValue;
        nodeData.nodes.push({
          id: nodeData.id * 10 + nodeData.nodes.length,
          title: nodeData.title + '.' + (nodeData.nodes.length + 1),
          nodes: []
        });
      };

      $scope.collapseAll = function () {
        $scope.$broadcast('angular-ui-tree:collapse-all');
      };

      $scope.expandAll = function () {
        $scope.$broadcast('angular-ui-tree:expand-all');
      };
      $scope.start = function(){
    	// scratch version
    	  // register and load 
    	  console.log("inside start")

    	    // With auth taken care of, load a file, or create one if there
    	    // is not an id in the URL.
    	    var id = realtimeUtils.getParam('id');
    	    if (id) {
    	      // Load the document id from the URL
    	      realtimeUtils.load(id.replace('/', ''), onFileLoaded, onFileInitialize);
    	    } else {
    	      // Create a new document, add it to the URL
    	      realtimeUtils.createRealtimeFile('New Quickstart File', function(createResponse) {
    	        window.history.pushState(null, null, '?id=' + createResponse.id);
    	        realtimeUtils.load(createResponse.id, onFileLoaded, onFileInitialize);
    	      });
    	    }

    	  // The first time a file is opened, it must be initialized with the
    	  // document structure. This function will add a collaborative string
    	  // to our model at the root.
    	  function onFileInitialize(model) {
    	    var list = model.create('nodeObj');
    	    //string.setText('Welcome to the Quickstart App!');
    	    model.getRoot().set('nodeObj', $scope.data);
    	    // list values
    	  	var onValueAdded = function(event) {
    	   	  console.log("Items added", event.values);
    	   	};

    	   	var doValueChanged = function(event) {
      	   	  console.log("Items changes", event.values);
      	   	};
      	   	
    	   	//var list = model.createList();
    	   	list.addEventListener(gapi.drive.realtime.EventType.VALUES_ADDED, onValueAdded);

    	   	list.addEventListener(gapi.drive.realtime.EventType.VALUE_CHANGED, doValueChanged);
    	   	console.log("Adding tree nides 1");
    	   	//list.push();
    	   	
    	   /* 	model.beginCompoundOperation();
    	   	var list = model.createList();
    	   	list.push("Hello");
    	   	list.push("World");
    	   	model.endCompoundOperation(); */
    	   	
    	  }



    	  // After a file has been initialized and loaded, we can access the
    	  // document. We will wire up the data model to the UI.
    	  function onFileLoaded(doc) {
    	    var collaborativeString = doc.getModel().getRoot().get('nodeObj');
    	    //wireTextBoxes(collaborativeString);
    	  }

    	  // Connects the text boxes to the collaborative string
    	  function wireTextBoxes(collaborativeString) {
    	    var textArea1 = document.getElementById('text_area_1');
    	    var textArea2 = document.getElementById('text_area_2');
    	    gapi.drive.realtime.databinding.bindString(collaborativeString, textArea1);
    	    gapi.drive.realtime.databinding.bindString(collaborativeString, textArea2);
    	  }
    	  
    	  
    	  
    	  
    	  
      };
      
      $scope.data = [{
        'id': 1,
        'title': 'node1',
        'nodes': [
          {
            'id': 11,
            'title': 'node1.1',
            'nodes': [
              {
                'id': 111,
                'title': 'node1.1.1',
                'nodes': []
              }
            ]
          },
          {
            'id': 12,
            'title': 'node1.2',
            'nodes': []
          }
        ]
      }, {
        'id': 2,
        'title': 'node2',
        'nodrop': true, // An arbitrary property to check in custom template for nodrop-enabled
        'nodes': [
          {
            'id': 21,
            'title': 'node2.1',
            'nodes': []
          },
          {
            'id': 22,
            'title': 'node2.2',
            'nodes': []
          }
        ]
      }, {
        'id': 3,
        'title': 'node3',
        'nodes': [
          {
            'id': 31,
            'title': 'node3.1',
            'nodes': []
          }
        ]
      }];
    }]);

