from itertools import combinations
n, m = map(int, input().split())
lamps = [0] * (m + 1)
for i in range(n):
	for j in list(map(int, input().split()))[1:]:
		lamps[j] += 1
if lamps.count(0) == 1:
	print('YES')
else:
	print('NO')
