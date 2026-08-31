function Main() {
  var A = Number(readline());
  for(var i=0;i<A;i++){
    var n = Number(readline());
    print(Math.sin((Math.PI*(n-1/2))/(2*n))/(Math.sin(Math.PI/(2*n))));
  }
}
Main();