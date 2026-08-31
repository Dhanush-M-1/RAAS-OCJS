for t in range(int(input())):
	n=int(input())
	a=[int(i) for i in input().split()]
	x=1
	if a[0]+a[1]<=a[n-1]:
		print(1,2,n)
	else:
		print(-1)