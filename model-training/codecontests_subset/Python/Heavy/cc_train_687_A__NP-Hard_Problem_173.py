import sys
from math import *

def minp():
	return sys.stdin.readline().strip()

def mint():
	return int(minp())

def mints():
	return map(int, minp().split())

n, m = mints()
e = [[] for i in range(n+1)]
for i in range(m):
	a, b = mints()
	e[a].append(b)
	e[b].append(a)

c = [0]*(n+1)
v = [0,0,0]
v[1] = []
v[2] = []
q = [0]*(n+1)
ql = 0
qr = 0
def dfs(x):
	global qr
	d = 3 - c[x]
	for i in e[x]:
		if c[i] == 0:
			v[d].append(i)
			c[i] = d
			q[qr] = i
			qr += 1
		elif c[i] != d:
			print(-1)
			exit(0)

for i in range(1, n+1):
	if c[i] == 0:
		c[i] = 1
		v[1].append(i)
		q[qr] = i
		qr += 1
		while ql < qr:
			dfs(q[ql])
			ql += 1

print(len(v[1]))
print(*v[1])
print(len(v[2]))
print(*v[2])
