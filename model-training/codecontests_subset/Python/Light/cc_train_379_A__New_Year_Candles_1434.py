a, b = map(int, input().split())
sum = a
while a >= b:
	r = a//b
	sum += r	
	a = a//b + a%b
print(sum)