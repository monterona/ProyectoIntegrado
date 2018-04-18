(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .controller('DireccionController', DireccionController);
 
    DireccionController.$inject = [];
 
    function DireccionController() {
        var vm = this;
        vm.title = 'Direccion';
        vm.formData = {};
        vm.$onInit = activate;
        
        function activate() {
            vm.formData = vm.parent.getData();
        }
    }
})();