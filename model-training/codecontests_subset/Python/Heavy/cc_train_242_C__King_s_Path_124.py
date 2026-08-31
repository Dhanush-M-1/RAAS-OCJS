 ######      ###      #######    #######    ##      #     #####        ###     ##### 
 #     #    #   #          #        #       # #     #    #     #      #   #     ###  
 #     #   #     #        #         #       #  #    #   #       #    #     #    ###  
 ######   #########      #          #       #   #   #   #           #########    #   
 ######   #########     #           #       #    #  #   #           #########    #   
 #     #  #       #    #            #       #     # #   #    ####   #       #    #   
 #     #  #       #   #             #       #      ##   #    #  #   #       #        
 ######   #       #  #######     #######    #       #    #####  #   #       #    #   

from __future__ import print_function # for PyPy2
from collections import Counter, OrderedDict
from itertools import permutations as perm
from fractions import Fraction
from collections import deque
from sys import stdin
from bisect import *
from heapq import *
from math import *

g   = lambda : stdin.readline().strip()
gl  = lambda : g().split()
gil = lambda : [int(var) for var in gl()]
gfl = lambda : [float(var) for var in gl()]
gcl = lambda : list(g())
gbs = lambda : [int(var) for var in g()]
mod = int(1e9)+7
inf = float("inf") 


sx, sy, ex, ey = gil()
d, h = {}, []
for _ in range(gil()[0]):
	r, L, R = gil()
	for c in range(L, R+1):
		d[r, c] = inf


if (sx, sy) not in d or (ex, ey) not in d :
	print(0 if (sx, sy) == (ex, ey) else -1)
	exit()

d[sx, sy] = 0
h.append((0, sx, sy))
perm = [(-1, -1), (1, 0), (0, 1), (1, 1), (0, -1), (-1, 0), (-1, 1), (1, -1)]

while h:
	di, x, y = heappop(h)
	if d[x, y] != di:continue
	for dx, dy in perm:
		p = (x+dx, y+dy)
		if p in d and d[p] > di+1:
			d[p] = di + 1
			heappush(h, (di+1, p[0], p[1]))

print(-1 if d[ex, ey] == inf else d[ex, ey])
