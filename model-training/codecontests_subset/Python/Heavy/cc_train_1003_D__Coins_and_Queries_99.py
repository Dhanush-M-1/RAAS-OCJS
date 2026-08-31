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

n,q = mapi()
a = list(mapi())
mp = defaultdict(int)
for i in a:
    j = 0
    while (i>>j)!=1:
        j+=1
    mp[j]+=1
st = max(mp.keys())
for i in range(q):
    m = int(input())
    res =0
    for j in range(st,-1,-1):
        coins = min(m>>j, mp[j])
        m-=(1<<j)*coins
        res+=coins
    if m:
        print(-1)
        continue
    print(res)
