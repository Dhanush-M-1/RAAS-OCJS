var n = readline();
n = Number(n);

for(var i=0; i<n; i++){
	var lrd = readline().split(' ').map(Number);
	var l = lrd[0];
	var r = lrd[1];
	var d = lrd[2];
	if (d < l) print (d);
	else if (r%d != 0) print (Math.ceil(r/d)*d);
	else print ((r/d+1)*d);
}