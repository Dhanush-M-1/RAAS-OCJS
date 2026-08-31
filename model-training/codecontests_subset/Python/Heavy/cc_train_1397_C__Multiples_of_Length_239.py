import math
from sys import stdin
g   = lambda : stdin.readline().strip()
gl  = lambda : g().split()
gil = lambda : [int(var) for var in gl()]
gfl = lambda : [float(var) for var in gl()]
gcl = lambda : list(g())
gbs = lambda : [int(var) for var in g()]
mod = int(1e9)+7
inf = float("inf")

n, = gil()
a = gil()

if n == 1:
	v = a[0]+2
	# k + v = 0
	print(1, 1)
	print(1)
	print(1, 1)
	print(1)
	print(1, 1)
	print(-v)
else:
	print(n, n)
	print(-a[-1])
	a[-1] = 0
	print(1, n-1)
	for i in range(n-1):
		md = a[i]%n # [0, n-1]
		if md :
			cmd = n - md # [1, n-1]
			val = (n-cmd)*(n-1)
			a[i] += val
			print(val, end = " ")
		else:
			print(0, end = " ")
	print()
	print(1, n)
	for val in a:
		print(-val, end=" ")
	print()



