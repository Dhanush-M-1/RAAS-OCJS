(a, b), total = list(map(int, input().split())), 0
while a >= b:
	total += a - a % b
	a = a//b + a % b
print(a+total)
