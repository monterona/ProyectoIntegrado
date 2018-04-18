(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .component('formComponent', {
            templateUrl:  'templates/form/form.html',
            controller: 'FormController',
            controllerAs: 'vm'
        })
})();