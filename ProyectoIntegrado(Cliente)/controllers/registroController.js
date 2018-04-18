(function() {
    
    angular.module('proyectoIntegrado')
        .controller('RegistroController', registroController);
    
    function registroController(alumnoDetalleFactory,$state,$stateParams) {        
        var vm = this;
        vm.labelButton="Enviar";
          
        };    
    
}());