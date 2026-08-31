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
I = lambda:list(map(int,input().split()))
from math import gcd
from collections import defaultdict as dd

t, = I()
while t:
	t -= 1
	s, c = [list(i) for i in input().split()]
	i, j = 0, 0
	n, m = len(s), len(c)
	# if s < c:
	# 	print(''.join(s))
	# 	continue
	l = ['Z'] * (n + 1)
	l[n] = ['Z', n]
	l[n-1] = [s[-1], n-1]
	for i in range(n-2, -1, -1):
		l[i] = l[i+1][:]
		if s[i] < l[i+1][0]:
			l[i] = [s[i], i]
	# print(l)
	for i in range(min(n, m)):
		if s[i] > l[i+1][0]:
			s[i], s[l[i+1][1]] = l[i+1][0], s[i]
			break
	if s < c:
		print(''.join(s))
	else:
		print('---')