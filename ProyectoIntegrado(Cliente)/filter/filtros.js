(function (){
    angular.module('proyectoIntegrado')
    .filter('filterSearch', function(){
        return function(text, cat, array){
            var arr = new Array();
            for(item in array){
                if(cat == "disponibilidad"){
                    if(text == "s" || text == "si"){
                        text=1;
                    }else if(text == "n" || text == "no"){
                        text=0;
                    }
                    if(array[item][cat]==text){
                        arr.push(array[item]);
                    }
                }else if(cat == "ciclo"){
                    var ciclo = array[item]["alumno_ciclo"];
                    for(i in ciclo){
                        if(ciclo[i]["ciclo"]["siglas"].indexOf(text.toUpperCase())!=-1){
                            arr.push(array[item]);
                        }
                    }
                }else if(cat == "edad"){
                    var annioActual = (new Date).getFullYear();
                    var annio = parseInt((array[item]["fecha_nac"]).substring(6, (array[item]["fecha_nac"]).length));
                    var edad = annioActual - annio;
                    if(text.length >= 2){
                        if(edad.toString()==text){
                        arr.push(array[item]);
                       }    
                    }else{
                        if((array[item][cat]).toLowerCase().indexOf(text)!=-1){
                            arr.push(array[item]);
                        }    
                    }
                }else if(cat == "aptitudes"){
                    var aptitudes = array[item]["alumno_aptitudes"];
                    for(i in aptitudes){
                        if(aptitudes[i]["aptitud"]["nombre"].toUpperCase().indexOf(text.toUpperCase())!=-1){
                            arr.push(array[item]);
                        }
                    }
                }else{
                    if((array[item][cat]).toLowerCase().indexOf(text)!=-1){
                        arr.push(array[item]);
                    }
                }
            }
            return arr;
        };
    })
    .filter('capitalize', function() {
        return function(input, all) {
          var reg = (all) ? /([^\W_]+[^\s-]*) */g : /([^\W_]+[^\s-]*)/;
          return (!!input) ? input.replace(reg, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();}) : '';
        }
    })
    .filter('startFromGrid', function() {
          return function(input, start) {
            start = +start;
            return input.slice(start);
          }
    });
    
}());