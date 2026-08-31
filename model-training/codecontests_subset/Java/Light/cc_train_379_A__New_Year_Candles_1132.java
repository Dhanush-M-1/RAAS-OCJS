var params = readline().split(" ").map(value => +value);
var a = params[0], b = params[1];
var hours = a, period = b, temp;

while(a >= 1) {
	temp = (a - a % b) / b;
	hours += temp;
	a = temp + (temp > 0) * (a % b);
}

print(hours);