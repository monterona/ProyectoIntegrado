(function() {    
    angular.module('proyectoIntegrado')  
        .factory('alumnoDetalleFactory', alumnoDetalleFactory);     
    function alumnoDetalleFactory($http){ 
        
        //var currentUsuario;
          
        var interfaz = {            
            //Metodos del servicio
            getAlumno: function(id){
                return $http.get("http://localhost:8080/alumno/"+id);
            },
        }
        return interfaz;
    }    
}())