function calc(l, r, d) {
 if (d < l || d > r) {
   return d;
 }
 
 return d * Math.ceil(r / d) === r ? r + d : d * Math.ceil(r / d);
}

var q = parseInt(readline());
var lrd,l,r,d;

for (var i = 0; i< q; i++) {
  lrd = readline().split(" ");
  // print(lrd);
  l = parseInt(lrd[0]);
  r = parseInt(lrd[1]);
  d = parseInt(lrd[2]);
  
  print(calc(l, r, d));
}
