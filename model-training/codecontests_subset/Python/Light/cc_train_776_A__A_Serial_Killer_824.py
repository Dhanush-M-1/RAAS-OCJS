
a = input().split()

n = int(input())

for i in range(n):
	print(' '.join(a))
	ki, p = input().split()
	if a[0] == ki:
		a[0] = p
	else:
		a[1] = p

print(' '.join(a))