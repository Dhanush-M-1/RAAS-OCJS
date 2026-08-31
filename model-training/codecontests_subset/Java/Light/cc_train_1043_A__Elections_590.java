
var n = parseInt(readline());
var a = readline().split(" ").map(function(x) { return parseInt(x); });

var max = Math.max.apply(Math, a);
var sum = a.reduce(function(a, b) { return a + b; }, 0);
var all = n*max;

if (all-sum>sum) {
  print(max);
} else {
  var res = Math.floor(sum*2/n+1);
  if (n*(res-1)-sum>sum) { res=res-1; }

  if (n*res-sum>sum) {
    print(res);
  } else {
    print(res+1);
  }
}
