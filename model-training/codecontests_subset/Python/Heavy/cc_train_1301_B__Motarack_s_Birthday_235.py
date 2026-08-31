
for _ in range(int(input())):
	n = int(input())
	arr = [int(i) for i in input().split()]
	ele = []
	if arr[0]==-1:
		if arr[1] != -1:
			ele.append(arr[1])
	if arr[-1] == -1:
		if arr[-2] != -1:
			ele.append(arr[-2])
	for i in range(1,len(arr)-1):
		if arr[i] == -1:
			if arr[i+1] != -1:
				ele.append(arr[i+1])
			if arr[i-1] != -1:
				ele.append(arr[i-1])
	ans = -1
	for i in range(len(arr)-1):
		if arr[i]!=-1:
			if arr[i+1]!=-1:
				ans = max(ans, abs(arr[i]-arr[i+1]))
	if len(ele) == 0:
		print(0,0)
		continue
	else:
		mx = max(ele)
		mn = min(ele)
		k = (mx+mn)//2
		ans = max(abs(mn-k), abs(mx-k), ans)
		print(ans,k)
