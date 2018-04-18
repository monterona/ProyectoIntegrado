(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .controller('OtController', OtController);
 
    OtController.$inject = ['CicloFactory','$scope'];
 
    function OtController(cicloFactory,$scope) {
        var vm = this;
        vm.title = 'Otras Titulaciones';
        vm.formData = {};        
        vm.$onInit = activate;
        vm.centrosArray =[];
        vm.alumno_ot = null;
        
        function activate() {
            vm.formData = vm.parent.getData();
        }
        vm.init = function(){
            cicloFactory.getCentros()
                .then(function (response){
                vm.centrosArray = response.data;
            });
        }
        vm.addOt = function(){
            if(vm.alumno_ot != null){
                vm.formData.alumno_ot.push(vm.alumno_ot);
            }    
        }
        
        $scope.today = function() {
            vm.alumno_ot.annio_fin = new Date();
        };
        //$scope.today();

        $scope.clear = function() {
            vm.alumno_ot.annio_fin = null;
        };

        $scope.inlineOptions = {
            customClass: getDayClass,
            minDate: new Date(),
            showWeeks: true
        };

        $scope.dateOptions = {
            formatYear: 'yy',
            maxDate: new Date(2020, 5, 22),
            minDate: new Date(),
            startingDay: 1
        };

        $scope.toggleMin = function() {
            $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
            $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
        };

        $scope.toggleMin();

        $scope.open1 = function() {
            $scope.popup1.opened = true;
        };

        $scope.setDate = function(year, month, day) {
            vm.alumno_ot.annio_fin = new Date(year, month, day);
        };

        $scope.format = 'dd/MM/yyyy';
        $scope.altInputFormats = ['M!/d!/yyyy'];

        $scope.popup1 = {
            opened: false
        };

        var tomorrow = new Date();
        tomorrow.setDate(tomorrow.getDate() + 1);
        var afterTomorrow = new Date();
        afterTomorrow.setDate(tomorrow.getDate() + 1);
        $scope.events = [
            {
              date: tomorrow,
              status: 'full'
            },
            {
              date: afterTomorrow,
              status: 'partially'
            }
        ];

        function getDayClass(data) {
            var date = data.date,
            mode = data.mode;
            if (mode === 'day') {
                var dayToCheck = new Date(date).setHours(0,0,0,0);
                for (var i = 0; i < $scope.events.length; i++) {
                    var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

                    if (dayToCheck === currentDay) {
                        return $scope.events[i].status;
                    }
                }
            }
        return '';
      }
    }
})();