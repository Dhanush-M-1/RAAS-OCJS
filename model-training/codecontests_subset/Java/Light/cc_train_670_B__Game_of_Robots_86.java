var nk = readline().split(' ').map(Number);
var n = nk[0];
var k = nk[1];
var id = readline().split(' ').map(Number);

var s = Math.floor(Math.sqrt(k * 2));
while ((s + 1) * s / 2 >= k)
    s--;

print(id[k - 1 - (s + 1) * s / 2]);