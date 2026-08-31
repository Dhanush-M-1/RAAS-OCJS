from sys import stdin
g   = lambda : stdin.readline().strip()
gl  = lambda : g().split()
gil = lambda : [int(var) for var in gl()]
gcl = lambda : list(g())
gbs = lambda : [int(var) for var in g()]
mod = int(1e9)+7
inf = float("inf")

t, = gil()
from bisect import *
for _ in range(t):
	n, = gil()
	a = gil()
	if a[0]+a[1] <= a[-1] :
		print(1, 2, n)
	else:
		print(-1)