for _ in range(int(input())):
	input()
	a = list(map(int,input().split()))
	if a[0]+a[1]<=a[-1]:print(1,2,len(a))
	else:print(-1)