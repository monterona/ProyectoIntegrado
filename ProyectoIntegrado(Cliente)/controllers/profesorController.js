(function() {
    
    angular.module('proyectoIntegrado')
        .controller('ProfesorController', profesorController);
    
    function profesorController(profesorFactory,loginFactory,$filter,$scope,csvService,ngDialog) {        
        var vm = this;
        vm.currentUsurio = loginFactory.getCurrentUsuario();
        vm.email = {};
        $scope.currentPage = 0;
        $scope.pageSize = 4;
        $scope.pages = [];
        vm.pages = [5,8,10];
        vm.cargando = false;

        vm.init = function(){
            vm.cargando = true;
            profesorFactory.getAlumnos()
                    .then(function (response){
                    vm.alumnos = response.data;
                    vm.selectFilter = "Nombre";
                    vm.text = null;
                    vm.filter = ["Nombre","Disponibilidad", "Ciclo","Aptitudes","Edad"];
                    vm.alumnos2 = vm.alumnos;
                });
        }
        vm.logout = function(){
            loginFactory.logout();
        }
        $scope.$watch('vm.text', function() {
            if(vm.text == null || vm.text == ""){
                vm.alumnos = vm.alumnos2;
            }else{
                vm.alumnos = $filter('filterSearch')(vm.text.toLowerCase(), vm.selectFilter.toLowerCase(), vm.alumnos2);
            }
        });
        
        $scope.$watch('vm.selectFilter', function() {
            if(vm.text == null || vm.text == ""){
                vm.alumnos = vm.alumnos2;
            }else{
                vm.alumnos = $filter('filterSearch')(vm.text.toLowerCase(), vm.selectFilter.toLowerCase(), vm.alumnos2);
            }
        });
        vm.alerts = [
            { type: 'danger', msg: 'No se han encontrado registros con esos parámetros' },
        ];

        vm.closeAlert = function(index) {
            vm.alerts.splice(index, 1);
        };
        vm.getDataForCsv = function() {
            return csvService.createCsv(vm.alumnos);
        };
        vm.headerCsv = csvService.headerCsv();
        
        vm.modal = function (nombre) {
            $scope.nombre = nombre;
            vm.email.toEmail = $scope.nombre;
            ngDialog.open({ 
                template: 'myModalEmail.html',
                className: 'ngdialog-theme-default' ,
                scope: $scope
            });
        };
        
        vm.emailOk = function () {
            ngDialog.open({ 
                template: 'emailOk.html',
                className: 'ngdialog-theme-default'
            });
        };
        
        vm.ok = function () {
            profesorFactory.enviarEmail(vm.email)
                    .then(function (response){
                        vm.emailOk();
                    })
                    .catch(function (error){
                        vm.emailOk();
                    });
        };
        
        $scope.configPages = function() {
        $scope.pages.length = 0;
        var ini = $scope.currentPage - 4;
        var fin = $scope.currentPage + 5;
        if (ini < 1) {
            ini = 1;
            if (Math.ceil(vm.alumnos.length / $scope.pageSize) > 10)
                fin = 10;
            else
                fin = Math.ceil(vm.alumnos.length / $scope.pageSize);
        } else {
            if (ini >= Math.ceil(vm.alumnos.length / $scope.pageSize) - 10) {
                ini = Math.ceil(vm.alumnos.length / $scope.pageSize) - 10;
                fin = Math.ceil(vm.alumnos.length / $scope.pageSize);
            }
        }
        if (ini < 1) ini = 1;
            for (var i = ini; i <= fin; i++) {
                $scope.pages.push({
                    no: i
                });
            }
        if ($scope.currentPage >= $scope.pages.length)
            $scope.currentPage = $scope.pages.length - 1;
        };

        $scope.setPage = function(index) {
            $scope.currentPage = index - 1;
        };
    }
}());