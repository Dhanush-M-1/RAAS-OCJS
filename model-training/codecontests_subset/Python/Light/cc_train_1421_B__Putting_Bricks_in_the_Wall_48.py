import sys

def minp():
	return sys.stdin.readline().strip()

def mint():
	return int(minp())

def mints():
	return map(int, minp().split())

def solve():
	n = mint()
	a = [None]*n
	for i in range(n):
		a[i] = minp()
	c = [None,None,None,None]
	pos = [(0,1,0),(1,0,1),(2,n-1,n-2),(3,n-2,n-1)]
	#print(a)
	for i,x,y in pos:
		c[i] = a[x][y]
	for v in (0,0,1,1), (1,1,0,0):
		cnt = sum([int(c[i])^v[i] for i in range(4)])
		if cnt <= 2:
			print(cnt)
			for i,x,y in pos:
				if int(c[i]) != v[i]:
					print(x+1,y+1)
			return

for i in range(mint()):
	solve()
