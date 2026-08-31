for t in range(int(input())):
	n = input()
	a = [int(_) for _ in input().split()]
	if a[0]+a[1] <= a[-1]:
		print(1,2,n)
	else:
		print(-1)
