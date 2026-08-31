for nt in range(int(input())):
	n = int(input())
	b = list(map(int,input().split()))
	c = list(map(int,input().split()))
	a = [[b[i], c[i]] for i in range(n)]
	a.sort()
	if a[0]==[1, 1]:
		a.pop(0)
		n -= 1
	ans = 0
	i = 0
	curr = [1, 1]
	while i<n and a[i][0]==a[i][1]:
		ans += (a[i][0]-curr[0])
		curr = a[i]
		i += 1

	odd = sum(curr)%2

	while i<n:
		# print (i, ans)
		if a[i][0]-a[i][1] == curr[0]-curr[1]:
			if not odd:
				ans += (a[i][0]-curr[0])
		else:
			if odd:
				ans += ((a[i][0]-a[i][1])-(curr[0]-curr[1])-1)//2+1
			else:
				ans += ((a[i][0]-a[i][1])-(curr[0]-curr[1]))//2
		curr = a[i]
		odd = sum(curr)%2
		i += 1
	print (ans)

