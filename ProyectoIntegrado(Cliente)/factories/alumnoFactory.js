(function() {    
    angular.module('proyectoIntegrado')  
        .factory('AlumnoFactory', alumnoFactory);     
    function alumnoFactory($http){ 
        
        //var currentUsuario;
          
        var interfaz = {            
            //Metodos del servicio
            createAlumno: function(alumno){
                return $http.post("http://localhost:8080/alumno",alumno);
            }
        }
        return interfaz;
    }    
}())