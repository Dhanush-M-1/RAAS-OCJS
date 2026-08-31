 ######      ###      #######    #######    ##      #     #####        ###     ##### 
 #     #    #   #          #        #       # #     #    #     #      #   #     ###  
 #     #   #     #        #         #       #  #    #   #       #    #     #    ###  
 ######   #########      #          #       #   #   #   #           #########    #   
 ######   #########     #           #       #    #  #   #           #########    #   
 #     #  #       #    #            #       #     # #   #    ####   #       #    #   
 #     #  #       #   #             #       #      ##   #    #  #   #       #        
 ######   #       #  #######     #######    #       #    #####  #   #       #    #   
 
from __future__ import print_function # for PyPy2
# from itertools import permutations
# from functools import cmp_to_key  # for adding custom comparator
# from fractions import Fraction
from collections import *
from sys import stdin
from bisect import *
from heapq import *
from math import log2
 
g   = lambda : stdin.readline().strip()
gl  = lambda : g().split()
gil = lambda : [int(var) for var in gl()]
gfl = lambda : [float(var) for var in gl()]
gcl = lambda : list(g())
gbs = lambda : [int(var) for var in g()]
rr = lambda x : reversed(range(x)) 
mod = int(1e9)+7
inf = float("inf")

n, = gil()
s = [ord(ch)-97 for ch in g()]
q, = gil()

ans = [[0 for _ in range(n+1)] for _ in range(26)]
prev, new = [0]*n, [0]*n

for ch in range(26):
    maxi = 0
    for i in range(n):
        prev[i] = (1 if s[i] == ch else 0) + (prev[i-1] if i and s[i]== ch else 0) 
        maxi = max(prev[i], maxi)
    ans[ch][0] = maxi

    for mi in range(1, n+1):
        maxi = 0 
        for i in range(n):
            aprev, sprev = prev[i-1] if i else 0, new[i-1] if i else 0
            if ch == s[i]:
                new[i] = sprev + 1
            else:
                new[i] = aprev + 1
            maxi = max(maxi, new[i])
        ans[ch][mi] = maxi
        prev, new = new, prev

fin = []

for _ in range(q):
    mi, ch = gl()
    fin.append(str(ans[ord(ch)-97][int(mi)]))

print('\n'.join(fin))