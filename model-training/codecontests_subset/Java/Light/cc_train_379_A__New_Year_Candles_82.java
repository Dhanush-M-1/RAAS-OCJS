var r = readline().split(' ');
var a = +r[0];
var b = +r[1];
var result = a;
while(a >= b){
	result += Math.floor(a / b);
	a = a % b + Math.floor(a / b);
}
print(result);