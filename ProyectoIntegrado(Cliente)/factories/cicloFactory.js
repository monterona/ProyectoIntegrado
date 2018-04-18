(function() {    
    angular.module('proyectoIntegrado')  
        .factory('CicloFactory', cicloFactory);     
    function cicloFactory($http){ 
        
        //var currentUsuario;
          
        var interfaz = {            
            //Metodos del servicio
            getCiclos: function(){
                return $http.get("http://localhost:8080/ciclos");
            },
            getAptitudes: function(){
                return $http.get("http://localhost:8080/aptitudes");
            },
            addAptitud: function(aptitud){
                return $http.post("http://localhost:8080/aptitud?aptitud="+aptitud);
            },
            getCentros: function(){
                return $http.get("http://localhost:8080/centros");
            }
        }
        return interfaz;
    }    
}())