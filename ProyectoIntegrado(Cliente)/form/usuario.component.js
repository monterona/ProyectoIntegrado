(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .component('usuarioComponent', {
            templateUrl:  'templates/form/usuario.html',
            controller: 'UsuarioController',
            controllerAs: 'vm',
            require: {
                // access to the functionality of the parent component called 'formComponent'
                parent: '^formComponent'
            },
            bindings: {
                // send a changeset of 'formData' upwards to the parent component called 'formComponent'
                formData: '<'
            }
        })
})();