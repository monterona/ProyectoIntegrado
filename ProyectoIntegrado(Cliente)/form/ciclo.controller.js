(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .controller('CicloController', CicloController)
    
    CicloController.$inject = ['CicloFactory','$scope'];
 
    function CicloController(cicloFactory,$scope) {
        var vm = this;
        vm.$onInit = activate;
        vm.title = 'Titulación y Aptitudes';
        vm.formData = {};
        vm.ciclosArray =[];
        vm.aptitudArray =[];
        vm.ciclo = {};
        vm.aptitud = [];
        vm.aptitudAux = {};
        vm.nivelArray =["Alto","Medio","Bajo"];
        var search = '';
        vm.addAptitudes = {};
        var nuevaAptitud = {};
        
        function activate() {
            vm.formData = vm.parent.getData();
        }
        vm.init = function(){
            cicloFactory.getCiclos()
                .then(function (response){
                vm.ciclosArray = response.data;
            });
            cicloFactory.getAptitudes()
                .then(function (res){
                vm.aptitudArray = res.data;      
            });
        }
        $scope.$watch("vm.ciclo.annio_fin",function(newValue,oldValue) {
           var index = vm.formData.alumno_ciclo.indexOf(oldValue); 
            //hay que encontrar la foma de obtener el indice donde se encuentra el objeto
            vm.formData.alumno_ciclo.splice(index,1);
            if(typeof newValue === 'object'){
                vm.formData.alumno_ciclo.push(vm.ciclo);
            }
          });
        $scope.$watch("vm.aptitudAux.aptitud",function(newValue,oldValue) {
            if(typeof newValue === 'object'){
                //vm.formData.alumno_ciclo.push(vm.ciclo);
            }
            
          });
        $scope.$watch("vm.aptitudAux.nivel",function(newValue,oldValue) {
            if(typeof newValue === 'string'){
                if(newValue !=''){
                    vm.aptitud = vm.aptitudAux;
                    vm.formData.alumno_aptitudes.push(vm.aptitud);
                    vm.aptitudAux = undefined;
                }
            }
          });
        
        vm.addAptitud =function(){
            cicloFactory.addAptitud(search)
                .then(function (response){
                vm.aptitudArray.push(response.data);
                nuevaAptitud = response.data;
            });
            
        }
        vm.eliminarAptitud = function (dato) {
            var pos = vm.formData.alumno_aptitudes.indexOf(dato);
            vm.formData.alumno_aptitudes.splice(pos);
        }
        vm.p = function refreshResults($select){
            search = $select.search;
        }
            
        $scope.today = function() {
            vm.ciclo.annio_fin = new Date();
        };
        //$scope.today();

        $scope.clear = function() {
            vm.ciclo.annio_fin = null;
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
            vm.ciclo.annio_fin = new Date(year, month, day);
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