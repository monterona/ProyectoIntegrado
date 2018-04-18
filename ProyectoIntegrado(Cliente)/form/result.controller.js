(function () {
    'use strict';
    angular
        .module('proyectoIntegrado')
        .controller('ResultController', ResultController);
 
    ResultController.$inject = ['AlumnoFactory','ngDialog','$scope','$state','$stateParams'];
 
    function ResultController(alumnoFactory,ngDialog,$scope,$state,$stateParams) {
        var vm = this;
        vm.title = 'Fin del Registro del Alumno';
        vm.formData = {};
        vm.boton = "Enviar"
        
        vm.$onInit = activate;

        ////////////////

        function activate() {
            vm.formData = vm.parent.getData();
            console.log('Result feature loaded!');
        }
        
        vm.modalOK = function () {
            ngDialog.open({ template: 'myModalContent.html', className: 'ngdialog-theme-default' });
        };
        
        vm.modalKO = function () {
            ngDialog.open({ template: 'myModalContentKO.html', className: 'ngdialog-theme-default' });
        };
        
        vm.enviar = function(){
            if(vm.boton != "Enviar"){
                $state.go('login');      
            }else{
                vm.boton = "Volver";
                if(vm.formData.fecha_nac){
                    vm.formData.fecha_nac = vm.formData.fecha_nac.getMonth() + 1 + "/" + vm.formData.fecha_nac.getDate() + "/" + vm.formData.fecha_nac.getFullYear(); 
                    var alumno = vm.formData;
                    alumnoFactory.createAlumno(alumno)
                        .then(function (response){
                            var p = response;
                            vm.modalOK();
                    })
                    .catch (function(error){
                        vm.modalKO();
                    });    
                }else{
                    vm.modalKO();
                }

            }                
        }
    }
})();
