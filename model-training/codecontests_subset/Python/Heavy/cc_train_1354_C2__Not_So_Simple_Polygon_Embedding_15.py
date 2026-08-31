from __future__ import division, print_function
import sys
if sys.version_info[0] < 3:
    from __builtin__ import xrange as range
    from future_builtins import ascii, filter, hex, map, oct, zip

import os, sys, bisect, copy
from collections import defaultdict, Counter, deque
#from functools import lru_cache   #use @lru_cache(None)
if os.path.exists('in.txt'): sys.stdin=open('in.txt','r')
if os.path.exists('out.txt'): sys.stdout=open('out.txt', 'w')
#
def input(): return sys.stdin.readline()
def mapi(arg=0): return map(int if arg==0 else str,input().split())
#------------------------------------------------------------------

from math import *
for _ in range(int(input())):
    #function is first increasing and then after 
    #meeting minima it's increasing so mimima 
    #can be find out using ternary search
    n = int(input())
    l = 0
    r = pi/(4*n)
    res = float("inf")
    while r-l>1e-9:
        mid1 = l+(r-l)/3
        mid2 = mid1+(r-l)/3
        a = cos(mid1)/sin(pi/(2*n))
        b = cos(mid2)/sin(pi/(2*n))
        res = min(res,a,b)
        if a<b: r = mid2
        else: l = mid1
    print(res)