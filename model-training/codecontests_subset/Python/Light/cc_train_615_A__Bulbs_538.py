n, m = [int(x) for x in input().split()]
lights = [1] * m
for i in range(n):
	a = input()
	if a[0] != '0':
		n = a.find(' ')
		for j in [int(x) for x in a[n+1:].split()]:
			lights[j-1] = 0
if sum(lights) == 0:
	print('YES')
else:
	print('NO')