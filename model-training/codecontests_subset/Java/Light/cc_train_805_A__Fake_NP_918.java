var num = readline().split(' ');
var l = parseInt(num[0]);
var r = parseInt(num[1]);
if(r > l){
	print(2);
}else if(r == l){
	print(l);
}