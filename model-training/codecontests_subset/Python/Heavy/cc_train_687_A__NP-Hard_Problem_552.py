from collections import Counter as cntr
from math import inf
def cin():
	return map(int, input().split(' '))
n,m = cin()
g = {i:[] for i in range(n)}
for i in range(m):
	u, v = cin()
	u -= 1
	v -= 1
	g[u].append(v)
	g[v].append(u)
t = [0 for i in range(n)]
color = [-1 for i in range(n)]
flag = 0
for i in range(n):

	if t[i]: continue

	q = [i]
	t[i] = 1
	color[i] = 1
	while(len(q)>0):
		idx = q.pop()

		for v in g[idx]:
			if not t[v]:
				t[v] = 1
				color[v] = 3-color[idx]
				q.append(v)
			else:
				if color[v] == color[idx]:
					print(-1)
					exit(0)
l = cntr(color)
one = []
two = []
for v in range(n):
	if color[v]==1:
		one.append(v+1)
	else:
		two.append(v+1)
print(l[1])
print(*one)
print(l[2])
print(*two)

