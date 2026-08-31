
var min = Math.min;
var max = Math.max;

var each = function (a, f) {
	Array.apply(null, Array(a)).map(function (a, i) {return i;}).map(f);
}

var n = +readline();
var g = [];
var ans = 0;

each(n, function (i) {
	g.push(readline().split(' '));
});

each(n, function (i) {
	each(n, function (j) {
		each(n, function (k){
			g[j][k] = min(+g[j][k], +g[j][i] + g[i][k]);
		});
	});
});

each(n, function (i) { 
	each(n, function (j) {
		ans = max(ans, +g[i][j]);
	});
});

print(ans);