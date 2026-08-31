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
from collections import defaultdict as dd, Counter as C

n, m = I()
a = sorted(I())
b = sorted(I())
ac = C(a)
bc = C(b)
k = bc[b[0]]
ans = 10**20
def check(x):
	# print(x)
	t = a[:]
	for i in range(n):
		t[i] = (t[i] + x) % m
	tc = C(t)
	# print(tc, bc, tc == bc, x)
	return tc == bc
for i in ac:
	# print(i - b[0])
	if ac[i] == k and check((b[0] - i)%m):
		ans = min(ans, (b[0] - i)%m)
print(ans)