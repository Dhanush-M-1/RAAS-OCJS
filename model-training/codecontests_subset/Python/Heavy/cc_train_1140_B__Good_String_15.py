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

t, = I()
while t:
	t -= 1
	n, = I()
	l = [0]
	s = input()
	if s[0] == '>' or s[-1] == '<':
		print(0)
	else:
		m = s[::-1]
		i = n-1
		while s[i] != '<':
			i -= 1
		# print(i, 1)
		print(min(n-i-1, s.index('>')))
