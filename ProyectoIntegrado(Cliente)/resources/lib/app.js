(function() {

    var proyectoIntegradoApp = angular.module("proyectoIntegrado",['ui.router',"ngSanitize", "ngCsv", "ngAnimate", "ui.bootstrap",'ui.select','ngDialog','ngCookies']);
    proyectoIntegradoApp.config(function($stateProvider,$urlRouterProvider){
        
        $urlRouterProvider.otherwise("login");
        
        $stateProvider
            .state('login',{
                url: "/login"    ,
                templateUrl: "templates/login.html",
                controller: 'LoginController',
                controllerAs: 'vm'
            })
            .state('alumnos',{
                url: "/alumnos"    ,
                templateUrl: "templates/alumnos.html",
                controller: 'AlumnoController',
                controllerAs: 'vm'
            })
            .state('profesor',{
                url: "/profesor"    ,
                templateUrl: "templates/profesor.html",
                controller: 'ProfesorController',
                controllerAs: 'vm'
            })
            .state('registroAlumno',{
                url: "/registroAlumno"    ,
                templateUrl: "templates/registroAlumno.html",
                controller: 'RegistroController',
                controllerAs: 'vm'
            })
            .state('alumnoDetalle',{
                url: "/alumnoDetalle:alumnoid"    ,
                templateUrl: "templates/alumnoDetalle.html",
                controller: 'AlumnoDetalleController',
                controllerAs: 'vm'
            })
            .state('alumnoDetalleForm',{
                url: "/alumnoDetalleForm"    ,
                params: {
                    alumno: null,
                },
                templateUrl: "templates/alumnoDetalleForm.html",
                controller: 'AlumnoDetalleFormController',
                controllerAs: 'vm'
            })
        
            // Formulario por pasos
            .state('form', {
                url: '/form',
                component: 'formComponent'
            })

            .state('form.usuario', {
                url: '/usuario',
                component: 'usuarioComponent'
            })
            .state('form.alumno', {
                url: '/alumno',
                component: 'alumnoComponent'
            })
        
            .state('form.ciclo', {
                url: '/ciclo',
                component: 'cicloComponent'
            })

            .state('form.direccion', {
                url: '/direccion',
                component: 'direccionComponent'
            })
            .state('form.ot', {
                url: '/ot',
                component: 'otComponent'
            })
        
            .state('form.redes', {
                url: '/redes',
                component: 'redesComponent'
            })

            .state('form.result', {
                url: '/result',
                component: 'resultComponent'
            })
    });
    
}())
