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

n, x, y = I()
s = input()
k = ['0']*300000

k[-x-1] = '1'
k[-y-1] = '1'
# print(k)
ans = 0
for i in range(x):
	# print(k[-i-1], s[-i-1])
	ans += (k[-i-1] != s[-i-1])
print(ans)