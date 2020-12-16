var app = angular.module('app-encuesta', [ "ngResource" ]);

app.controller('encuestaRestController', [ '$scope', '$http',
	function($scope, $http) {
		$scope.getIndex = function() {
			$http.get('/index').success(function(data) {
				$scope.encuestas = data;	
				$scope.ver = 0;	
			});
			
		}

		$scope.getAllProducto = function() {
			$http.get('/producto').success(function(data) {
				$scope.listaResumen = data;		
			});
		}
		
		$scope.postRegistroEncuesta = function() {
			$http.post('/registroencuesta', 
				{
					mail : $scope.mail,
					glosaopcion : $scope.glosaopcion,
				}
			).success(function(data) {
				$scope.mensaje = data;
				$scope.ver = 1;	
				if ( data.substr(1,1) == "r") {
					$scope.ver = 2;	
				}
				$scope.getAllProducto();
			}).error(function(data) {
				$scope.mensaje = data;
				$scope.ver = 2;		
				$scope.getAllProducto();
			});
			
		}
} ]);