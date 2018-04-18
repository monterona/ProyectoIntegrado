(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .component('redesComponent', {
            templateUrl:  'templates/form/redes.html',
            controller: 'RedesController',
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