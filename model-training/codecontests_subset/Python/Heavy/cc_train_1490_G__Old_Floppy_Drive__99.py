t = int(input())
	
for _ in range(t):
	n, m = list(map(int ,input().split()))
	a = list(map(int,input().split()))
	xs = list(map(int,input().split()))
	pref = [a[i] for i in range(n)]
	pref_max = [a[i] for i in range(n)]
	for i in range(1, n):
		pref[i] += pref[i - 1]
		pref_max[i] = max(pref[i], pref_max[i - 1])

	dlt = pref[-1]
	ans = []
	if dlt <= 0:
		for x in xs:
			l = 0
			r = n - 1
			m = 0
			res = n
			while l <= r:
				m = (l + r) >> 1
				if pref_max[m] >= x:
					res = m
					r = m - 1
				else:
					l = m + 1
			if res == n:
				res = -1
			ans.append(str(res))
	else:
		mx = max(pref)
		for x in xs:
			k = max(0, (x - mx + dlt - 1) // dlt)
			x -= k * dlt
			l = 0
			r = n - 1
			m = 0
			res = n
			while l <= r:
				m = (l + r) >> 1
				if pref_max[m] >= x:
					res = m
					r = m - 1
				else:
					l = m + 1
			ans.append(str(k * n + res))
	print(' '.join(ans))
