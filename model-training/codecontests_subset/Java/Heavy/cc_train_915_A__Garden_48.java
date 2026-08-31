
var vedraDlinnaSada = readline().split(' ');
//prompt("Enter kol veder i dlinna sada").split(' ');
var kolVeder = vedraDlinnaSada[0];
var dlinaSada = vedraDlinnaSada[1];


var otrezki = readline().split(' ');
//prompt("Enter otrezki").split(' ');
var maxdelitel = [];

for(i = 0; i <= otrezki.length; i++) {
    if(dlinaSada % otrezki[i] == 0) {
        maxdelitel.push(otrezki[i]);
        }
       // Array.max = function( maxdelitel ){
         //   return Math.max.apply( Math, maxdelitel );
        //};

        //var largest = Math.max.apply(Math, maxdelitel);
      //  Array.max = function( array ){
       //     return Math.max.apply( Math, array );
        //};
        
        //var bigestDigit = getMaxOfArray(maxdelitel);
}
var olo = Math.max.apply(null, maxdelitel);
//console.log(olo + " bigestDigit");
//alert(maxdelitel + "Max delitel");
//alert(maxdelitel);
var timeForPolitSad = dlinaSada / olo;
print(timeForPolitSad);
//alert(timeForPolitSad);