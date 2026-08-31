a = [i for i in input().split()]
n = int(input())

for x in range(n):
	print(a[0],a[1])
	b = [j for j in input().split()]
	if b[0] == a[0]:
		a[0] = b[1]
	else:
		a[1] = b[1]

print(a[0],a[1])