for t in range(int(input())):
	n = int(input())
	a = list(map(int, input().split()))
	v = a[0] + a[1]
	ans = 0
	for i in range(2,n):
		if a[i] >= v:
			ans = i
			break

	if ans:
		print(1,2,ans+1)
	else:
		print(-1)
