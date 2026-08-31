T = int(input())
while T > 0:
	n = int(input())
	arr = list(map(int, input().split()))
	if arr[0]+arr[1] > arr[n-1]:
		print(-1)
	else:
		print(1, 2, n)
	T -= 1