(function() {    
    angular.module('proyectoIntegrado')  
        .factory('authFactory', authFactory);     
    function authFactory($cookies,$cookieStore,$state){ 
        return{
            login : function(usuario, contrasena)
            {
                //creamos la cookie con el nombre que nos han pasado
                $cookies.username = usuario,
                $cookies.password = contrasena;
                //mandamos a la home
                $state.go('profesor');
            },
            logout : function()
            {
                //al hacer logout eliminamos la cookie con $cookieStore.remove
                $cookieStore.remove("username"),
                $cookieStore.remove("password");
                //mandamos al login
                $location.path("/login");
            },
            checkStatus : function()
            {
                //creamos un array con las rutas que queremos controlar
                var rutasPrivadas = ["/alumnoDetalle","/profesor","/login"];
                if(this.in_array($state.go(),rutasPrivadas) && typeof($cookies.username) == "undefined")
                {
                    $state.go("/login");
                }
                //en el caso de que intente acceder al login y ya haya iniciado sesión lo mandamos a la home
                if(this.in_array("/login",rutasPrivadas) && typeof($cookies.username) != "undefined")
                {
                    $state.go("/profesor");
                }
            },
            in_array : function(needle, haystack)
            {
                var key = '';
                for(key in haystack)
                {
                    if(haystack[key] == needle)
                    {
                        return true;
                    }
                }
                return false;
            }
        }
    }    
}())