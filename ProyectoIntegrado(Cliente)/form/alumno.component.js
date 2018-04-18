(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .component('alumnoComponent', {
            templateUrl:  'templates/form/alumno.html',
            controller: 'AlumnoController',
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