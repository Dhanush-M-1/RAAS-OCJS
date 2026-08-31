var n = +readline();
var s = readline().split('').sort();
s.push('0');
var k = 1;
var ans = [];
var anst = [];
for (var i=0; i<s.length-1; i++) {
	if (s[i] == s[i+1]) {
		k++;
	} else if (k%n == 0) {
		for (var j=0; j<k/n; j++) ans.push(s[i]);
		k = 1;
	} else {
		print(-1);
		k = -1;
		break;
	}
}
if (k != -1) {
	for (var j=0; j<n; j++) anst = anst.concat(ans);
	print (anst.join(''));
	}