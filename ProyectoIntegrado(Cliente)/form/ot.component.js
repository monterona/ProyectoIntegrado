(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .component('otComponent', {
            templateUrl:  'templates/form/ot.html',
            controller: 'OtController',
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