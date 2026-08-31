def wizard():
	k = 3
	n, x, y = list(map(int,input().strip().split()))[:k]
	res = int((n*y / 100) + ((n*y % 100) != 0)) - x
	if res > 0:
		return res
	else:
		return 0

print(wizard())