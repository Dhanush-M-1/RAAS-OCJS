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

from collections  import Counter as C
k, = I()
s = input()
c = C(s)
for i in c:
	if c[i] % k:
		print(-1)
		exit()

s = ''
for i in c:
	s += i*(c[i]//k)
print(s*k)
