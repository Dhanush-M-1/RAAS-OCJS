var solve = function(n,m) {
  var res = 0;
  var b = 0;
  while (n > 0) {res ++; n--; b++; if (b == m) {n++; b = 0;}}
  return res;
}

var str = readline().split(' ');
var n = +str[0];
var m = +str[1];
print(solve(n,m));