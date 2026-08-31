function main() {
	var x = new Array();
	x=readline().split(' ').map(Number);
	var ans = 0;
	for (var i=0; i<5; i++)
		ans+=x[i];
	if (ans%5===0 && ans!==0) print(ans/5);
	else print(-1);
}
main();