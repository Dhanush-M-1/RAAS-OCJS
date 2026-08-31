a, b = [int(x) for x in input().split()]
ans = 0
while a >= b:
	a -= b - 1
	ans += b
print(ans + a)
