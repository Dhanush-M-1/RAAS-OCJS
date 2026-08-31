import sys,math,itertools
from collections import Counter,deque,defaultdict
from bisect import bisect_left,bisect_right 
from heapq import heappop,heappush,heapify, nlargest
from copy import deepcopy
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
    a = inpl()
    p = {}
    for i,x in enumerate(a):
        p[x] = i
    res = [0]*n
    def dfs(l,r,c=0):
        mx = -1; ind = -1
        for i in range(l,r):
            if a[i] > mx: ind = i; mx = a[i]
        res[mx-1] = c
        if ind-l>0: dfs(l,ind,c+1)
        if r-ind-1>0: dfs(ind+1,r,c+1)
    dfs(0,n)
    ans = [-1]*n
    for i,x in enumerate(res):
        ans[p[i+1]] = x
    print(*ans)