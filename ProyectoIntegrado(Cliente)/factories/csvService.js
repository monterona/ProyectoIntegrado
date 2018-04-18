(function() {    
    angular.module('proyectoIntegrado')  
        .factory('csvService', csvService);     
    function csvService(){ 
        var interfaz = {            
            createCsv: function(alumnos){
                var myData = [];
                alumnos.forEach(function(obj) {
                    var redes = [];
                    var ciclo = [];
                    var aptitudes = [];
                    if(obj.disponibilidad == 0){
                        obj.disponibilidad = 'No'; 
                    }else{
                        obj.disponibilidad = 'Si';
                    }
                    obj.redes.forEach(function (obj){
                       redes.push(obj.link);
                    });
                    obj.alumno_ciclo.forEach(function (obj){
                       ciclo.push(obj.ciclo.siglas);
                       ciclo.push(obj.ciclo.nombre);
                       ciclo.push(obj.annio_fin);
                    });
                    obj.alumno_aptitudes.forEach(function (obj){
                        aptitudes.push(obj.aptitud.nombre);
                        aptitudes.push(obj.nivel);
                    });
                    myData.push(
                        {
                            nombre: obj.nombre,
                            apellido1: obj.apellido1,
                            apellido2: obj.apellido2,
                            fecha_nac: obj.fecha_nac,
                            direccion: obj.direccion,
                            localidad: obj.localidad,
                            cp: obj.cp,
                            provincia: obj.provincia,
                            telefono: obj.telefono,
                            email: obj.email,
                            email2: obj.email2,
                            disponibilidad: obj.disponibilidad,
                            observaciones: obj.observaciones,
                            usuario: obj.usuario.usuario,
                            contrasena: obj.usuario.contrasena,
                            redes: redes.toString().replace(",","|"),
                            ciclo: ciclo.toString().replace(",","|"),
                            aptitudes: aptitudes.toString().replace(",","|")
                        }
                    );
                });
                return myData;
            },
            headerCsv: function(){
                var header = ["Nombre","Primer Apellido","Segundo Apellido","Fecha Nacimiento","Direccion","Localidad","Codigo postal","Provincia","Telefono","Email","Email opcional","Disponibilidad","Observaciones","Usuario","Contraseña","Redes Sociales","Ciclo Cursado","Aptitudes"];
                return header;
            }
        }
        return interfaz;
    }    
}())