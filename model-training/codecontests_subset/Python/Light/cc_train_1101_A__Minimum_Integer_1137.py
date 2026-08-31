n = int(input())
for i in range(n):
	a = [int(s) for s in input().split()]
	l = a[0]
	r = a[1]
	d = a[2]
	if d <= r and d >= l:
		print((r // d + 1) * d)
	else:
		print(d)