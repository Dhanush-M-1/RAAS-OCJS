for i in range(int(input())):
	n = int(input())
	a = list(map(int,input().split()))
	print("1 2 "+str(n) if len(a) >= 3 and a[0]+a[1] <= a[n-1] else -1)