# code by RAJ BHAVSAR
for _ in range(int(input())):
	n = int(input())
	arr = list(map(int,input().split()))
	flag = 0
	for i in range(1,n):
		t = arr[i] + arr[i-1]
		if(i != n-1):
			if(arr[n-1] >= t):
				flag = 1
				print(i,i+1,n)
				break
	if(flag == 0):
		print(-1)