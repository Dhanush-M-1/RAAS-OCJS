for _ in range(int(input())):
	n = int(input())
	x = list(map(int, input().split()))
	a = []
	vis = [0]*n
	for i in range(n):
		if x[i] == -1:
			if i-1 >= 0 and vis[i-1] == 0 and x[i-1] != -1:
				a += [x[i-1]]
				vis[i-1] = 1

			if i+1 < n and vis[i+1] == 0 and x[i+1] != -1:
				a += [x[i+1]]
				vis[i+1] = 1

	if len(a) == 0:
		print(0, 1)
	else:
		a.sort()
		k = (a[0] + a[-1])//2
		for i in range(n):
			if x[i] == -1:
				x[i] = k
		m = max([abs(x[i+1] - x[i]) for i in range(n-1)])
		print(m, k)