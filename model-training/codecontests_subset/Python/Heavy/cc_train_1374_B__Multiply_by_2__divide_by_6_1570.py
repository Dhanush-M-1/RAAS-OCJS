from sys import stdin, stdout
import math
cin = stdin.readline
cout = stdout.write
mp = lambda:list(map(int, cin().split()))

def mlog(a, b):
	x = 0
	while not a%b:
		x += 1
		a //= b
	return x
	'''
	x = int(math.log(a, b))
	if b**x == a:
		return x
	return x+1
	'''

t, = mp()
for _ in range(t):
	n, = mp()
	
	#y = n
	#z = n
	count2 = mlog(n, 2)
	count3 = mlog(n, 3)
	
	if count2 > count3:
		cout('-1\n')
	else:
		if 2**count2 * 3** count3 == n:
			cout(str(count3*2 - count2) + '\n')
		else:
			cout('-1\n')
	#print(count2, count3)
	#print(y,z)
	#if n*(2**z) == 6**y:
	#	cout(str(y+z) + '\n')
	#else:
	#	#print(y, z)
	#	cout('-1\n')
	