(function() {    
    angular.module('proyectoIntegrado')  
        .factory('loginFactory', loginFactory);     
    function loginFactory($http,$cookies,$cookieStore,$state){ 
        
        //$cookies.username = "undefined"
          
        var interfaz = {            
    
            login: function(usuario){
                return $http.post("http://localhost:8080/login",usuario);
            },
            logout: function(){
                $cookieStore.remove("username");
                $state.go('login');
            },
            isLogged: function(){
                return typeof($cookies.get('username')) !== "undefined"
            },
            loginAlumno: function(id){
                $http.get("http://localhost:8080/alumnoUsuario/"+id)
                    .then(function (response) {
                    $state.go('alumnoDetalleForm',{"alumno":response.data});    
                });
            },
            setCurrentUsuario: function(usuario){
                $cookies.put('username', usuario.usuario);
            },
            getCurrentUsuario: function(){
                return $cookies.get('username');
            },
        }
        return interfaz;
    }    
}())