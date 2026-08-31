for _ in range(int(input().strip())):
	l, r, d = map(int, input().strip().split())
	if d < l or d > r:
		print(d)
	else:
		print(r - r%d + d)
