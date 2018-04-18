(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .controller('FormController', FormController);
 
    FormController.$inject = ['FormDataModel'];
 
    function FormController(FormDataModel) {
        var vm = this;
        vm.title = 'Multi-Step Wizard';
        vm.formData = new FormDataModel();
        vm.$onInit = activate;
        vm.getData = getData;
        
        ////////////////
 
        function activate() {
            console.log(vm.title + ' Cargado');
        }
 
        function getData() {
            return vm.formData;
        }
    }
})();