var qq = readline().split(" ").map(function(x) { return parseInt(x); });
//var numbers = prompt("Enter data: ").split(" ").map(function(x) { return parseInt(x); });   // Chrome run

var n = qq[0];
var matr = Array(n).fill([]);

for (var i=0; i<n; i++) {
	qq = readline();
	var ar = Array(n).fill(0);
	for (var j=0; j<Math.floor(n/4); j++) {
		var x = qq[j];
		if (x >= '0' && x <= '9')
			var val = parseInt(x);
		else
			var val = parseInt(x, 36) - parseInt('A', 36) + 10;
		for (var k=0; k<4; k++)
			ar[j*4+k] = (val>>(3-k)) & 1;
	}
	matr[i] = ar;
}

function def(x,y,dx,dy) {
	var value = matr[x][y];
	x += dx;
	y += dy;
	var MXX = 1;
	while (x >= 0 && x < n && y >= 0 && y < n) {
		var xx = x, yy = y;
		var Ok = true;
		while (xx >= 0 && xx < n && yy >= 0 && yy < n) {
			if (matr[xx][yy] !== value) {
				Ok = false;
				break;
			}
			xx -= dx;
		}
		xx = x; yy = y;
		while (Ok && xx >= 0 && xx < n && yy >= 0 && yy < n) {
			if (matr[xx][yy] !== value) {
				Ok = false;
				break;
			}
			yy -= dy;
		}
		if (Ok === false)
			return MXX;
		MXX++;
		x += dx;
		y += dy;
	}
	return n;
}

var qw = def(0,0,+1,+1);
qw = Math.min(qw, def(n-1,n-1,-1,-1));
qw = Math.min(qw, def(0,n-1,+1,-1));
qw = Math.min(qw, def(n-1,0,-1,+1));

for (var i=1; i<n; i++) matr[0][i] += matr[0][i-1];
for (var i=1; i<n; i++) matr[i][0] += matr[i-1][0];
for (var i=1; i<n; i++)
	for (var j=1; j<n; j++)
		matr[i][j] = matr[i][j] + matr[i-1][j] + matr[i][j-1] - matr[i-1][j-1];

var fnd = 0;
for (var x=qw; x>=1; x--)
	if (n % x === 0) {
		var Ok = true;
		var EE = Math.floor(n/x);
		for (var i=0; i<EE; i++)
			for (var j=0; j<EE; j++) {
				var x1 = i*x;
				var y1 = j*x;
				var x2 = x1 + x-1;
				var y2 = y1 + x-1;
				var res = matr[x2][y2];
				if (x1 > 0)
					res -= matr[x1-1][y2];
				if (y1 > 0)
					res -= matr[x2][y1-1];
				if (x1 > 0 && y1 > 0)
					res += matr[x1-1][y1-1];

				if (!((res === 0) || (res === x*x))) {
					Ok = false;
					break;
				}
			}

		/*for (var i=0; i<n && Ok; i++)
			for (var j=0; j<n && Ok; j++)
				if (matr[i][j] !== matr[Math.floor(i/x)*x][Math.floor(j/x)*x]) {
					Ok = false;
					break;
				}*/
				
		if (Ok) {
			fnd = 1;
			write(x);
			break;
		}
	}
if (fnd === 0) write("0");

 /*write("\n\n");
 for (var i=0; i<n; i++) {
     for (var j=0; j<n; j++)
              write(matr[i][j]);
     write("\n");
 }*/
