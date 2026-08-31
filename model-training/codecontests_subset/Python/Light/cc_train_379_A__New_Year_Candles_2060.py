a, b = [int(a) for a in input().split()]
i = 0
used = 0
while a > 0:
	a -= 1
	used += 1
	i += 1
	if used % b == 0:
		a += 1
print(i)