var 
	r = readline().split(' '),
	a = +r[0],
	b = +r[1],
	result = a
;
while(a >= b){
	var new_value = Math.floor(a / b); 
	result += new_value;
	a = a % b + new_value;
}
print(result);