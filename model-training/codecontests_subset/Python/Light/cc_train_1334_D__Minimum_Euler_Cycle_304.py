for _ in range(int(input())):
	n, l, r = map(int, input().split())
	x = 0
	off = 0
	for i in range(1, n+1):
		if x + 2 * (n-i) >= l:
			off = l-x-1
			break

		x += 2 * (n-i)

	series = []

	while len(series) < (r-l+1) + off:
		for j in range(i+1, n+1):
			series.append(i)
			series.append(j)

		i += 1

		if i >= n:
			series.append(1)
			break

	print (' '.join(list(map(str, series[off:off+r-l+1]))))

