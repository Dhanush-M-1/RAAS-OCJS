n, m = map(int,input().split())
s = set()
for i in range(n):
	lamps = list(map(int, input().split()))
	s.update(lamps[1:])
if len(s) == m:
	print('YES')
else:
	print('NO')
