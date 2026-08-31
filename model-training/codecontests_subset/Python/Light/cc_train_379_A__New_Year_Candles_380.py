import math
a, b = [int(x) for x in input().split()]

total = a
while a >= b:
	total += math.floor(a/b)
	a = math.floor(a/b) + a%b
print(total)