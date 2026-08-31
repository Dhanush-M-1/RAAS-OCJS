for _ in range(int(input())):
	n = int(input())
	a = list(map(int, input().split()))

	deal = {}
	for i in range(n):
		if i < n-1 and a[i] == -1 and a[i+1] != -1:
			deal[a[i+1]] = True
		if i > 0 and a[i] == -1 and a[i-1] != -1:
			deal[a[i-1]] = True

	dealers = deal.keys()
	if len(dealers) > 0:
		mine, maxe = min(dealers), max(dealers)
	
		k = (mine + maxe) // 2
		m = max(abs(mine - k), abs(maxe - k))

		a = list(map(lambda x: x if x != -1 else k, a))
		#print(a)

		for i in range(n-1):	
			m = max(m, abs(a[i] - a[i+1]))

		print(m, k)
	else:
		print(0, 0)
