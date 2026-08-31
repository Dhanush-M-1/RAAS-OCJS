var 
	r = readline().split(' '),
	a = +r[0],
	b = +r[1],
	result = a
;
while(a >= b){
	result += parseInt(a / b);
	a = a % b + parseInt(a / b);
}
print(result);