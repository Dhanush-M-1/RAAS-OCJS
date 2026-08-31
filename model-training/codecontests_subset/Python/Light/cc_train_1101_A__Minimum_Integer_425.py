n = int(input())
for i in range(n):
	l, r, d = map(int, input().split())
	if r < 0:
		print(d)
		continue
	elif l > d:
		print(d)
		continue
	else:
		if r % d == 0:
			print(r + d)
			continue
		else:
			print(r // d * d + d)
			continue
