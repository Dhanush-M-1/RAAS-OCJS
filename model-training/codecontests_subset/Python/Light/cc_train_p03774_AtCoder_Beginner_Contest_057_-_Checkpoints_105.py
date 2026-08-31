n, m = map(int, input().split())
AB = [tuple(map(int, input().split())) for i in range(n)]
CD = [tuple(map(int, input().split())) for i in range(m)]
for a, b in AB:
	minv = p = float('inf')
	for i, (c, d) in enumerate(CD):
		dist = abs(a - c) + abs(b - d)
		if dist < minv:
			minv = dist
			p = i + 1
	print(p)