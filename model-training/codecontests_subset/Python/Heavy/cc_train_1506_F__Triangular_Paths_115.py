import sys,math,itertools
from collections import Counter,deque,defaultdict
from bisect import bisect_left,bisect_right 
from heapq import heappop,heappush,heapify
from copy import deepcopy,copy
mod = 10**9+7
INF = float('inf')
def inp(): return int(sys.stdin.readline())
def inpl(): return list(map(int, sys.stdin.readline().split()))
def inpl_1(): return list(map(lambda x:int(x)-1, sys.stdin.readline().split()))
def inps(): return sys.stdin.readline()
def inpsl(x): tmp = sys.stdin.readline(); return list(tmp[:x])
def err(x): print(x); exit()

for _ in range(inp()):
    n = inp()
    r = inpl()
    c = inpl()
    rc = [(r[i],c[i]) for i in range(n)]
    rc.sort()
    _sa,_r = 0,1
    res = 0
    for r,c in rc:
        sa = r-c
        if _sa%2==0:
            if _sa == sa:
                res += r-_r
            else:
                res += (sa-_sa)//2
        else:
            tmp = sa-_sa
            res += -(-tmp//2)
        _sa,_r = sa,r
    print(res)