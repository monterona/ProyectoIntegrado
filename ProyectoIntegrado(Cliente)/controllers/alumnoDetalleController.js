(function() {
    
    angular.module('proyectoIntegrado')
        .controller('AlumnoDetalleController', alumnoDetalleController);
    
    function alumnoDetalleController(alumnoDetalleFactory,$state,$stateParams) {        
        var vm = this;
        
        alumnoDetalleFactory.getAlumno($stateParams.alumnoid)
            .then(function (response){
                vm.alumno = response.data;
            });
          
        };    
    
}());