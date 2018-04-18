(function() {
    
    angular.module('proyectoIntegrado')
        .controller('AlumnoDetalleFormController', alumnoDetalleFormController);
    
    function alumnoDetalleFormController($state,$stateParams) {        
        var vm = this;
        if($stateParams != null){
            vm.alumno = $stateParams.alumno;
        }
    }
}());