t = int(input())
for te in range(t):
	n = int(input())	
	a = [int(x) for x in input().split()]
	a.sort()
	if (a[0] + a[1] <= a[n - 1]):
		print(1, 2, n)
	else:
		print(-1)
	
	