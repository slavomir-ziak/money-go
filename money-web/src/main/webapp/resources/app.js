
var app = angular.module('money-go', ['ngResource']);

app.factory('NoncategorisedBankTransactions', [
	'$resource',
	function($resource){
		return $resource('../NoncategorisedBankTransactions/', {}, {
			get: {method:'GET', params:{}, isArray:true}
		});
	}
]);

app.controller('MoneyGoCtrl', [
	'$scope', 'NoncategorisedBankTransactions',
	function($scope, NoncategorisedBankTransactions) {

		$scope.NoncategorisedBankTransactions = NoncategorisedBankTransactions.get();
		$scope.currentSection = "nonCategorized";

		$scope.showSection = function(section) {
			$scope.currentSection = section;
			$scope["show" + section] && $scope["show" + section]();
		};


		// debug sendResults();
	}
]);


