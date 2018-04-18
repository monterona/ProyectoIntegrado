(function () {
    'use strict';
 
    angular
        .module('proyectoIntegrado')
        .value('FormDataModel', FormDataModel);
 
    function FormDataModel() {
                
        //Datos alumno
        this.nombre = '';
        this.apellido1 = '';
        this.apellido2 = '';
        this.fecha_nac = '';
        this.direccion = '';
        this.localidad = '';
        this.cp = '';
        this.provincia = '';
        this.telefono = '';
        this.email = '';
        this.email2 = '';
        this.disponibilidad = '';
        this.observaciones = '';
        this.usuario = {};
        //Datos titulaciones
        this.redes = [];
        this.alumno_aptitudes = [];
        this.alumno_ot = [];
        this.alumno_ciclo = [];
    }
})();