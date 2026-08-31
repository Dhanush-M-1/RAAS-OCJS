 ######      ###      #######    #######    ##      #     #####        ###     ##### 
 #     #    #   #          #        #       # #     #    #     #      #   #     ###  
 #     #   #     #        #         #       #  #    #   #       #    #     #    ###  
 ######   #########      #          #       #   #   #   #           #########    #   
 ######   #########     #           #       #    #  #   #           #########    #   
 #     #  #       #    #            #       #     # #   #    ####   #       #    #   
 #     #  #       #   #             #       #      ##   #    #  #   #       #        
 ######   #       #  #######     #######    #       #    #####  #   #       #    #   
 
# from __future__ import print_function # for PyPy2
# from itertools import permutations as perm
# from fractions import Fraction
# from collections import *
from sys import stdin
from bisect import *
# from heapq import *
from math import *
 
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
	tag = gil()
	s = gil()
	ans = [0]*n

	for i in range(1, n):
		for j in reversed(range(i)):
			if tag[i] == tag[j]: continue
			ai, aj, x = ans[i], ans[j], abs(s[i]-s[j])
			ans[i], ans[j] = max(ans[i], aj + x), max(ans[j], ai + x)

	print(max(ans))