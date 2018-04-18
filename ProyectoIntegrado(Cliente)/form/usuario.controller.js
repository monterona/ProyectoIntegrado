(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .controller('UsuarioController', UsuarioController);
 
    UsuarioController.$inject = [];
 
    function UsuarioController() {
        var vm = this;
        vm.title = 'Registro de Usuario';
        vm.formData = {};
        vm.$onInit = activate;
        
        ////////////////

        function activate() {
            // get data from the parent component
            vm.formData = vm.parent.getData();
            console.log('Usuario feature loaded!');
        }

    }
})();
