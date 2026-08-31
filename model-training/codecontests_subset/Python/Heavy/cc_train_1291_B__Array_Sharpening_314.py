T = int(input())

for kse in range(T):
	n = int(input())
	a = list(map(int, input().split()))
	f = [i for i in range(n)]
	g = [i for i in range(n-1, -1, -1)]
	h = [min(f[i], g[i]) for i in range(n)]
	h1 = []
	h2 = []
	for i in h:
		h1.append(i)
		h2.append(i)
	for i in range(1, n):
		if h[i] == h[i-1]:
			h1[i] += 1
			h2[i-1] += 1
			break
	# print(h)
	# print(h1)
	# print(h2)
	ok = True
	if n%2:
		for i in range(n):
			if a[i] < h[i]:
				ok = False
				break
	else:
		A = True
		B = True
		for i in range(n):
			if a[i] < h1[i]:
				A = False
				break
		for i in range(n):
			if a[i] < h2[i]:
				B = False
				break
		ok = A or B
	if ok:
		print('Yes')
	else:
		print('No')

