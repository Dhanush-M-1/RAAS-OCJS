var a = readline().split(" ");
for (j in a){
	a[j] = parseInt(a[j])
}
var sum = 0;
for (i = 0;i<5;i++){
	sum = sum + a[i];
}
if(sum%5==0){
	if (sum/5==0) print(-1);
	else print(sum/5);
}
else {print(-1);}