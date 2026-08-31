def fastio():
	import sys
	from io import StringIO 
	from atexit import register
	global input
	sys.stdin = StringIO(sys.stdin.read())
	input = lambda : sys.stdin.readline().rstrip('\r\n')
	sys.stdout = StringIO()
	register(lambda : sys.__stdout__.write(sys.stdout.getvalue()))
fastio()

MOD = 10**9 + 7
INF = 10**20
I = lambda:list(map(int,input().split()))
from collections import defaultdict as dd
from math import gcd

t, = I()
while t:
	t -= 1
	n, = I()
	d = {}
	a = I()
	for i in a:
		d[i] = d.get(i, 0) + 1
	s = sorted(d.keys(), reverse = 1)
	if len(s) <= 2:
		print(0, 0, 0)
		continue
	sm = 0
	i = 0
	while i < len(s) and sm + d[s[i]] <= n//2:
		sm += d[s[i]]
		i += 1
	g = d[s[0]]
	b = d[s[1]]
	sm = sm - g - b
	j = 2

	while b <= g and j < i:
		b += d[s[j]]
		sm -= d[s[j]]
		j += 1
	if g > 0 and b > 0 and sm > 0 and g < b and g < sm:
		print(g, b, sm)
	else:
		print(0, 0, 0)


	


	