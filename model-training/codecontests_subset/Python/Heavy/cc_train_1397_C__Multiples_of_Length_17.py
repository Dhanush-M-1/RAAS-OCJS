import sys
import math,bisect
sys.setrecursionlimit(10 ** 5)
from collections import defaultdict
from itertools import groupby,accumulate
from heapq import heapify,heappop,heappush
from collections import deque,Counter,OrderedDict
def I(): return int(sys.stdin.readline())
def neo(): return map(int, sys.stdin.readline().split())
def Neo(): return list(map(int, sys.stdin.readline().split()))
n = I()
l = Neo()
if n == 1:
	s = "1 1\n"+str(-l[0])+"\n1 1\n0\n1 1\n0"
	print(s)
else:
	a,an = [],[]
	for i in range(n):
		an.append((-l[i])*n)
	b=-(l[0]+an[0])
	for i in range(1,n):
		a.append(l[i]*(n-1))
	print(1,n)
	print(*an)
	print(1,1)
	print(b)
	print(2,n)
	print(*a)
