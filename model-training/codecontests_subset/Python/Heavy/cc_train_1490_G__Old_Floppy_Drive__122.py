from os import path
import sys,time
# mod = int(1e9 + 7)
# import re
from math import ceil, floor,gcd,log,log2 ,factorial,sqrt
from collections import defaultdict ,Counter , OrderedDict , deque
# from itertools import combinations
# from string import ascii_lowercase ,ascii_uppercase
# from bisect import *
from functools import reduce
from operator import mul
maxx = float('inf')
#----------------------------INPUT FUNCTIONS------------------------------------------#
I = lambda :int(sys.stdin.buffer.readline())
tup= lambda : map(int , sys.stdin.buffer.readline().split())
lint = lambda :[int(x) for x in sys.stdin.buffer.readline().split()]
S = lambda: sys.stdin.readline().strip('\n')
grid = lambda  r :[lint() for i in range(r)]
stpr = lambda x : sys.stdout.write(f'{x}' + '\n')
star = lambda x: print(' '.join(map(str, x)))
localsys = 0
start_time = time.time()
if (path.exists('input.txt')):
    sys.stdin=open('input.txt','r');sys.stdout=open('output.txt','w');
#left shift --- num*(2**k) --(k - shift)
# st =ascii_lowercase
def bi(x):
	l ,  h = 0 , n-1
	res = n
	while l <= h :
		m = (l+h) >> 1
		if pref_m[m] >= x :
			res = m 
			h = m-1
		else:
			l = m+1
	return -1 if res == n else res

for _ in range(I()):
	n , m= tup()
	a = lint()
	b = lint()
	pre = [a[i] for i in range(n)]
	pref_m = [a[i] for i in range(n)]
	for i in range(1 , n ):
		pre[i]+=pre[i-1]
		pref_m[i] = max(pre[i], pref_m[i-1])

	if pre[-1] <= 0 :
		for x in b:
			print(bi(x),end = ' ')
	else:
		ma = max(pre)
		for x in b:
			t = max(0 , ceil((x - ma)/pre[-1]))
			print(t*n + bi(x - t*pre[-1]) ,end=' ' )
	print()

		









if localsys:
    print("\n\nTime Elased :",time.time() - start_time,"seconds")


