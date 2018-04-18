(function() {
    
    angular.module('proyectoIntegrado')
        .controller('LoginController', loginController);
    
    function loginController(loginFactory,$state,$stateParams) {        
        var vm = this;
        vm.currentUsurio = loginFactory.getCurrentUsuario();
        
        vm.login = function () {
            if(!vm.usuario){
                vm.error = true;
                return vm.msgerror = "Introduzca usuario y contraseña";                    
            }
            loginFactory.login(vm.usuario)         
                .then(function (response) {
                    vm.error = false;
                    vm.msgerror = '';                   
                    vm.currentUsuario = response.data;                    
                    if(typeof(vm.currentUsuario.id) == "undefined"){
                        vm.error = true;
                        vm.msgerror = "Email o contraseña incorrecto";   
                    }else{
                        loginFactory.setCurrentUsuario(vm.currentUsuario);
                        if(vm.currentUsuario.rol_profesor==0){
                            loginFactory.loginAlumno(vm.currentUsuario.id);
                            //$state.go('alumnoDetalleForm',{alumnoid: vm.currentUsuario.id});    
                        }else{
                            $state.go('profesor');
                        }
                        
                    }
                }, function (response) {
                    vm.error = true;
                    vm.msgerror = response.data;                    
                });
                   
        };
        
        vm.logout = function () {
            loginFactory.logout();
        };
        
        vm.isLogged = function () {
            return loginFactory.isLogged();  
        };
        
        vm.registro = function (){
            $state.go('form.usuario');
        }
    }    
    
}());