(function() {    
    angular.module('proyectoIntegrado')  
        .factory('profesorFactory', profesorFactory);     
    function profesorFactory($http){ 
        
        //var currentUsuario;
          
        var interfaz = {            
            //Metodos del servicio
            getAlumnos: function(){
                return $http.get("http://localhost:8080/alumnos");
            },
            enviarEmail: function(email){
                return $http.post("http://localhost:8080/enviarEmail",email);
            }
        }
        return interfaz;
    }    
}())