t = int(input())
for _ in range(t):
	n  = int(input())
	arr = list(map(int, input().split()))
	result = False
	for i in range(n-1):
		if arr[i]+arr[i+1]<=arr[n-1]:
			print(i+1,i+2,n)
			result = True
			break
	if result == False:
		print(-1)