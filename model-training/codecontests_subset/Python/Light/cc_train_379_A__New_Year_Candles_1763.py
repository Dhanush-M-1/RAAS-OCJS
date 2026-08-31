a, b = [int(x) for x in input().split()]
sum = 0
i, j = a, 0
while i > 0:
	sum += i
	i, j = divmod(i + j, b)
print(sum)