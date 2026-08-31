t = int(input())

for asdasd in range(t):
	n = int(input())
	a = [int(x) for x in input().split()]
	p = a[0]
	q = a[1]
	r = a[n-1]
	if(p+q <= r):
		print(1,2,n)
	else:
		print("-1")

