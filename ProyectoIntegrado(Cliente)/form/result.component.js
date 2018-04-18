(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .component('resultComponent', {
            templateUrl:  'templates/form/result.html',
            controller: 'ResultController',
            controllerAs: 'vm',
            require: {
                // access to the functionality of the parent component called 'formComponent'
                parent: '^formComponent'
            }
        })
})();