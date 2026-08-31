from math import ceil
n, x, y = list(map(int, input().split()))
a = y / 100 * (n) - x
if a < 0:
	print(0)
else:
	print(ceil(a))