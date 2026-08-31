for _ in range(int(input())):
	n = int(input())
	arr = list(map(int,input().split()))
	p = (arr[0]+arr[1]+arr[n-1])/2
	if p > arr[0] and p > arr[1] and p > arr[n-1]:
		print(-1)
	else:
		print("1 2",n)