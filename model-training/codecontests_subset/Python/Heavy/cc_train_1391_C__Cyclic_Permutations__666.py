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

n = int(input())
mod = int(1e9+7)
# calc x**y mod p
def modPow(x, y, p):
    res,x = 1,x%p
    while(y>0):
        if(y&1)==1: res=(res*x)%p
        y,x = y>>1,(x*x)%p
    return res

def fact(n):
    res = 1
    for i in range(2,n+1):
        res*=i
        res%=mod
    return res

print((fact(n)-modPow(2,n-1,mod))%mod)
