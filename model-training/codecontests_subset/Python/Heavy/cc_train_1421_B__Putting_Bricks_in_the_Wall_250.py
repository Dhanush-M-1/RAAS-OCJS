from collections import Counter, OrderedDict
from itertools import permutations as perm
from sys import setrecursionlimit
from collections import deque
from sys import stdin
from bisect import *
from heapq import *
import threading
import math
 
g   = lambda : stdin.readline().strip()
gl  = lambda : g().split()
gil = lambda : [int(var) for var in gl()]
gfl = lambda : [float(var) for var in gl()]
gcl = lambda : list(g())
gbs = lambda : [int(var) for var in g()]
mod = int(1e9)+7
inf = float("inf")
 
t, = gil()

for _ in range(t):
	n, = gil()
	mat = []
	for _ in range(n):
		mat.append(g())
	start, end = [mat[1][0], mat[0][1]], [mat[-1][-2], mat[-2][-1]]
	start.sort();end.sort()
	if start == end and start[0] == start[1]:# 00 11 
		print(2)
		print(0+1, 1+1)
		print(1+1, 0+1)
	elif start == end and start[0] != start[1]: # 01 10
		print(2)
		print(0+1, 1+1)
		state = mat[0][1]
		if state != mat[n-1][n-2]:
			print(n-1+1, n-2+1)
		else:
			print(n-2+1, n-1+1)
	elif start[0] == start[1] and end[0] == end[1] and start[0] != end[0]: # 00/11; 
		print(0)
	elif start[0] == start[1]: # 00/11 ; 01 10
		state = mat[0][1]
		print(1)
		if state == mat[n-1][n-2]:
			print(n-1+1, n-2+1)
		else:
			print(n-2+1, n-1+1)
	elif end[0] == end[1]:
		state = mat[n-1][n-2]
		print(1)
		if state == mat[0][1]:
			print(0+1, 1+1)
		else:
			print(1+1, 0+1)
	else:
		print(0)




