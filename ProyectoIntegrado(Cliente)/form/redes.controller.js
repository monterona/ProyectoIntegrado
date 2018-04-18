(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .controller('RedesController', RedesController);
 
    RedesController.$inject = [];
 
    function RedesController() {
        var vm = this;
        vm.title = 'Redes Sociales';
        vm.formData = {};
        vm.$onInit = activate;

        function activate() {
            vm.formData = vm.parent.getData();
        }

        vm.agregarRed = function () {
            if (vm.nuevaRed != null)
                vm.formData.redes.push({link: vm.nuevaRed});
                vm.nuevaRed = null;
        };

        vm.eliminarRed = function (dato) {
            var pos = vm.formData.redes.indexOf(dato);
            vm.formData.redes.splice(pos);
        }

    }
})();