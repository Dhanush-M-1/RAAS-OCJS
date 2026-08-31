import sys

def minp():
	return sys.stdin.readline().strip()

def mint():
	return int(minp())

def mints():
	return map(int, minp().split())

def solve():
	n = mint()
	d = [None]*n
	i = 0
	for v in mints():
		d[i] = (v, i+1)
		i += 1
	d.sort()
	a, b, c = d[0],d[1],d[-1]
	if a[0]+b[0] <= c[0]:
		print(*sorted([a[1],b[1],c[1]]))
	else:
		print(-1)

for i in range(mint()):
	solve()
