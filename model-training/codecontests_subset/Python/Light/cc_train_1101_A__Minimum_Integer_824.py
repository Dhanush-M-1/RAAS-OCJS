q = int(input())
for i in range(q):
	l, r, d = map(int, input().split())
	if d <= l:
		if d < l:
			k1 = d
		else:
			k1 = l - d
	else:
		k1 = 0
	if r % d != 0:
		if r > d:
			r1 = r + (d - r % d)
		else:
			r1 = d
	else:
		r1 = r + d
	if k1 <= 0:
		print(r1)
	elif k1 < r1:
		print(k1)
	else:
		print(r1)
